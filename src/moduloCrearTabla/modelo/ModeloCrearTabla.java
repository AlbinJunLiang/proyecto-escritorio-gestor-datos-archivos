package moduloCrearTabla.modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Se trata de la clase Modelo que gestiona los datos para el modulo de
 * crearTabla registro
 *
 * @author: Albin Liang
 * @version: 7/2023
 *
 */
public class ModeloCrearTabla {

  private int campos;
  private String carpetaPrincipal;
  private String carpetaCampo, carpetaAjuste;

  public ModeloCrearTabla(String carpetaPrincipal) {
    this.carpetaCampo = "";
    this.carpetaAjuste = "";
    this.carpetaPrincipal = carpetaPrincipal;
  }

  // Sets y gets
  public int getCampos() {
    return campos;
  }

  public void setCampos(int campos) {
    this.campos = campos;
  }

  public String getCarpetaCampo() {
    return carpetaCampo;
  }

  public void setCarpetaCampo(String carpetaCampo) {
    this.carpetaCampo = carpetaCampo;
  }

  public String getCarpetaAjuste() {
    return carpetaAjuste;
  }

  public void setCarpetaAjuste(String carpetaAjuste) {
    this.carpetaAjuste = carpetaAjuste;
  }

  public String getCarpetaPrincipal() {
    return carpetaPrincipal;
  }

  public void setCarpetaPrincipal(String carpetaPrincipal) {
    this.carpetaPrincipal = carpetaPrincipal;
  }

  /**
   * Verifica la existencia de un archivo por argumento de la ruta
   */
  public static boolean validarArchivoNoExiste(String rutaArchivo) {
    File archivo = new File(rutaArchivo + ".txt");
    boolean salida = true;
    if (archivo.exists()) {
      salida = false;
    }
    return salida;
  }

  /**
   * Crea un archivo tipo txt desde la ruta del archivo recibido por argumento,
   * tambien recibe el contenido del archivo por parametro.
   */
  public static void crearArchivoTxt(String rutaArchivo, String contenido, boolean escribir) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
      if (escribir) {
        writer.write(contenido);
      }
      System.out.println("Archivo creado exitosamente.");
    } catch (IOException e) {
      System.err.println("Error al crear el archivo: " + e.getMessage());
    }
  }

}
