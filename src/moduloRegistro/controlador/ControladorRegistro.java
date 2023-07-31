package moduloRegistro.controlador;

import moduloRegistro.vista.VentanaRegistro;
import moduloRegistro.modelo.*;
import moduloColumnas.modelo.ModeloColumnas;
import moduloColumnas.controlador.ControladorColumnas;
import moduloColumnas.vista.*;
import moduloCrearTabla.controlador.*;
import moduloCrearTabla.vista.*;
import moduloCrearTabla.modelo.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import clasesUtilidades.*;
import moduloGestion.controlador.*;
import moduloGestion.vista.*;
import moduloGestion.modelo.*;

/**
 * Controlador de la vista registro y del modelo de registro.
 *
 * El modulo registro donde se implementa las otras clases controladoras.
 *
 * @author: Albin Liang
 * @version: 7/2023
 *
 */
public class ControladorRegistro {

  private ModeloRegistro modeloRegistro;
  private VentanaRegistro ventanaRegistro;

  public ControladorRegistro(ModeloRegistro modeloRegistro, VentanaRegistro ventanaRegistro) {
    this.modeloRegistro = modeloRegistro;
    this.ventanaRegistro = ventanaRegistro;
    colocarBtnAgregarMas();
    colocarPanelBoton();
    ventanaRegistro.setTitle("Sistema gestor de datos .txt");
    iniciarEventos();
  }

  public ModeloRegistro getModeloRegistro() {
    return modeloRegistro;
  }

  public void setModeloRegistro(ModeloRegistro modeloRegistro) {
    this.modeloRegistro = modeloRegistro;
  }

  public VentanaRegistro getVentanaRegistro() {
    return ventanaRegistro;
  }

  public void setVentanaRegistro(VentanaRegistro ventanaRegistro) {
    this.ventanaRegistro = ventanaRegistro;
  }

  /*Inicia todos los eventos que se comuinicara a la vista de controladorRegsitro*/
  private void iniciarEventos() {
    eventoModificar();
    eventoConsultar();
    eventoEliminar();
    eventoAgregar();
    eventoRefrescar();
    eventoRegistro();
    eventoCerrarCarpeta();
    eventoMasVisualizarRegistro();
    eventoCerrarTodo();
    eventoEliminarTabla();
    eventoExportar();
    eventoImportar();
  }

  /**
   * Agrega el JPanel que contiene los botones para visualizar las tablas.
   */
  private void colocarPanelBoton() {
    String ubicacionCarpetaAbsoluta = modeloRegistro.getRutaArchivoDefecto().trim();
    GestionDataFileArrayList archivoAjustes = null; // para acceder el archivo de ajustes
    String nombreArchivo = "";
    for (int i = 0; i < modeloRegistro.getListaArchivos().size(); i++) {
      modeloRegistro.setTablasGeneradas(i);
      nombreArchivo = modeloRegistro.getListaArchivos().get(i).replace(".txt", "");
      archivoAjustes = new GestionDataFileArrayList(ubicacionCarpetaAbsoluta
              + "\\Carpeta de ajuste tabla\\" + nombreArchivo + "-Ajuste.txt", "-", 4);
      agregarBoton(nombreArchivo, new Color(Integer.parseInt(
              archivoAjustes.consultarCampo(nombreArchivo, 1)), // RGB -R
              Integer.parseInt(archivoAjustes.consultarCampo(nombreArchivo, 2)), // RGB - G
              Integer.parseInt(archivoAjustes.consultarCampo(nombreArchivo, 3)))); // RGB -R
    }
  }

  /**
   * Crea el boton con las caracteristicas segun la tabla e incluye su evento.
   *
   * @param texto Nombre que tendra el boton
   * @param color Color asignado al boton
   */
  private void agregarBoton(String texto, Color color) {
    JButton boton = new JButton(texto);
    boton.setFocusable(false);
    boton.setBackground(color);
    boton.setFont(new Font("Century Gothic", 1, 15));
    boton.setPreferredSize(new Dimension(boton.getHeight(), 100));
    boton.setMaximumSize(new Dimension(boton.getHeight(), 100));
    ventanaRegistro.popupMenu.add(ventanaRegistro.popupItem);
    boton.setComponentPopupMenu(ventanaRegistro.popupMenu);
    boton.setAlignmentX(Component.LEFT_ALIGNMENT); // Alinear botones a la izquierda
    ventanaRegistro.getPanelBotones().add(boton);
    // Evento para agregar un nueva tabla o para visualizar los datos de la tabla
    boton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        modeloRegistro.setArchivoSeleccionado(texto);
        iniciarGestion(texto);
        actualizarPanelBotones(texto);
      }
    });
  }

  /*Refresca el panel de boton a la hora de hacer cualquier boton que esta en 
  el panel a excepcion del que se llama Agregar */
  private void actualizarPanelBotones(String bandera) {
    if (bandera.contains("Agregar")) {
      refrescarPanelBotones();
    }
  }

  /*Refresca el panel sin ninguna restriccion o condicion*/
  public void refrescarPanelBotones() {
    modeloRegistro.cargarVectorArchivos();
    ventanaRegistro.getPanelBotones().removeAll();
    colocarBtnAgregarMas();
    colocarPanelBoton();
    ventanaRegistro.getPanelBotones().revalidate();
    ventanaRegistro.getPanelBotones().repaint();
  }

  /*Coloca un boton especifico al panel de botones, este boton se encarga de agregar 
  nuevas tablas a la vista*/
  private void colocarBtnAgregarMas() {
    agregarBoton(" Agregar nuevo +", Color.white);
    modeloRegistro.setTablasGeneradas(modeloRegistro.getTablasGeneradas() + 1);
  }

  /*Su funcion es crear nuevas tablas en la base de datos dese la vista, 
  en caso de que no exista la carpeta la carpeta de camps o ajuste se crearan automaticamente*/
  public void iniciarGestion(String a) {
    if (a.contains("Agregar")) {
      ventanaRegistro.setTitle("Agregar:");
      System.out.println(modeloRegistro.getRutaArchivoDefecto());
      if (modeloRegistro.getRutaArchivoGestor().contarRegistros() < 1) {
        String salida;
        salida = SelectorArchivos.abrirCarpeta(this);

        if (!salida.trim().equals("")) {
          modeloRegistro.getRutaArchivoGestor().agregarRegistro(new String[]{"ruta", salida});
          ModeloRegistro.crearCarpeta("Carpeta de campos tabla",
                  modeloRegistro.getRutaArchivoDefecto() + "\\");
          ModeloRegistro.crearCarpeta("Carpeta de ajuste tabla",
                  modeloRegistro.getRutaArchivoDefecto() + "\\");
        }
      } else { // Abre el modulo de crear tabla en caso de que se cumpla las anterios condiciones.
        VentanaCrearTabla ventanaCrearTabla = new VentanaCrearTabla();
        ModeloCrearTabla modeloCrearTabla
                = new ModeloCrearTabla(modeloRegistro.getRutaArchivoDefecto() + "\\");
        ControladorCrearTabla controladorCrearTabla
                = new ControladorCrearTabla(ventanaCrearTabla, modeloCrearTabla, this);
        modeloCrearTabla.setCarpetaCampo("Carpeta de campos tabla\\");
        modeloCrearTabla.setCarpetaAjuste("Carpeta de ajuste tabla\\");
        ventanaCrearTabla.setVisible(true);
      }

    } else { // si es un boton distinto al que dice agregar se mostrara todos lo registros segun la tabla clickeada.
      cargarTabla(modeloRegistro.getRutaArchivoDefecto() + "\\"
              + "Carpeta de campos tabla" + "\\" + a + "-Campo"
              + ".txt", modeloRegistro.getRutaArchivoDefecto() + "\\" + a + ".txt");
      ventanaRegistro.setTitle("ruta= " + modeloRegistro.getRutaArchivoDefecto() + "\\"
              + modeloRegistro.getArchivoSeleccionado());
    }

  }

  /*
  Carga todos los registros de la tabla seleccionada al jtable 
   */
  private void cargarRegistros(DefaultTableModel modelo, String rutaArchivoRegistro, int columnas) {
    GestionDataFileArrayList rutaArchivoRegistros = new GestionDataFileArrayList(rutaArchivoRegistro, columnas);
    String matriz[][] = rutaArchivoRegistros.toMatriz();
    String vector[] = new String[columnas];
    for (int i = 0; i < matriz.length; i++) {
      for (int j = 0; j < matriz[0].length; j++) {
        vector[j] = matriz[i][j];

      }
      modelo.addRow(vector);
    }
  }

  /*Carga las columnas de la tabla seleccionada al jtable*/
  private void cargarCampos(DefaultTableModel modelo, String rutaArchivoCampo, String rutaArchivoRegistro) {
    GestionDataFileArrayList rutaArchivoCampos = new GestionDataFileArrayList(rutaArchivoCampo, 1);
    ArrayList<String> listaCampos = rutaArchivoCampos.obtenerRegistros();
    for (int i = 0; i < listaCampos.size(); i++) {
      modelo.addColumn(listaCampos.get(i));
    }
    cargarRegistros(modelo, rutaArchivoRegistro, listaCampos.size());

  }

  /**
   * Carga el JTable desde el jframe o vista y lo actualiza.
   *
   * @param rutaArchivoCampo
   * @param rutaArchivoRegistro
   */
  public void cargarTabla(String rutaArchivoCampo, String rutaArchivoRegistro) {
    DefaultTableModel modelo = new DefaultTableModel();
    cargarCampos(modelo, rutaArchivoCampo, rutaArchivoRegistro);
    ventanaRegistro.getjTable1().setModel(modelo);
    ventanaRegistro.getjTable1().revalidate();
    ventanaRegistro.getjTable1().repaint();
    ventanaRegistro.getjPanel1().revalidate();
    ventanaRegistro.getjPanel1().repaint();
  }

  /*Evento que activa los metodos que refresca el panel de botones y la tabla*/
  private void eventoRefrescar() {
    ventanaRegistro.getjMenuItem1().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        refrescarPanelBotones();
        if (modeloRegistro.getArchivoSeleccionado() != null
                && !modeloRegistro.getArchivoSeleccionado().contains("Agregar nuevo +")) {
          cargarTabla(modeloRegistro.getRutaArchivoDefecto() + "\\"
                  + "Carpeta de campos tabla" + "\\"
                  + modeloRegistro.getArchivoSeleccionado() + "-Campo"
                  + ".txt", modeloRegistro.getRutaArchivoDefecto()
                  + "\\" + modeloRegistro.getArchivoSeleccionado() + ".txt");
        }
      }
    });
  }

  /*Evento de menuItem para salir del programa*/
  private void eventoCerrarTodo() {
    ventanaRegistro.getjMenuItem5().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
  }

  /*Evento que activa el proceso de exportar el CSV*/
  private void eventoExportar() {
    ventanaRegistro.getMenuExportar().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (modeloRegistro.getArchivoSeleccionado() != null
                && !modeloRegistro.getArchivoSeleccionado().contains("Agregar")) {
          exportarCSV();
          CuadroMensaje.mensajeVentana("Sa ha exportado un archivo",
                  modeloRegistro.getArchivoSeleccionado());
        } else {
          CuadroMensaje.mensajeVentana("Seleccione al menos un archivo",
                  modeloRegistro.getArchivoSeleccionado());
        }
      }
    });
  }

  /*Evento que activa el proceso de importar el CSV*/
  private void eventoImportar() {
    ventanaRegistro.getMenuImportar().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        importarCSV();
      }
    });
  }

  /*realizar todo el proceso a la hora de importar un CSV*/
  private void importarCSV() {
    if (modeloRegistro.getRutaArchivoGestor().contarRegistros() > 0) {
      String separador = modeloRegistro.getRutaArchivoGestor().getSeparador();
      String rutaAbsoluta = SelectorArchivos.getRutaAbsCSV(separador);
      String nombreArchivo = "";

      if (rutaAbsoluta.trim().length() > 0) {
        nombreArchivo = SelectorArchivos.getNamePorAbsPath(rutaAbsoluta).replace(".csv", ".txt");
        if (ModeloCrearTabla.validarArchivoNoExiste(modeloRegistro.getRutaArchivoDefecto()
                + "\\" + nombreArchivo.replace(".txt", ""))) {
          System.out.println(SelectorArchivos.mostrarStringCSV(separador, rutaAbsoluta));
          // Crea la tabla de ajustes
          modeloRegistro.crearArchivoTxtEnRuta(modeloRegistro.getRutaArchivoDefecto() + "\\"
                  + "Carpeta de ajuste tabla" + "\\" + nombreArchivo.replace(".txt", "") + "-Ajuste"
                  + ".txt", nombreArchivo.replace(".txt", "") + "-" + "13-127-68");
          // Crea la tabla de campos
          modeloRegistro.crearArchivoTxtEnRuta(modeloRegistro.getRutaArchivoDefecto() + "\\"
                  + "Carpeta de campos tabla" + "\\" + nombreArchivo.replace(".txt", "") + "-Campo"
                  + ".txt", String.join("\n", SelectorArchivos.mostrarFilaEspecificaCSV(separador,
                          rutaAbsoluta, 0).split(separador)));
          // Crea la tabla del archivo
          modeloRegistro.crearArchivoTxtEnRuta(modeloRegistro.getRutaArchivoDefecto() + "\\"
                  + nombreArchivo, SelectorArchivos.mostrarCSVIniciandoEn(separador, rutaAbsoluta, 1)
                  + "\n");
          CuadroMensaje.mensajeVentana("Archivo CSV importado exitosamente",
                  modeloRegistro.getArchivoSeleccionado());
          ventanaRegistro.getjMenuItem1().doClick();
        } else {
          CuadroMensaje.mensajeVentana("Ya hay un archivo con el mismo nombre, intente cambiarlo",
                  rutaAbsoluta);
        }
      }

    } else {
      CuadroMensaje.mensajeVentana("No se ha creado la carpeta principal",
              modeloRegistro.getArchivoSeleccionado());
    }
  }

  /*realizar todo el proceso a la hora de exportar un CSV*/
  private void exportarCSV() {
    GestionDataFileArrayList rutaArchivoCampos
            = new GestionDataFileArrayList(modeloRegistro.getRutaArchivoDefecto() + "\\"
                    + "Carpeta de campos tabla" + "\\"
                    + modeloRegistro.getArchivoSeleccionado() + "-Campo"
                    + ".txt", 1);
    ArrayList<String> listaCampos = rutaArchivoCampos.obtenerRegistros();
    GestionDataFileArrayList rutaArchivoRegistros
            = new GestionDataFileArrayList(modeloRegistro.getRutaArchivoDefecto()
                    + "\\" + modeloRegistro.getArchivoSeleccionado() + ".txt", listaCampos.size());
    String matriz[][] = modeloRegistro.crearMatrizParaCSV(
            rutaArchivoRegistros.toMatriz(), rutaArchivoCampos.getVectorRegistro());
    SelectorArchivos.crearCSV(matriz, modeloRegistro.getArchivoSeleccionado());
  }

  /**
   * Evento que activa la funcion para eliminar una tabla. elimina el archivo
   * principal, ajustes y el de campos de un solo
   */
  private void eventoEliminarTabla() {
    ventanaRegistro.popupItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (modeloRegistro.getArchivoSeleccionado() != null
                && !modeloRegistro.getArchivoSeleccionado().contains("Agregar")) {
          // Elimina el archivo principal
          modeloRegistro.eliminarArchivoTXT(modeloRegistro.getRutaArchivoDefecto()
                  + "\\" + modeloRegistro.getArchivoSeleccionado() + ".txt");
          // Elimina el archivo ajustes
          modeloRegistro.eliminarArchivoTXT(modeloRegistro.getRutaArchivoDefecto()
                  + "\\Carpeta de ajuste tabla\\" + modeloRegistro.getArchivoSeleccionado()
                  + "-Ajuste.txt");
          // Elimina el archivo campos
          modeloRegistro.eliminarArchivoTXT(modeloRegistro.getRutaArchivoDefecto()
                  + "\\Carpeta de campos tabla\\" + modeloRegistro.getArchivoSeleccionado()
                  + "-Campo.txt");

          modeloRegistro.setArchivoSeleccionado("Agregar nuevo +");
       
          ventanaRegistro.getjMenuItem1().doClick(); // Para refrescar la venta luego de la eliminacion de la tabla

        } else {
          CuadroMensaje.mensajeVentana("Seleccione al menos un archivo",
                  modeloRegistro.getArchivoSeleccionado());
        }
      }
    });
  }

  /*Activa el modulo para visualizar las columnas de los registros con mas detalles*/
  private void eventoMasVisualizarRegistro() {
    ventanaRegistro.getjMenuItem4().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (!modeloRegistro.getListaArchivos().isEmpty()) {
          if (modeloRegistro.getArchivoSeleccionado() != null
                  && !modeloRegistro.getArchivoSeleccionado().contains("Agregar")) {
            GestionDataFileArrayList rutaArchivoCampos
                    = new GestionDataFileArrayList(modeloRegistro.getRutaArchivoDefecto() + "\\"
                            + "Carpeta de campos tabla" + "\\"
                            + modeloRegistro.getArchivoSeleccionado() + "-Campo"
                            + ".txt", 1);
            ArrayList<String> listaCampos = rutaArchivoCampos.obtenerRegistros();
            ModeloColumnas m = new ModeloColumnas(listaCampos,
                    modeloRegistro.getRutaArchivoDefecto()
                    + "\\" + modeloRegistro.getArchivoSeleccionado() + ".txt");
            VistaColumnas v = new VistaColumnas();
            ControladorColumnas c = new ControladorColumnas(m, v);
            v.setVisible(true);
            v.setDefaultCloseOperation(v.DISPOSE_ON_CLOSE);
          } else {
            CuadroMensaje.mensajeVentana("Seleccione al menos un archivo",
                    modeloRegistro.getArchivoSeleccionado());
          }
        }
      }
    });
  }

  /**
   * Evento de registro de la ruta en donde se ubicara la base de datos, solo se
   * activa en caso de que no se haya asignado la ruta y si es asi se creara las
   * carpetas de campos y de ajustes desde la ruta proporcionado por el
   * fileChooser.
   */
  private void eventoRegistro() {
    ventanaRegistro.getjMenuItem3().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (modeloRegistro.getRutaArchivoGestor().contarRegistros() < 1) {
          String salida;
          salida = SelectorArchivos.abrirCarpeta(ventanaRegistro);
          if (!salida.trim().equals("")) {
            // Guarda la ruta de persistencia
            modeloRegistro.getRutaArchivoGestor().agregarRegistro(new String[]{"ruta", salida});
            // Crea la carpeta de campos
            modeloRegistro.crearCarpeta("Carpeta de campos tabla",
                    modeloRegistro.getRutaArchivoDefecto() + "\\");
            // Crea la carpeta de ajustes
            modeloRegistro.crearCarpeta("Carpeta de ajuste tabla",
                    modeloRegistro.getRutaArchivoDefecto() + "\\");
          }
        } else {
          CuadroMensaje.mensajeVentana("Ya se encuentra abierta una carpeta",
                  modeloRegistro.getArchivoSeleccionado());
        }
      }
    });
  }

  /*Evento que removera la carpeta del programa y se se hace eliminando la ruta de persistencia*/
  private void eventoCerrarCarpeta() {
    ventanaRegistro.getjMenuItem2().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        modeloRegistro.getRutaArchivoGestor().borrarRegistros();
        ventanaRegistro.getjMenuItem1().doClick();
        CuadroMensaje.mensajeVentana("Se ha cerrado la carpeta",
                modeloRegistro.getArchivoSeleccionado());
      }
    });
  }

  /*Evento que activa la ventana para consultar un registro de la tabla*/
  private void eventoConsultar() {
    ventanaRegistro.getBtnConsultar().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (modeloRegistro.getArchivoSeleccionado() != null
                && !modeloRegistro.getArchivoSeleccionado().contains("Agregar")) {
          abrirVentanaGestion(1);
        } else {
          CuadroMensaje.mensajeVentana("Seleccione al menos un archivo",
                  modeloRegistro.getArchivoSeleccionado());
        }
      }
    });
  }

  /*Evento que activa la ventana para agregar un registro a la tabla*/
  private void eventoAgregar() {
    ventanaRegistro.getBtnAgregar().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (modeloRegistro.getArchivoSeleccionado() != null
                && !modeloRegistro.getArchivoSeleccionado().contains("Agregar")) {
          abrirVentanaGestion(2);
        } else {
          CuadroMensaje.mensajeVentana("Seleccione al menos un archivo",
                  modeloRegistro.getArchivoSeleccionado());
        }
      }
    });
  }

  /*Evento que activa la ventana para eliminar un registro de la tabla*/
  private void eventoEliminar() {
    ventanaRegistro.getBtnEliminar().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (modeloRegistro.getArchivoSeleccionado() != null
                && !modeloRegistro.getArchivoSeleccionado().contains("Agregar")) {
          abrirVentanaGestion(3);
        } else {
          CuadroMensaje.mensajeVentana("Seleccione al menos un archivo",
                  modeloRegistro.getArchivoSeleccionado());
        }
      }
    });
  }

  /*Evento que activa la ventana para modificar un registro de la tabla*/
  private void eventoModificar() {
    ventanaRegistro.getBtnModificar().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (modeloRegistro.getArchivoSeleccionado() != null
                && !modeloRegistro.getArchivoSeleccionado().contains("Agregar")) {
          abrirVentanaGestion(4);
        } else {
          CuadroMensaje.mensajeVentana("Seleccione al menos un archivo",
                  modeloRegistro.getArchivoSeleccionado());
        }
      }
    });
  }

  /*Abre la ventana del modulo de gestion y su funcionamiento dependera del parametro opcion
  Para mas detalles, ve a la descripcion de su clase*/
  private void abrirVentanaGestion(int opcion) {
    VentanaGestion ventanaGestion = new VentanaGestion();
    ModeloGestion modeloGestion = new ModeloGestion(modeloRegistro.getRutaArchivoDefecto()
            + "\\Carpeta de campos tabla\\"
            + modeloRegistro.getArchivoSeleccionado()
            + "-Campo.txt", modeloRegistro.getRutaArchivoDefecto()
            + "\\" + modeloRegistro.getArchivoSeleccionado() + ".txt", opcion);
    ventanaGestion.setDefaultCloseOperation(ventanaGestion.DISPOSE_ON_CLOSE);
    ControladorGestion controladorGestion = new ControladorGestion(modeloGestion, ventanaGestion, this);
    ventanaGestion.setVisible(true);
  }

}
