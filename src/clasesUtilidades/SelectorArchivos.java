package clasesUtilidades;

import java.awt.Color;
import java.io.*;
import javax.swing.*;
import java.util.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import moduloRegistro.controlador.*;

/**
 * La clase proporcionara herramientas y utilidades adaptadas para el programa
 * de gestor de archivo, como selectores de archivos personalizados
 * (JFilechooser) y funciones para crear, leer o escribir un archivo tipo CSV.
 *
 * @author: Albin Liang
 * @version: 7/2023
 *
 */
public class SelectorArchivos {

  /**
   * Abre el fileChooser o selector y devuelve la ruta del archivo seleccionado
   *
   * @param controladorRegistro Recibe un objeto de la clase Controlador
   * registro para acceder la ventana o jframe que ubicara el fileChooser
   * @return ruta del archivo seleccionado
   */
  public static String abrirCarpeta(ControladorRegistro controladorRegistro) {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setBackground(Color.WHITE);
    String salida = "";
    fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

    int seleccion = fileChooser.showOpenDialog(controladorRegistro.getVentanaRegistro());
    if (seleccion == JFileChooser.APPROVE_OPTION) {
      File carpetaSeleccionada = fileChooser.getSelectedFile();
      System.out.println("Carpeta seleccionada: " + carpetaSeleccionada.getAbsolutePath());
      salida = carpetaSeleccionada.getAbsolutePath();
    }
    return salida;
  }

  /**
   * @param ventana Recibe un JFrame para ubicar el JFileChooser
   *
   * Es igual al metodo abrirCarpeta que recibe por argumento
   * ControladorRegistro, solamente que en este se recibe un JFrame
   *
   * @return ruta del archivo seleccionado
   */
  public static String abrirCarpeta(JFrame ventana) {

    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setBackground(Color.WHITE);
    String salida = "";
    fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

    int seleccion = fileChooser.showOpenDialog(ventana);
    if (seleccion == JFileChooser.APPROVE_OPTION) {
      File carpetaSeleccionada = fileChooser.getSelectedFile();
      System.out.println("Carpeta seleccionada: " + carpetaSeleccionada.getAbsolutePath());
      salida = carpetaSeleccionada.getAbsolutePath();
    }
    return salida;
  }

  /**
   * Abre el selector de archivo para escoger la ruta en la que se va guardar,
   * crea el CSV y con los datos del CSV recibidos en una matriz de cadenas para
   * finalmente ser procesado en el metodo excribirCSV que sera el que agregara
   * los datos al archivo.
   *
   * @param datos Matriz con los datos del CSV
   * @param nombreArchivo Nombre que tendra el CSV
   */
  public static void crearCSV(String datos[][], String nombreArchivo) {
    JFileChooser fileChooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos CSV", "csv");
    fileChooser.setFileFilter(filter);
    File defaultFile = new File(nombreArchivo + ".csv");
    fileChooser.setSelectedFile(defaultFile);
    int returnValue = fileChooser.showSaveDialog(null);
    if (returnValue == JFileChooser.APPROVE_OPTION) {
      File selectedFile = fileChooser.getSelectedFile();

      String filePath = selectedFile.getAbsolutePath();
      if (!filePath.toLowerCase().endsWith(".csv")) {
        filePath += ".csv"; // Agregar la extensión .csv si no la tiene
      }
      try {
        escribirCSV(filePath, datos);
        System.out.println("Archivo CSV creado exitosamente en: " + filePath);
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      System.out.println("No se seleccionó ninguna ubicación para guardar el archivo CSV.");
    }
  }

  /**
   * Transforma los datos de la matriz en formato cadena que se almacenara en en
   * .csv con la ruta especificada.
   *
   * @param ubicacionArchivo ubicacion del .csv para escribir los datos en el
   * mismo archivo.
   * @param data Matriz de datos del CSV
   * @throws IOException
   */
  private static void escribirCSV(String ubicacionArchivo, String[][] data) throws IOException {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(ubicacionArchivo))) {
      for (String[] fila : data) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < fila.length; i++) {
          line.append(fila[i]);
          if (i < fila.length - 1) {
            line.append(",");
          }
        }
        bw.write(line.toString());
        bw.newLine();
      }
    }
  }

  /**
   * Carga todo el contenido leido del .CSV a una lista con el formato separado
   * por comas.
   *
   * @param csvFilePath Ubicacion del CSV
   * @return Lista de los datos obtenidos del .CSV
   */
  public static List<String[]> leerCSV(String csvFilePath) {
    List<String[]> datosMatriz = new ArrayList<>();
    try (BufferedReader lector = new BufferedReader(new FileReader(csvFilePath))) {
      String line;

      while ((line = lector.readLine()) != null) {
        String[] record = line.split(",");
        datosMatriz.add(record);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return datosMatriz;
  }

  /**
   * Obtiene la ruta absoluta seleccionada, el selector de archivos filtra
   * solamente los archivos .csv.
   *
   * @return ruta absoluta del CSV seleccionado.
   */
  public static String getRutaAbsCSV(String separador) {
    JFileChooser fileChooser = new JFileChooser();
    FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos CSV", "csv");
    fileChooser.setFileFilter(filtro);
    String salida = "";

    int returnValue = fileChooser.showOpenDialog(null);
    if (returnValue == JFileChooser.APPROVE_OPTION) {
      salida = fileChooser.getSelectedFile().getAbsolutePath();
    }
    return salida;
  }

  /**
   * Muestra el CSV especificado por la ruta recibida en parametros y se lo
   * devuelve en un formato de string separador con el caracter asignado.
   */
  public static String mostrarStringCSV(String separador, String rutaCSVAbsoluta) {
    String salida = "";
    List<String[]> datosCSV = leerCSV(rutaCSVAbsoluta);
    for (String[] fila : datosCSV) {
      salida += String.join(separador, fila) + "\n";
    }
    salida = salida.substring(0, salida.lastIndexOf("\n")); // Elimina el ultimo salto de linea
    return salida;
  }

  /**
   * Muestra unicamente una fila del CSV especificado, la fila depende de cual
   * sea, por lo que es recibido desde parametros.
   *
   * @return Fila especifica del .CSV
   */
  public static String mostrarFilaEspecificaCSV(String separador, String rutaCSVAbsoluta, int pos) {
    String salida = "";
    List<String[]> datosCSV = leerCSV(rutaCSVAbsoluta);
    for (int i = 0; i < datosCSV.size(); i++) {
      if (i == pos) {
        String[] fila = datosCSV.get(i);
        salida = String.join(separador, fila);
        break;
      }
    }

    return salida;
  }

  /**
   * Muestra el .CSV desde un rango inicial, digamos que se desea ver el
   * contenido desde la fila 1 lo cual se mostra todo a excepcion de la fila 0.
   *
   * @param separador caracter para dar formato al string
   * @param rutaCSVAbsoluta ruta especidicada del .csv
   * @param pos rango inicial a mostrar
   * @return salida
   */
  public static String mostrarCSVIniciandoEn(String separador, String rutaCSVAbsoluta, int pos) {
    String salida = "";
    int i = 0;
    List<String[]> datosCSV = leerCSV(rutaCSVAbsoluta);
    for (String[] fila : datosCSV) {
      if (i >= pos) {
        salida += String.join(separador, fila) + "\n";
      }
      i++;
    }
    salida = salida.substring(0, salida.lastIndexOf("\n"));

    return salida;
  }

  /**
   * Recibe una ruta absoluta y lo que hace es devolver el nombre del archivo
   * que esta en la ruta absolua.
   */
  public static String getNamePorAbsPath(String rutaAbsoluta) {
    File archivo = new File(rutaAbsoluta);
    String nombreArchivo = archivo.getName();
    return nombreArchivo;
  }
}
