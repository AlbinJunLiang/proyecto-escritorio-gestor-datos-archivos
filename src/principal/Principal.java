package principal;

import moduloRegistro.vista.*;
import moduloRegistro.modelo.*;
import moduloRegistro.controlador.*;

/**
 *
 * GESTOR DE DATOS DE ARCHIVOS .TXT
 *
 * -------Descripcion del proyecto--------------------
 *
 * Es un simple sistema de escritorio para gestionar datos en un archivo .txt,
 * realiza tareas como para insertar, eliminar, modificar y consultar los datos
 * registrados en el archivo. Tambien soporta la gestion en diferentes archivos.
 *
 * Se incluye la opcion de importar datos desde un .CSV y exporta los datos del
 * archivo en formato .CSV para sacar el maximo provecho del programa y poder
 * utilizar los datos en otras herramientas como excel, libreOfice Calcs, Google
 * sheets y etc.
 *
 * Los archivos con datos se guardara en una carpeta seleccionada por el usuario
 * a la hora de ejecutar el programa.
 *
 * ------Detalles de la arquitectura y tecnologias utilizadas -----------
 *
 * Para el desarrollo de este programa se utilzo el lenguaje JAVA de la
 * plataforma Standard Edition, dicha version seria la 8.0 en adelante. Para la
 * vista o capa visual se utiliza la biblioteca SWING 8.0 en adelante.
 *
 * El diseño de la capa de persistencia esta basada en el manejo de archivos con
 * la libreria IO de java. durante la ejecucion del programa se crea una carpeta
 * nombrada como 'rutaPersistencia' y dentro de ella esta el archivo
 * 'ArchivoDefecto.txt' que sirve para guardar la ruta de la carpeta que fue
 * seleccionada para guardar los archivos .txt. En el momento que se haya
 * seleccionado la carpeta que va guardar los archivos, se creara de manera
 * automatica dos carpetas 'Carpeta de ajuste tabla' para guardar detalles
 * visuales de como se representara la tabla en el programa y tambien esta
 * 'Carpeta de campos tabla' que guardara los campos que va tener un registro
 * del archivo (Atributos).
 *
 * El diseno del programa se intenta acercar a la arquitectura MVC, la cual se
 * aplico en cada modulo del programa (Modulo columnas, Modulo crear tabla,
 * Modulo gestion y Modulo registro).
 *
 * ------Requisitos tecnicos para utilizar el programa -------------------------
 * Por el momento el programa solo se ha visto que funciona sin problemas en el
 * sistema operativo Windows de 8.0 y posteriores, ya en LINUX se intentara
 * ponerlo a prueba en algun momento.
 *
 *
 * -Sistema operativos Windows y tener instalado JRE o JDK de manera correcta.
 *
 * Para ejecutar el programa basta darle doble click al .JAR y no olvide que
 * nunca se borrar alguna carpeta generarada durante la ejecucion al menos que
 * sea necesario o de lo contrario tendra fallas en su funcionamiento.
 *
 * @author Albin Liang
 * @version 1.0 - 30/7/2023
 *
 */
public class Principal {

  public static void main(String[] args) {
    VentanaRegistro v = new VentanaRegistro();
    ModeloRegistro m = new ModeloRegistro();
    ControladorRegistro c = new ControladorRegistro(m, v);
    v.setVisible(true);
  }

  /**
   * El objetivo principal de este programa fue para quitarme el aburrimiento e
   * intentar hacer algun programa de escritorio hecho con java y el otro
   * objetivo era crear una aplicacion de escritorio que podia guardar datos de
   * manera dinamica o mejor dicho crear un sistema que permite hacer archivos
   * de 'N' cantidades de columnas sin tener que modificar codigo, en la que el
   * usuario podia asignar el numero de campos que va tener la tabla de datos.
   *
   * ---------- Otros funcionalidades y caracteriscas que se pensara en implenta
   * en algun momento despues:
   *
   * -FILTRADO DE UN CONSULTAS POR MEDIO DE UN PALABRA, PREFIJO Y ETC EN LAS
   * JTable (TABLAS).
   *
   * -MEJORA EN LA CAPA DE PRESENTACION, MEJORA VISUALES EN LA GUI (color,
   * fuentes y etc).
   *
   * -OPCION DE CAMBIAR EL COLOR DE LAS TABLAS (PARTE PRESENTACION).
   *
   * -OPCION PARA MODIFICAR O CAMBIAR EL NOMBRE DE LAS TABLAS.
   *
   * Al ser la primera version del programa, podra aparecer errores en algun
   * momento por lo que si algun usuario encuentra uno, hazmelo saber en los
   * comentarios.
   *
   * Cabe aclarar que esta hecho para fines didacticos y cualquiera que
   * encuentre este proyecto podra modificarlo y utilizarlo sin problemas.
   *
   */
}
