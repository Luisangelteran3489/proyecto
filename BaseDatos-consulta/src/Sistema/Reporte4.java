/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import MySQL.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Angel
 */
public class Reporte4 extends javax.swing.JFrame {
      private static DefaultTableModel modelo;
    private TableRowSorter trsFiltro;
    
    int row=0;
    int r=0;
    int column=0;
    String [][] arreglo=new String[100][100];
    String valor="";
    int i=0,j=0;
        

    //para exportar
    private JFileChooser FileChooser = new JFileChooser();
    private Vector columna = new Vector();
    private Vector filas = new Vector();
    private static int tabla_ancho = 0;
    private static int tabla_alto = 0;
    /**
     * Creates new form Reporte4
     */
    public Reporte4() {
        initComponents();
         modelo = new DefaultTableModel();
        modelo.addColumn("id_partidos");
        modelo.addColumn("equipo_local");
        modelo.addColumn("equipo_visitante");
        modelo.addColumn("estadio");
        modelo.addColumn("fecha");
        modelo.addColumn("marcador_local");
        modelo.addColumn("marcador_visitante");
       // jPanel2.setVisible(false);
       // jPanel3.setVisible(false);
        //jPanel4.setVisible(false);
        //modelo.addColumn("Año escolar");
        this.jTable1.setModel(modelo);
        CargarBD();
    }
    
    public void CargarBD()
    {
    try
        {
            Connection conexion;
            conexion=Conexion.obtener();
            PreparedStatement consulta = conexion.prepareStatement("SELECT id_partidos,equipo_local,equipo_visitante,estadio,fecha,marcador_local,marcador_visitante FROM partidos" );
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next())
            {
                String datos[] = new String[7];
                String id=resultado.getString("id_partidos");
                String id1=resultado.getString("equipo_local");
                String id2=resultado.getString("equipo_visitante");
                String id3=resultado.getString("estadio");
                String id4=resultado.getString("fecha");
                String id5=resultado.getString("marcador_local");
                String id6=resultado.getString("marcador_visitante");
               // System.out.println(id+"-"+dato);
               // jTextField1.setText(id);
                //jTextField2.setText(dato);
                
                
                datos[0] = id;
                datos[1] = id1;
                datos[2] = id2;
                datos[3] = id3;
                datos[4] = id4;
                datos[5] = id5;
                datos[6] = id6;
               // datos[2] = anio.getText();
                modelo.addRow(datos);
                
            }
        }
        catch(SQLException ex)
        {
            try {
                throw new SQLException(ex);
            } catch (SQLException ex1) {
                Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        }
     
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nom = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setEnabled(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Equipo Local ", "Equipo Visitante", "Estadio", "Fecha", "Marcador Local", "Marcador Visitante"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Consulta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Modificar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setText("Partidos");

        jButton5.setText("jButton5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(14, 14, 14)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addGap(98, 98, 98)
                        .addComponent(jButton5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(jLabel1)))
                .addContainerGap(291, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4))
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addGap(41, 41, 41))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 22, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        //limpiar la jtable
        DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
        int a = jTable1.getRowCount()-1;
        for (int i = a; i >= 0; i--) {           
        tb.removeRow(tb.getRowCount()-1);
        }
             
         System.out.println(arreglo[row][column]); 
         String nombre="";
        nombre=nom.getText();

        //eliminar un bato de base de batos
        Connection conexion;
            try {
                conexion=Conexion.obtener();
                PreparedStatement ps = null;
              //  String id=jTextField1.getText;
                   String idf="2";//sirve para agarrar el valor el valor de id
               // System.out.println(id);
            //    ps = conexion.prepareStatement("insert into estadios(nombre_estadio) values('"+nombre+"')");
            //int row = 0;
            
               // System.out.println(r);
                ps = conexion.prepareStatement("Delete from partidos where equipo_partidos="+arreglo[row][column]);
              //  ps = conexion.prepareStatement("Delete from estadios where nombre_estadio='"+arreglo[row][column]+"'");
                 
                ps.execute();
                //System.out.print(ps);
                CargarBD();//cargar automaticamente las consultas en la tabla
               
                
            } catch (SQLException ex) {
                Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         //limpiar la jtable
        DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
        int a = jTable1.getRowCount()-1;
        for (int i = a; i >= 0; i--) {           
        tb.removeRow(tb.getRowCount()-1);
        }
             
      //  int n1=0;
         String nombre="";
        // String ido="";
        nombre=nom.getText();
        // String nombre1="";
        
        //nombre1=nom1.getText();
        // String nombre2="";
        // String ido="";
        //nombre2=nom2.getText();
        //ido=nom2.getText();
        
       // n1=Integer.parseInt(ido);
        
        //eliminar un bato de base de batos
        Connection conexion;
            try {
                conexion=Conexion.obtener();
                PreparedStatement ps = null;
              //  String id=jTextField1.getText;
                 //  String idf="2";//sirve para agarrar el valor el valor de id
               // System.out.println(id);
                ps = conexion.prepareStatement("insert into partidos values("+nombre+")");
               
                //ps = conexion.prepareStatement("Delete from estadios where id="+idf);
                ps.execute();
                //System.out.print(ps);
                CargarBD();//cargar automaticamente las consultas en la tabla
                
            } catch (SQLException ex) {
                Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
         column = jTable1.getColumnModel().getColumnIndexAtX(evt.getX());//donde nos da la posion x
         row = evt.getY()/jTable1.getRowHeight();//donde nos da la posion y
         r=row+1;
         
        //este dentro del rango de la tabla
        if(row < jTable1.getRowCount() && row >=0 && column < jTable1.getColumnCount() && column >= 0){
            Object value = jTable1.getValueAt(row, column);
         
             for ( i = 0; i < jTable1.getRowCount(); i++) {
                  for ( j = 0; j < jTable1.getColumnCount(); j++) {
                       valor=String.valueOf(String.valueOf(jTable1.getValueAt(i,j)));//sacar el valor de la tabla
                      arreglo[i][j]=valor;//almacenar el valor en una arreglo
	             // System.out.print(arreglo[i][j]+"-");
                  }
                //  System.out.println();
             }
//                  System.out.println(column+" "+row+" "+r);        
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         //limpiar la jtable
        DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
        int a = jTable1.getRowCount()-1;
        for (int i = a; i >= 0; i--) {           
        tb.removeRow(tb.getRowCount()-1);
        }
             
        
         System.out.println(arreglo[row][column]); 
         String nombre_estadio="";
        nombre_estadio=nom.getText();

        //eliminar un bato de base de batos
        Connection conexion;
            try {
                conexion=Conexion.obtener();
                PreparedStatement ps = null;
              //  String id=jTextField1.getText;
                   String idf="2";//sirve para agarrar el valor el valor de id
               // System.out.println(id);
            //    ps = conexion.prepareStatement("insert into estadios(nombre_estadio) values('"+nombre+"')");
            //int row = 0;
            
               // System.out.println(r);
               // ps = conexion.prepareStatement("Delete from estadios where id="+arreglo[row][column]);
                //ps = conexion.prepareStatement("Delete from estadios where nombre_estadio='"+arreglo[row][column]+"'");
                 ps = conexion.prepareStatement("update partidos set fecha='"+nombre_estadio+"'\n" +
                 " where fecha='"+arreglo[row][column]+"'");
                ps.execute();
                //System.out.print(ps);
                CargarBD();//cargar automaticamente las consultas en la tabla
               
                
            } catch (SQLException ex) {
                Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reporte4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reporte4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reporte4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reporte4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reporte4().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nom;
    // End of variables declaration//GEN-END:variables
}
