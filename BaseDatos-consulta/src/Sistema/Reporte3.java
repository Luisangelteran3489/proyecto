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
public class Reporte3 extends javax.swing.JFrame {
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
     * Creates new form Reporte3
     */
    public Reporte3() {
        initComponents();
        modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Nombre_liga");
        //jPanel2.setVisible(false);
        //jPanel3.setVisible(false);
       // jPanel4.setVisible(false);
        //modelo.addColumn("Año escolar");
        this.jTable1.setModel(modelo);
        CargarBD();
    }
    
        //para  ver los valores no borrados
     public void CargarBD()
    {
    try
        {
            Connection conexion;
            conexion=Conexion.obtener();
            PreparedStatement consulta = conexion.prepareStatement("SELECT id_liga,nombre_liga FROM liga" );
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next())
            {
                String datos[] = new String[4];
                String dato=resultado.getString("nombre_liga");
                String id=resultado.getString("id_liga");
               // System.out.println(id+"-"+dato);
               // jTextField1.setText(id);
                //jTextField2.setText(dato);
                
                datos[0] = id;
                datos[1] = dato;
              //  datos[2] = id2;
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        nom = new javax.swing.JTextField();
        nom1 = new javax.swing.JTextField();
        nom2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Liga");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id Liga", "Nombre Liga"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Eliminar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
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

        jButton3.setText("Modificar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nom, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(nom1)
                            .addComponent(nom2))))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nom1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nom2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(184, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         //limpiar la jtable
        DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
        int a = jTable1.getRowCount()-1;
        for (int i = a; i >= 0; i--) {           
        tb.removeRow(tb.getRowCount()-1);
        }
             
         System.out.println(arreglo[row][column]); 
        // String nombre="";
        //nombre=nom.getText();

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
                ps = conexion.prepareStatement("Delete from liga where nombre_liga='"+arreglo[row][column]+"'");
              //  ps = conexion.prepareStatement("Delete from estadios where nombre_estadio='"+arreglo[row][column]+"'");
                 
                ps.execute();
                //System.out.print(ps);
                CargarBD();//cargar automaticamente las consultas en la tabla
               
                
            } catch (SQLException ex) {
                Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
         String nombre1="";
        
        nombre1=nom1.getText();
         String nombre2="";
        // String ido="";
        nombre2=nom2.getText();
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
                ps = conexion.prepareStatement("insert into liga values("+nombre+",'"+nombre1+"')");
               
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

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
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
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        //limpiar la jtable
        DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
        int a = jTable1.getRowCount()-1;
        for (int i = a; i >= 0; i--) {           
        tb.removeRow(tb.getRowCount()-1);
        }
             
        
         System.out.println(arreglo[row][column]); 
         String nombre_estadio="";
        nombre_estadio=nom2.getText();

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
                 ps = conexion.prepareStatement("update liga set nombre_liga='"+nombre_estadio+"'\n" +
                 " where nombre_liga='"+arreglo[row][column]+"'");
                ps.execute();
                //System.out.print(ps);
                CargarBD();//cargar automaticamente las consultas en la tabla
               
                
            } catch (SQLException ex) {
                Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Reporte3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reporte3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reporte3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reporte3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reporte3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField nom1;
    private javax.swing.JTextField nom2;
    // End of variables declaration//GEN-END:variables
}
