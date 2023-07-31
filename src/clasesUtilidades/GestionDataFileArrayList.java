package clasesUtilidades;

import java.io.*;
import java.util.*;

/**
 * El funcionamiento de esta clase es el manejo de los datos separados por
 * caracteres de un archivo .txt, esta clase se usara el arraylist para procesar
 * y cargar los datos de una manera mas dinamica sin tener que conocer cuantos
 * registros hay en el archivo.
 *
 * Incluye metodos para consultar, eliminar, agregar y modificar.
 *
 * Hay que acordar que para poder modificar un txt y obtener un campo del
 * registro en especifico se requerira el uso de separadores y este caso la
 * clase iniciara el seprador como un ANDPERSAND en caso de queres modificarlo
 * sera con el setSeparador o utlizar otro constructor segun las necesidades del
 * programador.
 *
 * El primer campo o primera columna del registro siempre sera el identificador
 * o ID.
 *
 * @author: Albin Liang
 * @version: 7/2023
 *
 */
public class GestionDataFileArrayList {

  private String ruta; // ubicacio del archivo 
  private String separador; // es que que separa los datos de un registro
  private int campos; // El numero de atributos que va tener cada registro
// Clase para manejo de archivos
  private FileWriter archivoEscritura;
  private BufferedWriter bufferEscritura;
  private PrintWriter escritor;
  private FileReader archivoLectura;
  private BufferedReader bufferLectura;

  public GestionDataFileArrayList() {
    ruta = "Archivo.txt";
    separador = "&";
    campos = 2;
  }

  public GestionDataFileArrayList(String ruta, int campos) {
    this.ruta = ruta;
    this.campos = campos;
    this.separador = "&";
  }

  public GestionDataFileArrayList(String ruta, String separador, int campos) {
    this.ruta = ruta;
    this.separador = separador;
    this.campos = campos;
  }

  public String getRuta() {
    return ruta;
  }

  public void setRuta(String ruta) {
    this.ruta = ruta;
  }

  public String getSeparador() {
    return separador;
  }

  public void setSeparador(String separador) {
    this.separador = separador;
  }

  public int getCampos() {
    return campos;
  }

  public void setCampos(int campos) {
    this.campos = campos;
  }

  public String prepararRegistro(String registro[]) {
    String tupla = String.join(separador, registro);
    return tupla;
  }

  /**
   * Agrega el registro al archivo .txt
   *
   * @param registro Es un vector que contiene los datos del registo
   * @return Devuelve una confirmacion
   */
  public String agregarRegistro(String registro[]) {
    String tupla = "No se registro";
    try {
      if (registro.length == campos) {
        tupla = prepararRegistro(registro);
        archivoEscritura = new FileWriter(ruta, true);
        bufferEscritura = new BufferedWriter(archivoEscritura);
        escritor = new PrintWriter(bufferEscritura);
        escritor.println(tupla);
        escritor.flush();
        escritor.close();
      }
    } catch (IOException e) {
      tupla = "No se pudo registrar " + e;
    }
    return tupla;
  }

  /*
  Cierra la conexion con la base de datos (Archivo).
   */
  private void cerrarObjetoEscrituras() {
    try {
      archivoLectura.close();
      bufferLectura.close();
    } catch (IOException e) {
      System.out.println("No se pudo cerrar");
    }
  }

  /**
   * Carga todo los registros del archivo de linea por linea a un Arraylist y lo
   * devuelve
   *
   * @return
   */
  public ArrayList<String> obtenerRegistros() {
    String temporal = "";
    ArrayList<String> listaRegistro = new ArrayList<>();
    try {
      archivoLectura = new FileReader(ruta);
      bufferLectura = new BufferedReader(archivoLectura);
      while ((temporal = bufferLectura.readLine()) != null) {
        listaRegistro.add(temporal);
      }
    } catch (IOException e) {
      System.err.println("No se pudo obtener los registros " + e);
    } finally {
      cerrarObjetoEscrituras();
    }
    return listaRegistro;
  }

  /**
   * Carga los registros del archivo y lo devuelve en un vector
   */
  public String[] getVectorRegistro() {
    String temporal = "";
    int i = 0;
    String vectorRegistro[] = new String[contarRegistros()];
    try {
      archivoLectura = new FileReader(ruta);
      bufferLectura = new BufferedReader(archivoLectura);
      while ((temporal = bufferLectura.readLine()) != null) {
        vectorRegistro[i] = temporal;
        i++;
      }
    } catch (IOException e) {
      System.err.println("No se pudo obtener los registros " + e);
    } finally {
      cerrarObjetoEscrituras();
    }
    return vectorRegistro;
  }

  /**
   * Carga por referencia una lista o arraylist los registros del archivo
   */
  public void cargarRegistros(ArrayList<String> listaRegistro) {
    String temporal = "";
    try {
      archivoLectura = new FileReader(ruta);
      bufferLectura = new BufferedReader(archivoLectura);
      while ((temporal = bufferLectura.readLine()) != null) {
        listaRegistro.add(temporal);
      }
    } catch (IOException e) {
      System.err.println("No se pudo obtener los registros " + e);
    } finally {
      cerrarObjetoEscrituras();
    }
  }

  /*
  Devuelve la linea consultada por el ID
  **/
  public String consultarRegistro(String id) {
    String registro = "No se  encontro -----> " + id;
    ArrayList<String> temporal = new ArrayList<>();
    cargarRegistros(temporal);
    for (int i = 0; i < temporal.size(); i++) {
      if (temporal.get(i).trim().length() >= campos) {
        if (temporal.get(i).split(separador)[0].equals(id)) {
          registro = temporal.get(i);
          break;
        }
      }
    }
    return registro;
  }

  /**
   * Elimina un registo del archivo por si ID
   */
  public String eliminarRegistro(String id) {
    String registro = "No se elimino= " + id;
    ArrayList<String> temporal = new ArrayList<>();
    cargarRegistros(temporal);
    int ubicacion = ubicarRegistro(id);
    if (ubicacion != -1) {
      registro = temporal.remove(ubicacion);
      if (!temporal.isEmpty()) {
        sobreescribirArchivo(tablaRegistroExcluido(temporal));
      } else {
        borrarRegistros();
      }
    }

    return registro;
  }

  /**
   * Ubica en que linea se encuantra el registro
   */
  public int ubicarRegistro(String id) {
    ArrayList<String> temporal = new ArrayList<>();
    cargarRegistros(temporal);
    return temporal.indexOf(consultarRegistro(id));
  }

  /*
  Vacia todo el registro o elimina todos los registros del archivo
  **/
  public void borrarRegistros() {
    try {
      archivoEscritura = new FileWriter(ruta);
      archivoEscritura.write("");
      archivoEscritura.close();
    } catch (IOException e) {
      System.err.println("No se pudo vaciar sobre el archivo");
    }
  }

  /**
   * Para escribir algo dentro del archivo, pero eliminando lo que estaba
   * actualmente y reemplazandolo con lo que se va agregar
   */
  public void sobreescribirArchivo(String contenido) {
    try {
      borrarRegistros();
      archivoEscritura = new FileWriter(ruta, true);
      bufferEscritura = new BufferedWriter(archivoEscritura);
      escritor = new PrintWriter(bufferEscritura);
      escritor.println(contenido);
      escritor.flush();
    } catch (IOException e) {
      System.err.println("No se pudo actualizar el archivo");
    }
  }

  /**
   * Complementa una funcion para el metodo eliminar
   */
  public String tablaRegistroExcluido(ArrayList<String> tabla) {
    String contenido = "";

    for (int i = 0; i < tabla.size(); i++) {
      if (i < tabla.size() - 1) {
        contenido += tabla.get(i) + "\n";
      } else {
        contenido += tabla.get(i);
      }
    }

    return contenido;
  }

  /**
   * Muestra el contenido del archivo en String
   */
  public String tablaAString(ArrayList<String> tabla) {
    String contenido = "";
    for (String i : tabla) {
      contenido += i + "\n";
    }
    return contenido;
  }

  /**
   * Retorna el numero de registros
   */
  public int contarRegistros() {
    return obtenerRegistros().size();
  }

  /**
   * Para actualizar un registro segun el campo o columna deseada
   */
  public String modificarRegistro(String id, String datoActualizado, int campo) {
    String registroModifcado = "NULL";
    ArrayList<String> temporal = new ArrayList<>();
    int ubicacion = ubicarRegistro(id);
    if (ubicacion != -1) {
      registroModifcado = id;
      cargarRegistros(temporal);
      temporal.set(ubicacion, String.join(separador, modificar(id, datoActualizado, campo)));
      sobreescribirArchivo(tablaRegistroExcluido(temporal));
    }
    return registroModifcado;
  }

  /**
   * Consulta un atributo del registro segun su campo
   */
  public String consultarCampo(String id, int campo) {
    String salida = "";
    if (ubicarRegistro(id) != -1) {
      salida = consultarRegistro(id).split(separador)[campo];
    }
    return salida;
  }

  /**
   * Complementa al metodo modificarRegistro
   */
  private String[] modificar(String id, String datoActualizado, int campo) {
    String vector[];
    vector = consultarRegistro(id).split(separador);
    vector[campo] = datoActualizado;
    return vector;
  }

  /**
   * Basicament reemplaza el registro por uno nuevo a su totalidad o uno
   * actualizado
   */
  public void modificarPorReemplazo(String id, String registroModificado[]) {
    ArrayList<String> temporal = new ArrayList<>();
    int ubicacion = ubicarRegistro(id);
    if (ubicacion != -1) {
      cargarRegistros(temporal);
      temporal.set(ubicacion, String.join(separador, registroModificado));
      sobreescribirArchivo(tablaRegistroExcluido(temporal));
    }
  }

  /**
   * Representa el archivo en una matriz
   */
  public String[][] toMatriz() {
    String temporal = "";
    String matriz[][] = new String[contarRegistros()][campos];
    String vectorTemporal[] = null;
    int fila = 0;
    try {
      archivoLectura = new FileReader(ruta);
      bufferLectura = new BufferedReader(archivoLectura);
      while ((temporal = bufferLectura.readLine()) != null) {
        try {
          vectorTemporal = temporal.split(separador);
          for (int i = 0; i < campos; i++) {
            matriz[fila][i] = vectorTemporal[i];
          }

        } catch (Exception e) {
          vectorTemporal = temporal.replace("", "null").split(separador);
          for (int i = 0; i < campos; i++) {
            matriz[fila][i] = vectorTemporal[i].replace("null", "");
          }
        }

        fila++;
      }
    } catch (IOException e) {
      System.err.println("No se pudo obtener los registros " + e);
    } finally {
      cerrarObjetoEscrituras();
    }
    return matriz;
  }

  /**
   * Representa el objeto en una cadena, sera segun el archivo asignado
   */
  public String toString() {
    String salida = "Inicio tabla ------------------------------------------->\n"
            + tablaAString(obtenerRegistros())
            + "Fin de la tabla ------------------------------------------->";
    return salida;
  }
}
