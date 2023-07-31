package moduloCrearTabla.controlador;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;
import javax.swing.*;
import moduloCrearTabla.modelo.*;
import moduloCrearTabla.vista.*;
import moduloRegistro.controlador.*;
import clasesUtilidades.*;

/**
 * Controlador de la vista Crear tabla y del modelo crear tabla, Crear tabla
 * tiene la funcion de generar nuevas tablas de datos para almacenar registros.
 *
 * @author: Albin Liang
 * @version: 7/2023
 *
 */
public class ControladorCrearTabla {

  private VentanaCrearTabla ventanaCrearTabla;
  private ModeloCrearTabla modeloCrearTabla;
  private ControladorRegistro controladorRegistro;

  public ControladorCrearTabla(VentanaCrearTabla ventanaCrearTabla,
          ModeloCrearTabla modeloCrearTabla, ControladorRegistro controladorRegistro) {
    this.ventanaCrearTabla = ventanaCrearTabla;
    this.modeloCrearTabla = modeloCrearTabla;
    this.controladorRegistro = controladorRegistro;
    eventoGenerar();
    eventoEtiquetaColor();
    ventanaCrearTabla.setTitle(modeloCrearTabla.getCarpetaPrincipal());
  }

  public VentanaCrearTabla getVentanaCrearTabla() {
    return ventanaCrearTabla;
  }

  public void setVentanaCrearTabla(VentanaCrearTabla ventanaCrearTabla) {
    this.ventanaCrearTabla = ventanaCrearTabla;
  }

  public ModeloCrearTabla getModeloCrearTabla() {
    return modeloCrearTabla;
  }

  public void setModeloCrearTabla(ModeloCrearTabla modeloCrearTabla) {
    this.modeloCrearTabla = modeloCrearTabla;
  }


  /*Evento utilizado para crear la tabla, verifica si el nombre de la tabla ha sido utilizado o no
   */
  public void eventoGenerar() {
    ventanaCrearTabla.getjButton1().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // valida si el numero de campos a crear sea solo numeros enteros
        if (contieneSoloNumeros(ventanaCrearTabla.getTxtCampo().getText())) {
          ventanaCrearTabla.setTitle(modeloCrearTabla.getCarpetaPrincipal()
                  + ventanaCrearTabla.getjTextField1().getText());
          modeloCrearTabla.setCampos(Integer.parseInt(
                  ventanaCrearTabla.getTxtCampo().getText()));
          if (modeloCrearTabla.getCampos() > 0) { // valida si los campos no sea menor a 0
            ventanaCrearTabla.getPanelCampos().removeAll();
            ventanaCrearTabla.vectorTextfield = new JTextField[modeloCrearTabla.getCampos()];
            crearCampos(modeloCrearTabla.getCampos());
            cargarCampos(modeloCrearTabla.getCampos());
            ventanaCrearTabla.botonCrearTabla = new JButton("Crear tabla");
            ventanaCrearTabla.getPanelCampos().add(ventanaCrearTabla.botonCrearTabla);
            eventoBotonSecundario(); // Activa el evento secundario
            ventanaCrearTabla.getPanelCampos().repaint();
            ventanaCrearTabla.getPanelCampos().revalidate();
          } else {
            borrarTodoPanelCampos();
          }
        } else {
          CuadroMensaje.mensajeVentana("Solo se acepta datos numericos", "Surgerencia");
        }
      }
    });
  }

  /**
   * Evento para la etiqueta color, en el cual sirve para asignar el color que
   * va tener la tabla
   */
  private void eventoEtiquetaColor() {
    ventanaCrearTabla.getEtiquetaColor().addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        Color colorInicial = Color.WHITE; // Color inicial para el JColorChooser
        ventanaCrearTabla.setColorSeleccionado(
                JColorChooser.showDialog(null, "Seleccionar color", colorInicial));

        if (ventanaCrearTabla.getColorSeleccionado() != null) {
          ventanaCrearTabla.getEtiquetaColor().setBackground(ventanaCrearTabla.getColorSeleccionado());
          System.out.println("Color seleccionado: " + ventanaCrearTabla.getColorSeleccionado());
        } else {
          ventanaCrearTabla.setColorSeleccionado(colorInicial);
          System.out.println("Operación cancelada por el usuario.");
        }
      }
    });
  }

  private void borrarTodoPanelCampos() {
    ventanaCrearTabla.getPanelCampos().removeAll();
    ventanaCrearTabla.getPanelCampos().repaint();
    ventanaCrearTabla.getPanelCampos().revalidate();
  }

  // Evento secundario que se activa luego de desear agregar o modificar un registro
  private void eventoBotonSecundario() {
    ventanaCrearTabla.botonCrearTabla.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
// En caso de que los archivos que guarda las tablas de campos y ajuste no exista se creara automaticamente.
        if (modeloCrearTabla.validarArchivoNoExiste(modeloCrearTabla.getCarpetaPrincipal()
                + ventanaCrearTabla.getjTextField1().getText())) {
          crearArchivoCampo();
          crearArchivoAjuste();
          crearArchivoPrincipal();
          CuadroMensaje.mensajeVentana("Se han creado correctamente los archivos", "Aviso");
        } else {
          CuadroMensaje.mensajeVentana("El nombre de este archivo ya ha sido utilizado", "Sugerencia");
        }
        if (controladorRegistro != null) {
          controladorRegistro.refrescarPanelBotones();
        }
      }
    });
  }

  private void crearArchivoPrincipal() {
    modeloCrearTabla.crearArchivoTxt(modeloCrearTabla.getCarpetaPrincipal()
            + ventanaCrearTabla.getjTextField1().getText()
            + ".txt", null, false);
  }

  private void crearArchivoCampo() {
    modeloCrearTabla.crearArchivoTxt(modeloCrearTabla.getCarpetaPrincipal()
            + modeloCrearTabla.getCarpetaCampo() + ventanaCrearTabla.getjTextField1().getText()
            + "-Campo" + ".txt", obtenerNombreCampos(), true);
  }

  private void crearArchivoAjuste() {
    modeloCrearTabla.crearArchivoTxt(modeloCrearTabla.getCarpetaPrincipal()
            + modeloCrearTabla.getCarpetaAjuste()
            + ventanaCrearTabla.getjTextField1().getText()
            + "-Ajuste" + ".txt", ventanaCrearTabla.getjTextField1().getText()
            + "-" + ventanaCrearTabla.getColorSeleccionado().getRed() + "-"
            + ventanaCrearTabla.getColorSeleccionado().getGreen() + "-"
            + ventanaCrearTabla.getColorSeleccionado().getBlue(), true);
  }
// Obtiene todo el contenido de los jtetxField generados dinamicamente

  private String obtenerNombreCampos() {
    String salida = "";
    for (JTextField i : ventanaCrearTabla.vectorTextfield) {
      salida += i.getText() + "\n";
    }
    salida = salida.substring(0, salida.lastIndexOf("\n")); // evita el salto de linea que se genera al final del archivo
    return salida;
  }

  /**
   * Generar jtextFields de manera dinamica la cantidad varia del campo que
   * posea la tabla
   *
   * @param campos
   */
  private void crearCampos(int campos) {
    for (int i = 0; i < campos; i++) {
      ventanaCrearTabla.vectorTextfield[i] = new JTextField();
    }
  }

  /**
   * Agrega los jtetxtfields al panel con su respectivo indicador
   *
   * @param campos
   */
  public void cargarCampos(int campos) {
    for (int i = 0; i < campos; i++) {
      ventanaCrearTabla.getPanelCampos().add(new JLabel("Campo " + (i + 1)));
      ventanaCrearTabla.getPanelCampos().add(ventanaCrearTabla.vectorTextfield[i]);

    }
  }

  public static boolean contieneSoloNumeros(String cadena) {
    String regex = "\\d+";
    return Pattern.matches(regex, cadena);
  }

}
