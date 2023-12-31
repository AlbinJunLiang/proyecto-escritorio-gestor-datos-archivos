package moduloRegistro.vista;

import java.awt.*;
import javax.swing.*;

/**
 * Vista del modulo registro
 *
 * @author: Albin Liang
 * @version: 7/2023
 *
 */
public class VentanaRegistro extends javax.swing.JFrame {

  private int botonesGenerados = 0; // para recibir desde los setter 
  // y dar la cantidad de filas al gridLayout del panelPotones
  public JPopupMenu popupMenu;
  public JMenuItem popupItem;

  public VentanaRegistro() {
    initComponents();
    getContentPane().setBackground(new Color(255, 255, 255));
    pack();
    setLocationRelativeTo(null);
    setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    jScrollPane1.getVerticalScrollBar().setUnitIncrement(15);
    popupMenu = new JPopupMenu();
    popupItem = new JMenuItem("Eliminar");
  }

  public int getBotonesGenerados() {
    return botonesGenerados;
  }

  public void setBotonesGenerados(int botonesGenerados) {
    this.botonesGenerados = botonesGenerados;
  }

  public JButton getBtnAgregar() {
    return btnAgregar;
  }

  public void setBtnAgregar(JButton btnAgregar) {
    this.btnAgregar = btnAgregar;
  }

  public JButton getBtnConsultar() {
    return btnConsultar;
  }

  public void setBtnConsultar(JButton btnConsultar) {
    this.btnConsultar = btnConsultar;
  }

  public JButton getBtnEliminar() {
    return btnEliminar;
  }

  public void setBtnEliminar(JButton btnEliminar) {
    this.btnEliminar = btnEliminar;
  }

  public JButton getBtnModificar() {
    return btnModificar;
  }

  public void setBtnModificar(JButton btnModificar) {
    this.btnModificar = btnModificar;
  }

  public JMenu getjMenu1() {
    return jMenu1;
  }

  public void setjMenu1(JMenu jMenu1) {
    this.jMenu1 = jMenu1;
  }

  public JMenu getjMenu2() {
    return jMenu2;
  }

  public void setjMenu2(JMenu jMenu2) {
    this.jMenu2 = jMenu2;
  }

  public JMenuBar getjMenuBar1() {
    return jMenuBar1;
  }

  public void setjMenuBar1(JMenuBar jMenuBar1) {
    this.jMenuBar1 = jMenuBar1;
  }

  public JMenuItem getjMenuItem1() {
    return jMenuItem1;
  }

  public void setjMenuItem1(JMenuItem jMenuItem1) {
    this.jMenuItem1 = jMenuItem1;
  }

  public JMenuItem getjMenuItem2() {
    return jMenuItem2;
  }

  public void setjMenuItem2(JMenuItem jMenuItem2) {
    this.jMenuItem2 = jMenuItem2;
  }

  public JMenuItem getjMenuItem3() {
    return jMenuItem3;
  }

  public void setjMenuItem3(JMenuItem jMenuItem3) {
    this.jMenuItem3 = jMenuItem3;
  }

  public JPanel getjPanel1() {
    return jPanel1;
  }

  public void setjPanel1(JPanel jPanel1) {
    this.jPanel1 = jPanel1;
  }

  public JPanel getjPanel2() {
    return jPanel2;
  }

  public void setjPanel2(JPanel jPanel2) {
    this.jPanel2 = jPanel2;
  }

  public JPanel getjPanel3() {
    return jPanel3;
  }

  public void setjPanel3(JPanel jPanel3) {
    this.jPanel3 = jPanel3;
  }

  public JPanel getjPanel4() {
    return jPanel4;
  }

  public void setjPanel4(JPanel jPanel4) {
    this.jPanel4 = jPanel4;
  }

  public JScrollPane getjScrollPane1() {
    return jScrollPane1;
  }

  public void setjScrollPane1(JScrollPane jScrollPane1) {
    this.jScrollPane1 = jScrollPane1;
  }

  public JScrollPane getjScrollPane2() {
    return jScrollPane2;
  }

  public void setjScrollPane2(JScrollPane jScrollPane2) {
    this.jScrollPane2 = jScrollPane2;
  }

  public JPopupMenu.Separator getjSeparator1() {
    return jSeparator1;
  }

  public void setjSeparator1(JPopupMenu.Separator jSeparator1) {
    this.jSeparator1 = jSeparator1;
  }

  public JTable getjTable1() {
    return jTable1;
  }

  public void setjTable1(JTable jTable1) {
    this.jTable1 = jTable1;
  }

  public JPanel getPanelBotones() {
    return panelBotones;
  }

  public void setPanelBotones(JPanel panelBotones) {
    this.panelBotones = panelBotones;
  }

  public JMenu getjMenu3() {
    return jMenu3;
  }

  public void setjMenu3(JMenu jMenu3) {
    this.jMenu3 = jMenu3;
  }

  public JMenuItem getjMenuItem4() {
    return jMenuItem4;
  }

  public void setjMenuItem4(JMenuItem jMenuItem4) {
    this.jMenuItem4 = jMenuItem4;
  }

  public JMenuItem getjMenuItem5() {
    return jMenuItem5;
  }

  public void setjMenuItem5(JMenuItem jMenuItem5) {
    this.jMenuItem5 = jMenuItem5;
  }

  public JPopupMenu getPopupMenu() {
    return popupMenu;
  }

  public void setPopupMenu(JPopupMenu popupMenu) {
    this.popupMenu = popupMenu;
  }

  public JMenuItem getMenuExportar() {
    return menuExportar;
  }

  public void setMenuExportar(JMenuItem menuExportar) {
    this.menuExportar = menuExportar;
  }

  public JMenuItem getMenuImportar() {
    return menuImportar;
  }

  public void setMenuImportar(JMenuItem menuImportar) {
    this.menuImportar = menuImportar;
  }


  /*
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jScrollPane1 = new javax.swing.JScrollPane();
    panelBotones = new javax.swing.JPanel();
    jPanel1 = new javax.swing.JPanel();
    jScrollPane2 = new javax.swing.JScrollPane();
    jTable1 = new javax.swing.JTable();
    jPanel2 = new javax.swing.JPanel();
    jPanel3 = new javax.swing.JPanel();
    jPanel4 = new javax.swing.JPanel();
    btnAgregar = new javax.swing.JButton();
    btnConsultar = new javax.swing.JButton();
    btnModificar = new javax.swing.JButton();
    btnEliminar = new javax.swing.JButton();
    jMenuBar1 = new javax.swing.JMenuBar();
    jMenu1 = new javax.swing.JMenu();
    jMenuItem2 = new javax.swing.JMenuItem();
    jMenuItem3 = new javax.swing.JMenuItem();
    jSeparator2 = new javax.swing.JPopupMenu.Separator();
    menuImportar = new javax.swing.JMenuItem();
    menuExportar = new javax.swing.JMenuItem();
    jMenu2 = new javax.swing.JMenu();
    jMenuItem1 = new javax.swing.JMenuItem();
    jMenuItem5 = new javax.swing.JMenuItem();
    jSeparator1 = new javax.swing.JPopupMenu.Separator();
    jMenu3 = new javax.swing.JMenu();
    jMenuItem4 = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    panelBotones.setBackground(new java.awt.Color(102, 102, 255));
    panelBotones.setLayout(new java.awt.GridLayout(botonesGenerados, 1));
    jScrollPane1.setViewportView(panelBotones);

    jPanel1.setBackground(new java.awt.Color(255, 255, 255));
    jPanel1.setPreferredSize(new java.awt.Dimension(739, 534));
    jPanel1.setLayout(new java.awt.BorderLayout());

    jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
    jScrollPane2.setForeground(new java.awt.Color(0, 0, 0));
    jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

    jTable1.setBackground(new java.awt.Color(255, 255, 255));
    jTable1.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
      },
      new String[]{"A","B","C","D"}
    ));
    jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
    jTable1.setDefaultEditor(Object.class, null);
    jTable1.setRowHeight(35);
    jScrollPane2.setViewportView(jTable1);

    jPanel1.add(jScrollPane2, java.awt.BorderLayout.CENTER);

    jPanel2.setBackground(new java.awt.Color(204, 204, 255));
    jPanel2.setLayout(new java.awt.GridLayout(1, 0));
    jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

    jPanel3.setBackground(new java.awt.Color(255, 204, 204));
    jPanel3.setForeground(new java.awt.Color(204, 255, 204));

    jPanel4.setLayout(new java.awt.GridLayout(1, 0, 4, 0));

    btnAgregar.setBackground(new java.awt.Color(153, 153, 255));
    btnAgregar.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
    btnAgregar.setText("Agregar +");
    btnAgregar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnAgregarActionPerformed(evt);
      }
    });
    jPanel4.add(btnAgregar);

    btnConsultar.setBackground(new java.awt.Color(102, 102, 255));
    btnConsultar.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
    btnConsultar.setText("Consultar ?");
    btnConsultar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnConsultarActionPerformed(evt);
      }
    });
    jPanel4.add(btnConsultar);

    btnModificar.setBackground(new java.awt.Color(51, 51, 255));
    btnModificar.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
    btnModificar.setText("Modificar !");
    btnModificar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnModificarActionPerformed(evt);
      }
    });
    jPanel4.add(btnModificar);

    btnEliminar.setBackground(new java.awt.Color(255, 0, 0));
    btnEliminar.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
    btnEliminar.setText("Eliminar -");
    btnEliminar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnEliminarActionPerformed(evt);
      }
    });
    jPanel4.add(btnEliminar);

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
        .addContainerGap())
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
        .addContainerGap())
    );

    jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

    jMenu1.setText("File");

    jMenuItem2.setText("Cerrar carpeta");
    jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem2ActionPerformed(evt);
      }
    });
    jMenu1.add(jMenuItem2);

    jMenuItem3.setText("Abrir carpeta");
    jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem3ActionPerformed(evt);
      }
    });
    jMenu1.add(jMenuItem3);
    jMenu1.add(jSeparator2);

    menuImportar.setText("Importar por CSV de comas");
    menuImportar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuImportarActionPerformed(evt);
      }
    });
    jMenu1.add(menuImportar);

    menuExportar.setText("Exportar en CSV de comas");
    menuExportar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuExportarActionPerformed(evt);
      }
    });
    jMenu1.add(menuExportar);

    jMenuBar1.add(jMenu1);

    jMenu2.setText("Actualizar");

    jMenuItem1.setText("refrescar");
    jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem1ActionPerformed(evt);
      }
    });
    jMenu2.add(jMenuItem1);

    jMenuItem5.setText("cerrar todo");
    jMenu2.add(jMenuItem5);
    jMenu2.add(jSeparator1);

    jMenuBar1.add(jMenu2);

    jMenu3.setText("Mas");

    jMenuItem4.setText("Visualizar mejor el registro");
    jMenu3.add(jMenuItem4);

    jMenuBar1.add(jMenu3);

    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane1)
      .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

  }//GEN-LAST:event_jMenuItem1ActionPerformed

  private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed


  }//GEN-LAST:event_btnModificarActionPerformed

  private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

  }//GEN-LAST:event_btnAgregarActionPerformed

  private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed

  }//GEN-LAST:event_btnConsultarActionPerformed

  private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

  }//GEN-LAST:event_btnEliminarActionPerformed

  private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

  }//GEN-LAST:event_jMenuItem2ActionPerformed

  private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

  }//GEN-LAST:event_jMenuItem3ActionPerformed

  private void menuExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExportarActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_menuExportarActionPerformed

  private void menuImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuImportarActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_menuImportarActionPerformed

  public static void main(String[] args) {
    VentanaRegistro v = new VentanaRegistro();
    v.setVisible(true);
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnAgregar;
  private javax.swing.JButton btnConsultar;
  private javax.swing.JButton btnEliminar;
  private javax.swing.JButton btnModificar;
  private javax.swing.JMenu jMenu1;
  private javax.swing.JMenu jMenu2;
  private javax.swing.JMenu jMenu3;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JMenuItem jMenuItem1;
  private javax.swing.JMenuItem jMenuItem2;
  private javax.swing.JMenuItem jMenuItem3;
  private javax.swing.JMenuItem jMenuItem4;
  private javax.swing.JMenuItem jMenuItem5;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JPanel jPanel4;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JPopupMenu.Separator jSeparator1;
  private javax.swing.JPopupMenu.Separator jSeparator2;
  private javax.swing.JTable jTable1;
  private javax.swing.JMenuItem menuExportar;
  private javax.swing.JMenuItem menuImportar;
  private javax.swing.JPanel panelBotones;
  // End of variables declaration//GEN-END:variables
}
