package moduloCrearTabla.vista;

import java.awt.*;
import javax.swing.*;
import moduloRegistro.vista.*;

/**
 * Vista del modulo crear tabla
 *
 * @author: Albin Liang
 * @version: 7/2023
 *
 */
public class VentanaCrearTabla extends javax.swing.JFrame {

  private Color colorSeleccionado;
  public JButton botonCrearTabla;
  private VentanaRegistro ventanaRegistro;
  /**
   * Creates new form VentanaCrearTabla
   */
  public JTextField vectorTextfield[];

  public VentanaCrearTabla() {
    initComponents();
    colorSeleccionado = Color.WHITE;
    jScrollPane2.getVerticalScrollBar().setUnitIncrement(15); // dar sensibilidad al jscroll de manera vertical
    setLocationRelativeTo(null);
    setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
  }

  public Color getColorSeleccionado() {
    return colorSeleccionado;
  }

  public void setColorSeleccionado(Color colorSeleccionado) {
    this.colorSeleccionado = colorSeleccionado;
  }

  public JButton getBotonCrearTabla() {
    return botonCrearTabla;
  }

  public void setBotonCrearTabla(JButton botonCrearTabla) {
    this.botonCrearTabla = botonCrearTabla;
  }

  public VentanaRegistro getVentanaRegistro() {
    return ventanaRegistro;
  }

  public void setVentanaRegistro(VentanaRegistro ventanaRegistro) {
    this.ventanaRegistro = ventanaRegistro;
  }

  public JTextField[] getVectorTextfield() {
    return vectorTextfield;
  }

  public void setVectorTextfield(JTextField[] vectorTextfield) {
    this.vectorTextfield = vectorTextfield;
  }

  public JLabel getEtiquetaColor() {
    return etiquetaColor;
  }

  public void setEtiquetaColor(JLabel etiquetaColor) {
    this.etiquetaColor = etiquetaColor;
  }

  public JButton getjButton1() {
    return jButton1;
  }

  public void setjButton1(JButton jButton1) {
    this.jButton1 = jButton1;
  }

  public JLabel getjLabel1() {
    return jLabel1;
  }

  public void setjLabel1(JLabel jLabel1) {
    this.jLabel1 = jLabel1;
  }

  public JLabel getjLabel2() {
    return jLabel2;
  }

  public void setjLabel2(JLabel jLabel2) {
    this.jLabel2 = jLabel2;
  }

  public JLabel getjLabel3() {
    return jLabel3;
  }

  public void setjLabel3(JLabel jLabel3) {
    this.jLabel3 = jLabel3;
  }

  public JPanel getjPanel1() {
    return jPanel1;
  }

  public void setjPanel1(JPanel jPanel1) {
    this.jPanel1 = jPanel1;
  }

  public JScrollPane getjScrollPane2() {
    return jScrollPane2;
  }

  public void setjScrollPane2(JScrollPane jScrollPane2) {
    this.jScrollPane2 = jScrollPane2;
  }

  public JTextField getjTextField1() {
    return jTextField1;
  }

  public void setjTextField1(JTextField jTextField1) {
    this.jTextField1 = jTextField1;
  }

  public JPanel getPanelCampos() {
    return panelCampos;
  }

  public void setPanelCampos(JPanel panelCampos) {
    this.panelCampos = panelCampos;
  }

  public JTextField getTxtCampo() {
    return txtCampo;
  }

  public void setTxtCampo(JTextField txtCampo) {
    this.txtCampo = txtCampo;
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jTextField1 = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    txtCampo = new javax.swing.JTextField();
    jButton1 = new javax.swing.JButton();
    jLabel3 = new javax.swing.JLabel();
    etiquetaColor = new javax.swing.JLabel();
    jScrollPane2 = new javax.swing.JScrollPane();
    panelCampos = new javax.swing.JPanel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel1.setBackground(new java.awt.Color(255, 255, 255));

    jLabel1.setForeground(new java.awt.Color(0, 0, 0));
    jLabel1.setText("Numero de campos: ");

    jTextField1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jTextField1ActionPerformed(evt);
      }
    });

    jLabel2.setForeground(new java.awt.Color(0, 0, 0));
    jLabel2.setText("Nombre de la tabla:");

    jButton1.setText("Generar campos");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jLabel3.setForeground(new java.awt.Color(0, 0, 0));
    jLabel3.setText("Color tabla (opcional):");

    etiquetaColor.setBackground(new java.awt.Color(255, 255, 255));
    etiquetaColor.setForeground(new java.awt.Color(0, 0, 0));
    etiquetaColor.setText("Asignar");
    etiquetaColor.setOpaque(true);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(26, 26, 26)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel2)
          .addComponent(jLabel1)
          .addComponent(jLabel3))
        .addGap(28, 28, 28)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
              .addComponent(txtCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addComponent(etiquetaColor))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(12, 12, 12)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(21, 21, 21)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(txtCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButton1)
          .addComponent(jLabel1))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(etiquetaColor))
        .addGap(15, 15, 15))
    );

    panelCampos.setBackground(new java.awt.Color(255, 255, 255));
    panelCampos.setForeground(new java.awt.Color(255, 255, 255));
    panelCampos.setLayout(new java.awt.GridLayout(1000, 2, 5, 5));
    jScrollPane2.setViewportView(panelCampos);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jTextField1ActionPerformed

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

  }//GEN-LAST:event_jButton1ActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    VentanaCrearTabla v = new VentanaCrearTabla();
    v.setVisible(true);
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel etiquetaColor;
  private javax.swing.JButton jButton1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JTextField jTextField1;
  private javax.swing.JPanel panelCampos;
  private javax.swing.JTextField txtCampo;
  // End of variables declaration//GEN-END:variables
}
