## Programa de gestor de archivos .TXT (aplicacion escritorio Java)


  Es un simple sistema de escritorio para gestionar datos en un archivo .txt,
 realiza tareas como para insertar, eliminar, modificar y consultar los datos
  registrados en el archivo. Tambien soporta la gestion en diferentes archivos. 
  
  **Se advierte que en el programa al ser datos almacenados en archivos planos, obviamente no tendra la misma eficiencia que una base de datos (SQL, noSQL y etc).**


### Interfaz gráfica de usuario
###### Agregando un registro al archivo
<p align="center">
  <img src="https://github.com/AlbinJunLiang/proyecto-escritorio-gestor-datos-archivos/blob/main/imagenes%20del%20programa/creandoArchivo.jpg?raw=true" width="200">
</p>


### Detalles de la arquitectura y tecnologias utilizadas
<p align="center">
  <img src="URL_de_la_imagen" alt="Descripción de la imagen">
</p>
<p>
Para el desarrollo de este programa se utilizó el lenguaje Java de la plataforma** Standard Edition**, específicamente **la versión 8.0 **en adelante. Para la vista o capa visual se utiliza la biblioteca Swing en la versión 8.0 en adelante.

El diseño de la capa de persistencia está basada en el manejo de archivos utilizando la **librería IO** de Java. Durante la ejecución del programa, se crea una carpeta llamada 'rutaPersistencia' y dentro de ella se encuentra el archivo 'ArchivoDefecto.txt', que se utiliza para guardar la ruta de la carpeta seleccionada para guardar los archivos .txt. Una vez que se ha seleccionado la carpeta para guardar los archivos, se crearán automáticamente dos carpetas: 'Carpeta de ajuste tabla', que almacenará detalles visuales sobre cómo se representará la tabla en el programa, y 'Carpeta de campos tabla', que guardará los campos (atributos) que tendrá un registro del archivo.

El programa utiliza estas carpetas y archivos para gestionar el almacenamiento y acceso a los datos, lo que permite mantener la información persistente entre diferentes ejecuciones del programa.

Es importante destacar que el programa se basa en Java SE 8.0 o versiones posteriores y utiliza la **biblioteca Swing** para la interfaz gráfica, así como el manejo de archivos utilizando la librería IO de Java para la capa de persistencia.

El diseño del programa se intenta acercar a la arquitectura MVC, la cual se aplico en cada modulo del programa (Modulo columnas, Modulo crear tabla, Modulo gestion y Modulo registro).
</p>


### Requisitos técnicos para utilizar el programa
<p>
  Por el momento el programa solo se ha visto que funciona sin problemas en el sistema  operativo Windows de 8.0 y posteriores, ya en LINUX se intentara ponerlo a prueba en algun momento.
</p>
  - Sistema operativos Windows (Preferiblemente versiones de 8 en adelante).
  - Tener instalado JRE o JDK de manera correcta.
  -  Para ejecutar el programa basta darle doble click al .JAR y no olvide que nunca se borrar alguna carpeta generarada durante la ejecucion al menos que sea necesario o de lo contrario tendra fallas en su funcionamiento.

### Guía breve para los usuarios:
#####1-Abrir la carpeta principal
- Es importante seleccionar la carpeta que guardara los archivos con datos y para hacer esto tiene que hacer click en el campo izquierdo de fondo blanco de la interfaz gráfica que dice **"Agregar nuevo +"** o algo similar.
- Por ultimo, le aparecera un selector de archivo la cual el usuario seleccionara la carpeta, **debe ser una carpeta totalmente nueva **o que **no contenga ningun archivo**.

##### 2-¿Como se crea un archivo para registrar datos?
- Para crear un archivo primero debe haber hecho el primer paso de lo contrario no dejara crear el archivo, si ya lo haz hecho puede hacer click de nuevo en el campo del lado izquierdo, el mismo del paso 1 (Agregar nuevo +) y ahi aparecerá una ventana que solicitara el nombre del archivo, el número de columnas por registro y etc.
- Luego se da click en el boton generar campos, esto generara un formulario que sera donde se va poner el nombre de cada columna, se recomienda que no deje campos vacios.
- Continuar con dar click en el boton crear tabla.

##### 3-¿Como hago las funciones de consultar, eliminar, agregar y modificar?
- Primero que nada, es necesario seleccionar la tabla y si ya lo tiene hecho nada más se ubica a la parte inferior del programa, ahi estará los botones de eliminar, consultar, modificar,agregar; el cual aparecera una nueva ventana.
- Para agregar ingrese primero el identificador (ID) y llenar los campos para finalmente hacer click en el botón de agregar.
- Para consultar y eliminar solo ingrese el ID.
- Para actualizar o modificar tiene que ingresar el ID y en la parte inferior de la ventana flotante se mostrara los campos con los datos que pueden ser editados por el usuario.

##### Otras funcionalidades del programa:
- Importar CSV (Archivo separado por comas), se podrá importar una tabla a traves de un .csv y esto se hace en desde el menu del programa especificamente en la parte de **File**.
- Exportar un CSV, puedes seleccionar una tabla y guardarlo fuera del programa en un CSV y esta ubicado en la misma parte de la opcion de importar.
- Ver con mas detalles los datos de las columnas de un registro, esta ubicado en el menú y en el item que dice **Mas** , ahi le puedes dar click y saldra un ventana, para ir visualizando otros campos puede presionar el Slider e ir modificando cada campo si el usuario lo requiere. Esta funcion esta por si hay un campo con un texto muy largo.

### Nota del desarrollador


El objetivo principal de este programa es combatir el aburrimiento (En realidad para aprender a usar GitHub) y, al mismo tiempo, crear una aplicación de escritorio utilizando Java. El segundo objetivo es desarrollar una aplicación que permita guardar datos de manera dinámica, es decir, crear un sistema que permita generar archivos con una cantidad variable de columnas sin necesidad de modificar el código. Esto le daría al usuario la flexibilidad de asignar el número de campos que va a tener la tabla de datos según sus necesidades.

##### Futuras funcionalidades que se va agregar (Posiblemente): 
- Filtrado de un consultas por medio de un palabra, prefijo y etc en las  jtable (tablas).
- Mejora en la capa de presentacion, mejora visuales en la GUI (color, fuentes y etc).
- opcion de cambiar el color de las tablas (parte presentacion).
- opcion para modificar o cambiar el nombre de las tablas.

Al ser la primera versión del programa, es posible que aparezcan errores en algún momento. Si algún usuario encuentra alguno, agradecería que lo informe en los comentarios.

**Cabe aclarar que este proyecto está hecho con fines didácticos, y cualquier persona que encuentre este proyecto puede modificarlo y utilizarlo sin problemas.**
<br>
<br>
<br>
<br>
