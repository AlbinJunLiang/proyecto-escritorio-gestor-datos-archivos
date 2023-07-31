package clasesUtilidades;

import java.awt.*;
import javax.swing.*;

/**
 * Para mostrar mensajes en pantalla con un JOption digamos que personalizado
 * para el programa.
 *
 * @author: Albin Liang
 * @version: 7/2023
 *
 */
public class CuadroMensaje {

  /*Metodo de JOption personalizado*/
  public static void mensajeVentana(String texto, String titulo) {
    UIManager ui = new UIManager();
    ui.put("OptionPane.background", new Color(255, 255, 255));
    ui.put("Panel.background", new Color(255, 255, 255));
    ui.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 14));
    ui.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 12));
    ui.put("OptionPane.messageForeground", new Color(0, 0, 0));
    ui.put("Panel.Foreground", new Color(0, 0, 0));
    ui.put("Button.background", new Color(250, 230, 250));
    JOptionPane.showMessageDialog(null, new JLabel(texto, JLabel.CENTER), titulo, JOptionPane.PLAIN_MESSAGE);
  }

  public static void main(String[] args) {
    mensajeVentana("Hola", "Titulo");
  }
}
