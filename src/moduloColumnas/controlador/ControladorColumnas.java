package moduloColumnas.controlador;

import java.awt.event.*;
import javax.swing.event.*;
import clasesUtilidades.*;
import moduloColumnas.modelo.*;
import moduloColumnas.vista.*;


/**
 * Controlador de la vista de columnas y del modelo de las columnas. Nota:La
 * columnas son los campos de los registros.
 *
 * Tiene la funcion para visualizar con mayor detalles los campos de los
 * registros.
 *
 * @author: Albin Liang
 * @version: 7/2023
 *
 */
public class ControladorColumnas {

  private ModeloColumnas modeloColumnas;
  private VistaColumnas vistaColumnas;
  private String vectorTemporal[];

  public ControladorColumnas(ModeloColumnas modeloColumnas, VistaColumnas vistaColumnas) {
    this.modeloColumnas = modeloColumnas;
    this.vistaColumnas = vistaColumnas;
    establecerInicialComponentes();
    iniciarEventos();
  }

// Setter y Getters
  public ModeloColumnas getModeloColumnas() {
    return modeloColumnas;
  }

  public void setModeloColumnas(ModeloColumnas modeloColumnas) {
    this.modeloColumnas = modeloColumnas;
  }

  public VistaColumnas getVistaColumnas() {
    return vistaColumnas;
  }

  public void setVistaColumnas(VistaColumnas vistaColumnas) {
    this.vistaColumnas = vistaColumnas;
  }

// Dar un estado inicial a algunos componentes en especifico
  private void establecerInicialComponentes() {
    vistaColumnas.getjSlider1().setMinimum(0);
    vistaColumnas.getjSlider1().setMaximum(modeloColumnas.getListaCampos().size() - 1);
    vistaColumnas.getjSlider1().setValue(modeloColumnas.getListaCampos().size() / 2);
    vistaColumnas.getjSlider1().setEnabled(false);
    vistaColumnas.getBtnGuardar().setEnabled(false);
    vistaColumnas.getBtnCancelar().setEnabled(false);
  }

  /**
   * Inicia los eventos
   */
  private void iniciarEventos() {
    eventoSlider();
    eventoBtnBuscar();
    eventoTextArea();
    eventoGuardarCambios();
    eventoCancelar();
  }

  /*Evento del boton buscar*/
  private void eventoBtnBuscar() {
    vistaColumnas.getBotonBuscar().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (modeloColumnas.existeRegistro(vistaColumnas.getjTextField1().getText())) {
          vectorTemporal = modeloColumnas.obtenerRegistro(vistaColumnas.getjTextField1().getText());
          vistaColumnas.getjSlider1().setEnabled(true);
          vistaColumnas.getjTextArea1().setText("");
          if (!modeloColumnas.getListaCampos().isEmpty()) {
            vistaColumnas.getjTextArea1().setText(
                    vectorTemporal[vistaColumnas.getjSlider1().getValue()].replace("[]", "\n"));
          } // El [] es para evitar problemas con saltos de lineas a la hora de visualizar 
        } else {
          CuadroMensaje.mensajeVentana("El registro no existe", "Aviso");
        }
      }
    });
  }

  /*Evento del boton guardar cambios*/
  private void eventoGuardarCambios() {
    vistaColumnas.getBtnGuardar().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        modeloColumnas.getGestorArchivo().modificarRegistro(vectorTemporal[0],
                vistaColumnas.getjTextArea1().getText().trim().replace("\n", "[]"),
                vistaColumnas.getjSlider1().getValue());
        vistaColumnas.getBtnCancelar().setEnabled(false);

      }
    });
  }

  /*Evento del boton cancelar*/
  private void eventoCancelar() {
    vistaColumnas.getBtnCancelar().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        vistaColumnas.getjTextArea1().
                setText(vectorTemporal[vistaColumnas.getjSlider1().getValue()].replace("[]", "\n"));
        CuadroMensaje.mensajeVentana("Se ha cancelado los cambios", "Aviso");
      }
    });

  }

  /*Evento del jslider*/
  private void eventoSlider() {
    vistaColumnas.getjSlider1().addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        vistaColumnas.getEtiquetaIndicador().
                setText(modeloColumnas.getListaCampos().get(vistaColumnas.getjSlider1().getValue()));
        vistaColumnas.getjTextArea1().
                setText(vectorTemporal[vistaColumnas.getjSlider1().getValue()].replace("[]", "\n"));
      }
    });
  }

  /*Evento del textArea para detectar cambios*/
  private void eventoTextArea() {

    vistaColumnas.getjTextArea1().getDocument().addDocumentListener(new DocumentListener() {
      @Override
      public void insertUpdate(DocumentEvent e) {
        if (vistaColumnas.getjSlider1().isEnabled()) { // Habilita los botones y el jslider en caso de haber tocado el area de texto
          vistaColumnas.getBtnGuardar().setEnabled(true);
          vistaColumnas.getBtnCancelar().setEnabled(true);
          vistaColumnas.setTitle("Se ha creado nuevos posibles cambios en el registro...");
        }
      }

      @Override
      public void removeUpdate(DocumentEvent e) {
        if (vistaColumnas.getjSlider1().isEnabled()) { // Lo mismo pero en caso de una actualizacion
          vistaColumnas.getBtnGuardar().setEnabled(true);
          vistaColumnas.getBtnCancelar().setEnabled(true);
          vistaColumnas.setTitle("Se ha creado nuevos posibles cambios en el registro...");
        }
      }

      @Override
      public void changedUpdate(DocumentEvent e) {

      }
    });

  }

}
