/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import dao.UsuariosDao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Usuarios;

/**
 *
 * @author Cesar Rosales <00060917@uca.edu.sv>
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        setSize(700, 400);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        CajaUsuario = new javax.swing.JTextField();
        CajaPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BLogin = new javax.swing.JToggleButton();
        BRegistrar = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/SPACEmenu.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 0, 590, 130);

        CajaUsuario.setToolTipText("");
        getContentPane().add(CajaUsuario);
        CajaUsuario.setBounds(160, 150, 220, 30);

        CajaPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        CajaPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CajaPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(CajaPassword);
        CajaPassword.setBounds(160, 190, 220, 30);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PASSWORD");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(80, 190, 110, 40);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("USUARIO");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(80, 150, 110, 40);

        BLogin.setText("LOGIN");
        BLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLoginActionPerformed(evt);
            }
        });
        getContentPane().add(BLogin);
        BLogin.setBounds(200, 290, 120, 23);

        BRegistrar.setText("SIGN UP");
        BRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(BRegistrar);
        BRegistrar.setBounds(380, 290, 110, 23);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/orig.gif"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 710, 380);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLoginActionPerformed
       int flag=0;
        String usuario= CajaUsuario.getText();
        String password= CajaPassword.getText();
        UsuariosDao dao= new UsuariosDao();
        ArrayList<Usuarios> listaUsuarios= new ArrayList<Usuarios>();
        listaUsuarios= dao.readAll();
        for(Usuarios u: listaUsuarios){
            if(usuario.equals(u.getUsuario()) && password.equals(u.getPassword())){
                setVisible(false);

                new Menu(u).setVisible(true);
                flag=1;
            }
        }
        if(flag==0){
            JOptionPane.showMessageDialog(null, "Usuario no registrado o contraseña invalida");
        }
    }//GEN-LAST:event_BLoginActionPerformed

    private void BRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRegistrarActionPerformed
        int flag=0;
        String usuario= CajaUsuario.getText();
        String password= CajaPassword.getText();
        UsuariosDao dao= new UsuariosDao();
        ArrayList<Usuarios> listaUsuarios= new ArrayList<Usuarios>();
        listaUsuarios= dao.readAll();
        if(usuario.isEmpty() || password.isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese un usuario o contraseña valida");
            return;
        }
        for(Usuarios u: listaUsuarios){
            if(usuario.equals(u.getUsuario())){
                JOptionPane.showMessageDialog(null, "Usuario ya registrado, Ingrese un usuario valido");
                return;
            }
        }
        dao.create(new Usuarios(usuario, password));
        JOptionPane.showMessageDialog(null, "Usuario registrado con exito");

    }//GEN-LAST:event_BRegistrarActionPerformed

    private void CajaPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CajaPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CajaPasswordActionPerformed

    /**
     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
////        java.awt.EventQueue.invokeLater(new Runnable() {
////            public void run() {
////                new Login().setVisible(true);
////            }
////        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BLogin;
    private javax.swing.JToggleButton BRegistrar;
    private javax.swing.JPasswordField CajaPassword;
    private javax.swing.JTextField CajaUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}