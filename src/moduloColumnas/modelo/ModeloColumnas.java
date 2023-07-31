package moduloColumnas.modelo;

import java.util.ArrayList;
import clasesUtilidades.*;

/**
 * Se trata de la clase Modelo para la gestion de los datos de las columnas del
 * registro
 *
 * @author: Albin Liang
 * @version: 7/2023
 *
 */
public class ModeloColumnas {

  private ArrayList<String> listaCampos;
  private String rutaArchivo;
  private GestionDataFileArrayList gestorArchivo;

  public ModeloColumnas(ArrayList<String> listaCampos, String rutaArchivo) {
    this.listaCampos = listaCampos;
    this.rutaArchivo = rutaArchivo;
    gestorArchivo = new GestionDataFileArrayList(rutaArchivo, listaCampos.size());

  }
// Setter y getters

  public ArrayList<String> getListaCampos() {
    return listaCampos;
  }

  public void setListaCampos(ArrayList<String> listaCampos) {
    this.listaCampos = listaCampos;
  }

  public String getRutaArchivo() {
    return rutaArchivo;
  }

  public void setRutaArchivo(String rutaArchivo) {
    this.rutaArchivo = rutaArchivo;
  }

  public GestionDataFileArrayList getGestorArchivo() {
    return gestorArchivo;
  }

  public void setGestorArchivo(GestionDataFileArrayList gestorArchivo) {
    this.gestorArchivo = gestorArchivo;
  }

  /**
   * Valida si existe un registro del objeto gestor archivo
   */
  public boolean existeRegistro(String id) {
    return gestorArchivo.ubicarRegistro(id) != -1;
  }

  /**
   * Devuelve el registro consultado desde gestor archivo en un vector
   */
  public String[] obtenerRegistro(String id) {
    return gestorArchivo.consultarRegistro(id).split(gestorArchivo.getSeparador());
  }
  
 

}
