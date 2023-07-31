package moduloGestion.modelo
        ;

import java.util.ArrayList;
import clasesUtilidades.*;

/**
 * Encargado de mantener la comunicacion de datos de los archivos campos y
 * registro o principal en el modulo Gestion.
 *
 * @author: Albin Liang
 * @version: 7/2023
 *
 */
public class ModeloGestion {

  private String rutaArchivoCampo;
  private String rutaArchivoRegistro;
  private ArrayList<String> listaColumnas; // para guardar los campos o columnas de la tabla
  private GestionDataFileArrayList gestorCampo;
  private GestionDataFileArrayList gestorRegistro;
  private int accion; // Asigna la tarea a realizar del modulo  (ELIMINAR, AGREGAR y etc...)

  public ModeloGestion(String rutaArchivoCampo, String rutaArchivoRegistro, int accion) {
    this.rutaArchivoCampo = rutaArchivoCampo;
    this.rutaArchivoRegistro = rutaArchivoRegistro;
    this.accion = accion;
    // el parametro en 2 se debe a que es la columna que se ubica la ruta del archivo persistencia
// y el identificador siempre sera el nombre de la tabla
    gestorCampo = new GestionDataFileArrayList(rutaArchivoCampo, 2);
    
    listaColumnas = gestorCampo.obtenerRegistros();
    gestorRegistro = new GestionDataFileArrayList(rutaArchivoRegistro, listaColumnas.size());
  }

  // Setter y getters
  public boolean existeRegistro(String id) {
    return gestorRegistro.ubicarRegistro(id) != -1;
  }

  public String[] obtenerRegistro(String id) {
    return gestorRegistro.consultarRegistro(id).split(gestorRegistro.getSeparador());
  }

  public String getRutaArchivoCampo() {
    return rutaArchivoCampo;
  }

  public void setRutaArchivoCampo(String rutaArchivoCampo) {
    this.rutaArchivoCampo = rutaArchivoCampo;
  }

  public String getRutaArchivoRegistro() {
    return rutaArchivoRegistro;
  }

  public void setRutaArchivoRegistro(String rutaArchivoRegistro) {
    this.rutaArchivoRegistro = rutaArchivoRegistro;
  }

  public ArrayList<String> getListaColumnas() {
    return listaColumnas;
  }

  public void setListaColumnas(ArrayList<String> listaColumnas) {
    this.listaColumnas = listaColumnas;
  }

  public GestionDataFileArrayList getGestorCampo() {
    return gestorCampo;
  }

  public void setGestorCampo(GestionDataFileArrayList gestorCampo) {
    this.gestorCampo = gestorCampo;
  }

  public GestionDataFileArrayList getGestorRegistro() {
    return gestorRegistro;
  }

  public void setGestorRegistro(GestionDataFileArrayList gestorRegistro) {
    this.gestorRegistro = gestorRegistro;
  }

  public int getAccion() {
    return accion;
  }

  public void setAccion(int accion) {
    this.accion = accion;
  }

}
