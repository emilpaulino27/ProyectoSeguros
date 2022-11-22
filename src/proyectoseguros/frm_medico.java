
package proyectoseguros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class frm_medico extends javax.swing.JFrame {

    DefaultTableModel Medico;

    public frm_medico() {
        initComponents();
        
        this.Medico = (DefaultTableModel) tabla_medicos.getModel();
        Mostrardatos("");
    }

    
        // Función para limpiar los textfield
    public void Limpiar() {
      
       try {
           txt_cedmed.setText(" ");
           txt_nombre.setText(" ");
           txt_apellido.setText(" ");
           txt_especialidad.setText(" ");
          
       }
       catch (Exception ex) {
             JOptionPane.showMessageDialog(null, "error "+ex);
       }   
   }
    
    
     public void RefrescarTabla(){
        //Funcion encargada de Refrescar la tabla utilizando Revalidate
        try {
        Medico.setColumnCount(0);
        Medico.setRowCount(0);
        tabla_medicos.revalidate();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "error "+ex);
        }
         }
        
    public final void Mostrardatos(String valor){
            //Funcion para llenar la jtable de Usuarios desde la BD
            
            MyConnection cc=new MyConnection();
            Connection cn=MyConnection.getConnection();
            RefrescarTabla();
            Medico.addColumn("ID médico");
            Medico.addColumn("Cédula");
            Medico.addColumn("Nombre");
            Medico.addColumn("Apellido");
            Medico.addColumn("Especialidad");


            this.tabla_medicos.setModel(Medico);
            String sql;
            if (valor.equals(""))
            {
            sql="SELECT * FROM medico";
            }
            else{
            sql="SELECT * FROM medico WHERE nombre='"+valor+"'";
            } 

            String []datos=new String [5];
            try{
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
            datos[0]=rs.getString(1);
            datos[1]=rs.getString(2);
            datos[2]=rs.getString(3);
            datos[3]=rs.getString(4);
            
            datos[4]=rs.getString(5);


            Medico.addRow(datos);
            }
            tabla_medicos.setModel(Medico);
            } catch(SQLException ex){
            Logger.getLogger(frm_medico.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
          }
            
        }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_blanco = new javax.swing.JPanel();
        lbl_medicos = new javax.swing.JLabel();
        lbl_cedula = new javax.swing.JLabel();
        txt_cedmed = new javax.swing.JTextField();
        lbl_nombre = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        lbl_apellido = new javax.swing.JLabel();
        txt_apellido = new javax.swing.JTextField();
        lbl_especialidad = new javax.swing.JLabel();
        txt_especialidad = new javax.swing.JTextField();
        btn_registrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_medicos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel_blanco.setBackground(new java.awt.Color(255, 255, 255));

        lbl_medicos.setFont(new java.awt.Font("Corbel", 0, 35)); // NOI18N
        lbl_medicos.setText("REGISTRO MÉDICOS");

        lbl_cedula.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        lbl_cedula.setText("Cédula médico");

        lbl_nombre.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        lbl_nombre.setText("Nombre");

        lbl_apellido.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        lbl_apellido.setText("Apellido");

        lbl_especialidad.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        lbl_especialidad.setText("Especialidad");

        btn_registrar.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        btn_registrar.setText("REGISTRAR");
        btn_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrarActionPerformed(evt);
            }
        });

        tabla_medicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_medicos);

        javax.swing.GroupLayout panel_blancoLayout = new javax.swing.GroupLayout(panel_blanco);
        panel_blanco.setLayout(panel_blancoLayout);
        panel_blancoLayout.setHorizontalGroup(
            panel_blancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_blancoLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(panel_blancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_blancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panel_blancoLayout.createSequentialGroup()
                            .addComponent(lbl_nombre)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel_blancoLayout.createSequentialGroup()
                            .addComponent(lbl_cedula)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txt_cedmed, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel_blancoLayout.createSequentialGroup()
                            .addComponent(lbl_apellido)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_blancoLayout.createSequentialGroup()
                            .addComponent(lbl_especialidad)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel_blancoLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(btn_registrar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
            .addGroup(panel_blancoLayout.createSequentialGroup()
                .addGap(297, 297, 297)
                .addComponent(lbl_medicos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_blancoLayout.setVerticalGroup(
            panel_blancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_blancoLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lbl_medicos)
                .addGroup(panel_blancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_blancoLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(panel_blancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_cedula)
                            .addComponent(txt_cedmed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel_blancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_nombre)
                            .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel_blancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_apellido)
                            .addComponent(txt_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel_blancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_especialidad)
                            .addComponent(txt_especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(btn_registrar))
                    .addGroup(panel_blancoLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_blanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_blanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrarActionPerformed
      
       String cedula = txt_cedmed.getText();
       String nombre = txt_nombre.getText();
       String apellido = txt_apellido.getText();
       String especialidad = txt_especialidad.getText();

        
        PreparedStatement ps;
        String query = "INSERT INTO `medico`(`cedula`,`nombre`,`apellido`,`especialidad`) VALUES (?,?,?,?)";
        
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            
            ps.setString(1, cedula);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, especialidad);
 
            
            
            if("".equals(txt_cedmed.getText()) || "".equals(txt_nombre.getText()) || "".equals(txt_apellido.getText()) || "".equals(txt_especialidad.getText())) {
                JOptionPane.showMessageDialog(null, "Uno de los campos vacíos es requerido");
            } else {
                
            
            if(ps.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Médico agregado");
               Limpiar(); 
               Mostrardatos("");
               
            }
          }
        } catch (SQLException ex) {
            Logger.getLogger(frm_medico.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            
    }   
        

    }//GEN-LAST:event_btn_registrarActionPerformed


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
            java.util.logging.Logger.getLogger(frm_medico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_medico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_medico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_medico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_medico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_registrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_apellido;
    private javax.swing.JLabel lbl_cedula;
    private javax.swing.JLabel lbl_especialidad;
    private javax.swing.JLabel lbl_medicos;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JPanel panel_blanco;
    private javax.swing.JTable tabla_medicos;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_cedmed;
    private javax.swing.JTextField txt_especialidad;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
