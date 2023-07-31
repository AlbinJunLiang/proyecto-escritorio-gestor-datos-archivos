package moduloRegistro.modelo;

import java.io.*;
import java.util.*;
import clasesUtilidades.*;
import moduloGestion.vista.*;


/**
 * Se encarga de mantener la logica y comunicacion de datos con la carpeta que
 * guarda las tablas y se accedera a ella a traves de la ruta persistencia del
 * archivo defecto por medio de la clase GestionDataFileArrayList.
 *
 * @author: Albin Liang
 * @version: 7/2023
 *
 */
public class ModeloRegistro {

  private int tablasGeneradas = 0; // Contara el numero de tablas que se va a visualizar en la vista
  private GestionDataFileArrayList rutaArchivoGestor;
  private ArrayList<String> listaArchivos;
  private VentanaGestion ventanaGestion;
  private String archivoSeleccionado; // Almacenara el nombre de la tabla o archivo .txt
  private String rutaArchivoDefecto;

  public ModeloRegistro() {
    crearCarpetaYArchivoDefecto(System.getProperty("user.dir") + "\\rutaPersistencia", "ArchivoDefecto.txt");
    rutaArchivoGestor = new GestionDataFileArrayList(rutaArchivoDefecto(), 2); // para dar conexion al archivo defecto
    cargarVectorArchivos();

  }

  /**
   * Devuelve la ruta que se esta trabajando mas el nombre del archivo que
   * almacena la ruta de persistencia
   */
  private String rutaArchivoDefecto() {
    return System.getProperty("user.dir") + "\\rutapersistencia\\ArchivoDefecto.txt";
  }

  /**
   * En caso de que se haya eliminado o que no exista la carpeta de persistencia
   * y el archivo defecto, se creara automaticamente
   */
  private void crearCarpetaYArchivoDefecto(String rutaCarpeta, String nombreArchivo) {
    File carpeta = new File(rutaCarpeta);
    if (!carpeta.exists()) {
      // Crea la carpeta
      if (carpeta.mkdirs()) {
        System.out.println("Carpeta creada: " + rutaCarpeta);
      } else {
        System.out.println("No se pudo crear la carpeta.");
        return;
      }
    }
    File archivo = new File(rutaCarpeta + File.separator + nombreArchivo);
    if (!archivo.exists()) {
      try {
        // Crear el archivo
        if (archivo.createNewFile()) {
          System.out.println("Archivo creado: " + nombreArchivo);
        } else {
          System.out.println("No se pudo crear el archivo.");
        }
      } catch (IOException e) {
        System.out.println("Error al crear el archivo: " + e.getMessage());
      }
    }
  }

  /**
   * Carga el vector con los nombres de cada tabla encontrada en la carpeta que
   * va almacenar los archivos
   */
  public void cargarVectorArchivos() {
    listaArchivos = obtenerArchivosTxtEnCarpeta(rutaArchivoGestor.consultarCampo("ruta", 1).trim());
  }

  /**
   * Para eliminar una tabla de la carpeta segun la ruta proporcionada
   */
  public static void eliminarArchivoTXT(String rutaArchivo) {
    File archivo = new File(rutaArchivo);
    if (archivo.exists()) {
      try {
        if (archivo.delete()) {
          System.out.println("El archivo se eliminó correctamente.");
        } else {
          System.out.println("No se pudo eliminar el archivo.");
        }
      } catch (SecurityException e) {
        System.out.println("No se tienen los permisos para eliminar el archivo.");
      }
    } else {
      System.out.println("El archivo no existe en la ruta especificada.");
    }
  }

  /**
   * Para crear un nuevo .txt segundo la ruta proporcionada
   */
  public static void crearArchivoTxtEnRuta(String rutaArchivo, String contenido) {
    try {
      FileWriter fileWriter = new FileWriter(rutaArchivo);
      fileWriter.write(contenido);
      fileWriter.close();
      System.out.println("Archivo creado exitosamente en la ruta: " + rutaArchivo);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Accede el nombre de los archivos .txt de una carpeta indicada y lo guarda
   * en una lista que se posteriormente se retornara.
   */
  public static ArrayList<String> obtenerArchivosTxtEnCarpeta(String carpetaDir) {
    ArrayList<String> archivosTxt = new ArrayList<>();
    File carpeta = new File(carpetaDir);
    if (carpeta.isDirectory()) {
      File[] archivos = carpeta.listFiles();
      for (File archivo : archivos) {
        if (archivo.isFile() && archivo.getName().toLowerCase().endsWith(".txt")) {
          archivosTxt.add(archivo.getName());
        }
      }
    } else {
      System.out.println("La ruta no es una carpeta válida.");
    }
    return archivosTxt;
  }

  /**
   * Crea una matriz con el formato de un archivo CSV en el que la primera fila
   * de la matriz sera los campos de la tabla y el resto los registros
   */
  public static String[][] crearMatrizParaCSV(String[][] matrizOriginal, String[] nuevaFila) {
    int filasNuevas = matrizOriginal.length + 1;
    int columnas = matrizOriginal[0].length;
    String[][] nuevaMatriz = new String[filasNuevas][columnas];
    nuevaMatriz[0] = nuevaFila;
    for (int i = 0; i < matrizOriginal.length; i++) {
      nuevaMatriz[i + 1] = matrizOriginal[i];
    }
    return nuevaMatriz;
  }

  /**
   * Crea una nueva carpeta con los nombres recibidos y su ruta absoluta
   */
  public static boolean crearCarpeta(String nombreCarpeta, String rutaAbsoluta) {
    File carpeta = new File(rutaAbsoluta + nombreCarpeta);
    return carpeta.mkdir();
  }

  public int getTablasGeneradas() {
    return tablasGeneradas;
  }

  public void setTablasGeneradas(int tablasGeneradas) {
    this.tablasGeneradas = tablasGeneradas;
  }

  public GestionDataFileArrayList getRutaArchivoGestor() {
    return rutaArchivoGestor;
  }

  public void setRutaArchivoGestor(GestionDataFileArrayList rutaArchivoGestor) {
    this.rutaArchivoGestor = rutaArchivoGestor;
  }

  public ArrayList<String> getListaArchivos() {
    return listaArchivos;
  }

  public void setListaArchivos(ArrayList<String> listaArchivos) {
    this.listaArchivos = listaArchivos;
  }

  public VentanaGestion getVentanaGestion() {
    return ventanaGestion;
  }

  public void setVentanaGestion(VentanaGestion ventanaGestion) {
    this.ventanaGestion = ventanaGestion;
  }

  public String getArchivoSeleccionado() {
    return archivoSeleccionado;
  }

  public void setArchivoSeleccionado(String archivoSeleccionado) {
    this.archivoSeleccionado = archivoSeleccionado;
  }

  public String getRutaArchivoDefecto() {
    return rutaArchivoDefecto = rutaArchivoGestor.consultarCampo("ruta", 1);
  }
}
