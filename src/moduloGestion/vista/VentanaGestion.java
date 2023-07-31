/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package moduloGestion.vista;

import javax.swing.*;

/**
 * Vista del modulo para gestion
 *
 * @author: Albin Liang
 * @version: 7/2023
 *
 */
public class VentanaGestion extends javax.swing.JFrame {

  /**
   * Creates new form VentanaGestion
   */
  private int numeroCampos;
  public JTextField[] vectorTextfield;
  public JButton botonAccion;

  public VentanaGestion() {
    initComponents();
    jScrollPane1.getVerticalScrollBar().setUnitIncrement(15); // da 15 de sensibildad al scroll verticalmente
    setLocationRelativeTo(null);
  }

  public VentanaGestion(String a) {
    setTitle(a);
    initComponents();
    jScrollPane1.getVerticalScrollBar().setUnitIncrement(15);
    setLocationRelativeTo(null);
  }

  public int getCampo() {
    return numeroCampos;
  }

  public void setCampo(int campo) {
    this.numeroCampos = campo;
  }

  public JTextField[] getVectorTextfield() {
    return vectorTextfield;
  }

  public void setVectorTextfield(JTextField[] vectorTextfield) {
    this.vectorTextfield = vectorTextfield;
  }

  public JButton getBotonAccion() {
    return botonAccion;
  }

  public void setBotonAccion(JButton botonAccion) {
    this.botonAccion = botonAccion;
  }

  public JLabel getEtiquetaTitulo() {
    return etiquetaTitulo;
  }

  public void setEtiquetaTitulo(JLabel etiquetaTitulo) {
    this.etiquetaTitulo = etiquetaTitulo;
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

  public JScrollPane getjScrollPane1() {
    return jScrollPane1;
  }

  public void setjScrollPane1(JScrollPane jScrollPane1) {
    this.jScrollPane1 = jScrollPane1;
  }

  public JTextField getjTextField1() {
    return jTextField1;
  }

  public void setjTextField1(JTextField jTextField1) {
    this.jTextField1 = jTextField1;
  }

  public JPanel getPanelFlexible() {
    return panelFlexible;
  }

  public void setPanelFlexible(JPanel panelFlexible) {
    this.panelFlexible = panelFlexible;
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
    etiquetaTitulo = new javax.swing.JLabel();
    jTextField1 = new javax.swing.JTextField();
    jButton1 = new javax.swing.JButton();
    jLabel3 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    panelFlexible = new javax.swing.JPanel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel1.setBackground(new java.awt.Color(255, 255, 255));

    jLabel1.setText("Ingrese el identificador:");

    etiquetaTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    etiquetaTitulo.setText("Editar");

    jButton1.setText("Realizar");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jLabel3.setForeground(new java.awt.Color(255, 0, 0));
    jLabel3.setText(" ");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(etiquetaTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)))))
        .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(etiquetaTitulo)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jButton1)
          .addComponent(jLabel3))
        .addContainerGap(28, Short.MAX_VALUE))
    );

    panelFlexible.setBackground(new java.awt.Color(255, 255, 255));
    panelFlexible.setLayout(new java.awt.GridLayout(numeroCampos, 1, 5, 5));
    jScrollPane1.setViewportView(panelFlexible);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane1)
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

  }//GEN-LAST:event_jButton1ActionPerformed

  public static void main(String args[]) {
    VentanaGestion ventanaGestion = new VentanaGestion();
    ventanaGestion.setVisible(true);
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel etiquetaTitulo;
  private javax.swing.JButton jButton1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextField jTextField1;
  private javax.swing.JPanel panelFlexible;
  // End of variables declaration//GEN-END:variables
}