/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;
import MySQL.Conexion;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Luis Angel
 */
public class Reporte extends javax.swing.JFrame {

     private static DefaultTableModel modelo;
    private TableRowSorter trsFiltro;
    
    int row=0;
    int r=0;

    //para exportar
    private JFileChooser FileChooser = new JFileChooser();
    private Vector columna = new Vector();
    private Vector filas = new Vector();
    private static int tabla_ancho = 0;
    private static int tabla_alto = 0;
    /**
     * Creates new form Reporte
     */
    public Reporte() {
        initComponents();
         modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Nombre_Estadio");
        //modelo.addColumn("Año escolar");
        this.jTable1.setModel(modelo);
        CargarBD();
        
    }
    
    private void configuroTabla() {
        jTable1.getAutoResizeMode();
        jTable1.tableChanged(null);
       jTable1.setEnabled(true);
        jTable1.setRowHeight(25);
        jTable1.setRowMargin(4);
        tabla_ancho = modelo.getColumnCount() * 150;
        tabla_alto = modelo.getRowCount() * 25;
        jTable1.setPreferredSize(new Dimension(tabla_ancho, tabla_alto));}

       //para  ver los valores no borrados
     public void CargarBD()
    {
    try
        {
            Connection conexion;
            conexion=Conexion.obtener();
            PreparedStatement consulta = conexion.prepareStatement("SELECT id, nombre_estadio FROM estadios" );
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next())
            {
                String datos[] = new String[4];
                String dato=resultado.getString("nombre_estadio");
                String id=resultado.getString("id");
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

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        tot = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        nom2 = new javax.swing.JTextField();
        nom = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Consulta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Agregar");
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
                .addGap(89, 89, 89)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tot, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nom2, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                            .addComponent(nom))))
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tot, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2))
                            .addComponent(jButton1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(nom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(118, Short.MAX_VALUE))
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
        
        try
        {
            Connection conexion;
            conexion=Conexion.obtener();
            PreparedStatement consulta = conexion.prepareStatement("SELECT id, nombre_estadio FROM estadios" );
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next())
            {
                String datos[] = new String[4];
                String dato=resultado.getString("nombre_estadio");
                String id=resultado.getString("id");
                System.out.println(id+"-"+dato);  
                
                datos[0] = id;
                datos[1] = dato;
                //datos[2] = anio.getText();
                modelo.addRow(datos);
            }
            conexion.close();
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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
         //limpiar la jtable
        DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
        int a = jTable1.getRowCount()-1;
        for (int i = a; i >= 0; i--) {           
        tb.removeRow(tb.getRowCount()-1);
        }
             
        
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
            
                System.out.println(row);
                ps = conexion.prepareStatement("Delete from estadios where id="+r);
                ps.execute();
                //System.out.print(ps);
                CargarBD();//cargar automaticamente las consultas en la tabla
               
                
            } catch (SQLException ex) {
                Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
            }
            
             
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        //limpiar la jtable
        DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
        int a = jTable1.getRowCount()-1;
        for (int i = a; i >= 0; i--) {           
        tb.removeRow(tb.getRowCount()-1);
        }
             
        int n1=0;
         String nombre="";
         String ido="";
        nombre=nom.getText();
        ido=nom2.getText();
        
        n1=Integer.parseInt(ido);
        
        //eliminar un bato de base de batos
        Connection conexion;
            try {
                conexion=Conexion.obtener();
                PreparedStatement ps = null;
              //  String id=jTextField1.getText;
                 //  String idf="2";//sirve para agarrar el valor el valor de id
               // System.out.println(id);
                ps = conexion.prepareStatement("insert into estadios values("+n1+",'"+nombre+"')");
               
                //ps = conexion.prepareStatement("Delete from estadios where id="+idf);
                ps.execute();
                //System.out.print(ps);
                CargarBD();//cargar automaticamente las consultas en la tabla
                
            } catch (SQLException ex) {
                Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            nom2.setText("");//limpiar
             nom.setText("");//limpiar
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int column = jTable1.getColumnModel().getColumnIndexAtX(evt.getX());//donde nos da la posion x
         row = evt.getY()/jTable1.getRowHeight();//donde nos da la posion y
         r=row+1;
        //este dentro del rango de la tabla
        if(row < jTable1.getRowCount() && row >=0 && column < jTable1.getColumnCount() && column >= 0){
            Object value = jTable1.getValueAt(row, column);
           // if(value instanceof JButton){//si esto es un boton
               // ((JButton)value).doClick();//doy click en botton
             //   JButton boton = (JButton) value;//debolvemos en doton q echo click
                
                //if(boton.getName().equals("M")){
                  System.out.println(column+" "+row+" "+r);        
                //}
                
                //if(boton.getName().equals("I")){
                    //System.out.println(column+" "+row);
                //}
            //}
        }
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(Reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reporte().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField nom2;
    private javax.swing.JLabel tot;
    // End of variables declaration//GEN-END:variables
}
