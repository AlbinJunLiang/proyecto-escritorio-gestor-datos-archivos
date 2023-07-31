package moduloGestion.controlador;

import clasesUtilidades.CuadroMensaje;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import moduloGestion.vista.*;
import moduloGestion.modelo.*;
import moduloRegistro.controlador.*;

/**
 * Controlador de la vista gestion y del modelo de gestion.
 *
 * La parte que se llama gestion, en este programa representa el acoplamiento de
 * las funciones principales del CRUD en archivos txt.
 *
 * @author: Albin Liang
 * @version: 7/2023
 *
 */
public class ControladorGestion {

  private ModeloGestion modeloGestion;
  private VentanaGestion ventanaGestion;
  private ControladorRegistro controladorRegistro;

  public ControladorGestion(ModeloGestion modeloGestion,
          VentanaGestion ventanaGestion, ControladorRegistro controladorRegistro) {
    this.modeloGestion = modeloGestion;
    this.ventanaGestion = ventanaGestion;
    this.controladorRegistro = controladorRegistro;
    ventanaGestion.setCampo(modeloGestion.getListaColumnas().size());
    ajustarIndicadores();
    eventoBoton1();
  }

  public ModeloGestion getModeloGestion() {
    return modeloGestion;
  }

  public void setModeloGestion(ModeloGestion modeloGestion) {
    this.modeloGestion = modeloGestion;
  }

  public VentanaGestion getVentanaGestion() {
    return ventanaGestion;
  }

  public void setVentanaGestion(VentanaGestion ventanaGestion) {
    this.ventanaGestion = ventanaGestion;
  }

  /**
   * Evento principal que habilita la funcion de CRUD que desea realizar
   */
  private void eventoBoton1() {
    ventanaGestion.getjButton1().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ventanaGestion.getjLabel3().setText("");
        ventanaGestion.getPanelFlexible().removeAll();
        boolean seInicio = iniciarAccion();
        ventanaGestion.getPanelFlexible().repaint();
        ventanaGestion.getPanelFlexible().revalidate();
        eventoAccionSecundario();
      }
    });
  }

  /**
   * Este metodo selecciona la accion que se va a ejecutar en la vista segun el
   * parametro de accion.
   *
   * @return
   */
  private boolean iniciarAccion() {
    boolean seInicio = false;
    if (modeloGestion.getAccion() == OpcionesGestion.CONSULTAR) {
      seInicio = consultar();
    } else if (modeloGestion.getAccion() == OpcionesGestion.AGREGAR) {
      seInicio = agregar();
    } else if (modeloGestion.getAccion() == OpcionesGestion.ELIMINAR) {
      seInicio = eliminar();
    } else if (modeloGestion.getAccion() == OpcionesGestion.MODIFICAR) {
      seInicio = modificar();
    }
    return seInicio;
  }

  /**
   * Realiza la accion de consultar en la vista.
   *
   * @return
   */
  private boolean consultar() {
    String registro[];
    boolean seInicio = false;
    if (modeloGestion.existeRegistro(ventanaGestion.getjTextField1().getText())) {
      ventanaGestion.vectorTextfield = new JTextField[modeloGestion.getListaColumnas().size()];
      registro = modeloGestion.obtenerRegistro(ventanaGestion.getjTextField1().getText());
      for (int i = 0; i < modeloGestion.getListaColumnas().size(); i++) {
        ventanaGestion.vectorTextfield[i] = new JTextField();
        ventanaGestion.vectorTextfield[i].setBackground(new Color(250, 250, 255));
        ventanaGestion.vectorTextfield[i].setText(registro[i]);
        ventanaGestion.vectorTextfield[i].setEditable(false);
      }
      cargarCampos(ventanaGestion.getCampo());
      seInicio = true;
    } else {
      ventanaGestion.getPanelFlexible().removeAll();
      ventanaGestion.getPanelFlexible().repaint();
      ventanaGestion.getPanelFlexible().revalidate();
      ventanaGestion.getjLabel3().setText("No existe tal registro");
    }
    return seInicio;
  }

  /*Carga los campos de jtextfields y los indicadores por JLABEL*/
  private void cargarCampos(int campos) {
    for (int i = 0; i < campos; i++) {
      JLabel etiqueta = new JLabel(" " + modeloGestion.getListaColumnas().get(i) + ":");
      etiqueta.setFont(new Font("Courier", 1, 15));
      etiqueta.setVerticalAlignment(SwingConstants.CENTER);
      ventanaGestion.getPanelFlexible().add(etiqueta);
      ventanaGestion.getPanelFlexible().add(ventanaGestion.vectorTextfield[i]);
    }
  }

  /*Realiza la funcion de agregar registro en la vista*/
  private boolean agregar() {
    boolean seInicio = false;

    if (!modeloGestion.existeRegistro(ventanaGestion.getjTextField1().getText())) {
      ventanaGestion.vectorTextfield = new JTextField[modeloGestion.getListaColumnas().size()];
      if (!modeloGestion.getListaColumnas().isEmpty()) {
        for (int i = 0; i < modeloGestion.getListaColumnas().size(); i++) {
          ventanaGestion.vectorTextfield[i] = new JTextField();
          ventanaGestion.vectorTextfield[i].setBackground(new Color(250, 250, 255));
        }
        cargarCampos(ventanaGestion.getCampo());

        ventanaGestion.vectorTextfield[0].setEditable(false);
        ventanaGestion.vectorTextfield[0].setText(ventanaGestion.getjTextField1().getText());
        agregarBoton("Agregar");
      } else {
        CuadroMensaje.mensajeVentana("No se pudo agregar", "Error posible en la columnas");
      }
      seInicio = true;
    } else {
      ventanaGestion.getjLabel3().setText("El ID ya se encuentra usado");
      ventanaGestion.getjLabel3().setForeground(Color.green);
    }

    return seInicio;
  }

  /**
   * Agrega el boton dinamicamente que activara la actualizacion de datos y el
   * evento secundario que registra o modifica.
   *
   * @param boton
   */
  private void agregarBoton(String boton) {
    ventanaGestion.botonAccion = new JButton();
    ventanaGestion.botonAccion.setText(boton);
    ventanaGestion.getPanelFlexible().add(ventanaGestion.botonAccion);
  }

  /*Realiza la funcion de eliminar en la vista*/
  private boolean eliminar() {
    boolean seInicio = false;
    if (modeloGestion.existeRegistro(ventanaGestion.getjTextField1().getText())) {
      modeloGestion.getGestorRegistro().eliminarRegistro(ventanaGestion.getjTextField1().getText());
      ventanaGestion.getjLabel3().setText("Registro eliminado exitosamete");
      ventanaGestion.getjLabel3().setForeground(Color.green);
      ventanaGestion.getjTextField1().setText("");
      seInicio = true;
      actualizarInterfazClaseVG();
    } else {
      ventanaGestion.getjLabel3().setForeground(Color.red);
      ventanaGestion.getjLabel3().setText("El registro no existe");
    }
    return seInicio;
  }

  /*Realiza la funcion de modificar en la vista*/
  private boolean modificar() {
    String registro[];
    boolean seInicio = false;
    if (modeloGestion.existeRegistro(ventanaGestion.getjTextField1().getText())) {
      ventanaGestion.vectorTextfield = new JTextField[modeloGestion.getListaColumnas().size()];
      registro = modeloGestion.obtenerRegistro(ventanaGestion.getjTextField1().getText());
      for (int i = 0; i < modeloGestion.getListaColumnas().size(); i++) {
        ventanaGestion.vectorTextfield[i] = new JTextField();
        ventanaGestion.vectorTextfield[i].setBackground(new Color(250, 250, 255));
        ventanaGestion.vectorTextfield[i].setText(registro[i]);
      }
      cargarCampos(ventanaGestion.getCampo());
      agregarBoton("Modificar");
      seInicio = true;
    } else {
      ventanaGestion.getPanelFlexible().removeAll();
      ventanaGestion.getPanelFlexible().repaint();
      ventanaGestion.getPanelFlexible().revalidate();
      ventanaGestion.getjLabel3().setText("No existe tal registro");
    }
    return seInicio;
  }

  /**
   * Evento secundario para el boton de accion que sera el que actualizara los
   * cambios de la base de datos con la funciones de agregar o modificar
   */
  private void eventoAccionSecundario() {
    if (ventanaGestion.botonAccion != null) {
      ventanaGestion.botonAccion.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          if (modeloGestion.getAccion() == 2) {
            agregarRegistro();
            ventanaGestion.getjLabel3().setText("Se ha agregado un registro");
            ventanaGestion.getPanelFlexible().removeAll();
            ventanaGestion.getPanelFlexible().repaint();
            ventanaGestion.getPanelFlexible().revalidate();
            actualizarInterfazClaseVG();

          } else if (modeloGestion.getAccion() == 4) {
            modificarRegistro();
            ventanaGestion.getPanelFlexible().removeAll();
            ventanaGestion.getPanelFlexible().repaint();
            ventanaGestion.getPanelFlexible().revalidate();
            ventanaGestion.getjLabel3().setText("Ha ocurrido una modificacion");
            actualizarInterfazClaseVG();
          }
        }
      });

    }
  }

  /**
   * Funcion para modificar el registro y se activara luego de aceptar la
   * modificacion de los datos.
   */
  private void modificarRegistro() {
    String vector[] = new String[ventanaGestion.vectorTextfield.length];
    for (int i = 0; i < vector.length; i++) {
      vector[i] = ventanaGestion.vectorTextfield[i].getText();
    }
    modeloGestion.getGestorRegistro().modificarPorReemplazo(
            ventanaGestion.getjTextField1().getText(), vector);
  }

  /**
   * Para refrescar la ventana de registro a la hora de hace algunas de las
   * funciones del CRUD.
   */
  private void actualizarInterfazClaseVG() {
    if (controladorRegistro != null) {
      controladorRegistro.cargarTabla(modeloGestion.getRutaArchivoCampo(),
              modeloGestion.getRutaArchivoRegistro());
    }
  }

  /**
   * Funcion para agregar el registro a la base de datos con los datos
   * ingresados en los textfields por el usuario.
   */
  private void agregarRegistro() {
    String vector[] = new String[ventanaGestion.getVectorTextfield().length];
    for (int i = 0; i < vector.length; i++) {
      vector[i] = ventanaGestion.vectorTextfield[i].getText();
    }
    modeloGestion.getGestorRegistro().agregarRegistro(vector);
  }

  /**
   * Establece la ventana al inicio segun la tarea que corresponde por medio del
   * parametro de accion.
   */
  private void ajustarIndicadores() {
    switch (modeloGestion.getAccion()) {
      case 1:
        ventanaGestion.getEtiquetaTitulo().setText("Consultar:");
        break;
      case 2:
        ventanaGestion.getEtiquetaTitulo().setText("Agregar");
        break;
      case 3:
        ventanaGestion.getEtiquetaTitulo().setText("Eliminar");
        ventanaGestion.remove(ventanaGestion.getjScrollPane1());
        ventanaGestion.remove(ventanaGestion.getPanelFlexible());
        ventanaGestion.repaint();
        ventanaGestion.revalidate();
        ventanaGestion.setSize(ventanaGestion.getjPanel1().getWidth() + 25,
                ventanaGestion.getjPanel1().getHeight() + 50);

        break;
      case 4:
        ventanaGestion.getEtiquetaTitulo().setText("Modificar");
        break;
      default:
        ventanaGestion.getEtiquetaTitulo().setText("Otro");
    }
  }

}
