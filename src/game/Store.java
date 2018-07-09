/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;


import Naves.Nave;
import dao.UsuariosDao;
import javax.swing.JOptionPane;
import juegocolisiones.JuegoColision;
import modelo.Usuarios;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Danniela Renderos <00087717@uca.edu.sv>
 */
public class Store extends javax.swing.JFrame {

    Usuarios jugador;
    int naveSeleccionada=0;

    /**
     * Creates new form MenuGeneral
     */
    public Store(Usuarios u) {
        this.jugador = u;
        initComponents();
        setSize(1000, 700);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombre = new javax.swing.JLabel();
        n3 = new javax.swing.JLabel();
        n2 = new javax.swing.JLabel();
        n1 = new javax.swing.JLabel();
        ComprarVenture1 = new javax.swing.JToggleButton();
        ComprarImperial3 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        ComprarMajesty2 = new javax.swing.JToggleButton();
        ImperialPrecio = new javax.swing.JLabel();
        textoUsuario = new javax.swing.JLabel();
        MajestyPrecio = new javax.swing.JLabel();
        VenturePrecio = new javax.swing.JLabel();
        textoLeks = new javax.swing.JLabel();
        fonfo = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(null);

        nombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/SPACE.png"))); // NOI18N
        nombre.setText("jLabel1");
        getContentPane().add(nombre);
        nombre.setBounds(80, 50, 810, 120);

        n3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/3.gif"))); // NOI18N
        getContentPane().add(n3);
        n3.setBounds(640, 240, 330, 200);

        n2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/1.gif"))); // NOI18N
        getContentPane().add(n2);
        n2.setBounds(350, 250, 250, 190);

        n1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/134.gif"))); // NOI18N
        n1.setText("jLabel1");
        getContentPane().add(n1);
        n1.setBounds(70, 230, 260, 200);

        ComprarVenture1.setText("VENTURE");
        ComprarVenture1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComprarVenture1ActionPerformed(evt);
            }
        });
        getContentPane().add(ComprarVenture1);
        ComprarVenture1.setBounds(150, 470, 100, 30);

        ComprarImperial3.setText("IMPERIAL");
        ComprarImperial3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComprarImperial3ActionPerformed(evt);
            }
        });
        getContentPane().add(ComprarImperial3);
        ComprarImperial3.setBounds(730, 470, 100, 30);

        jToggleButton3.setText("CONTINUAR");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton3);
        jToggleButton3.setBounds(800, 590, 130, 23);

        ComprarMajesty2.setText("MAJESTY");
        ComprarMajesty2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComprarMajesty2ActionPerformed(evt);
            }
        });
        getContentPane().add(ComprarMajesty2);
        ComprarMajesty2.setBounds(420, 470, 100, 30);

        ImperialPrecio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ImperialPrecio.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(ImperialPrecio);
        ImperialPrecio.setBounds(750, 520, 70, 30);
        ImperialPrecio.setText("30000"+" L");

        textoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(textoUsuario);
        textoUsuario.setBounds(560, 570, 180, 30);
        textoUsuario.setText("Astronauta: "+jugador.getUsuario());

        MajestyPrecio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        MajestyPrecio.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(MajestyPrecio);
        MajestyPrecio.setBounds(440, 510, 70, 30);
        MajestyPrecio.setText("10000"+" L");

        VenturePrecio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        VenturePrecio.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(VenturePrecio);
        VenturePrecio.setBounds(170, 510, 70, 30);
        VenturePrecio.setText("0"+" L");

        textoLeks.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        textoLeks.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(textoLeks);
        textoLeks.setBounds(310, 560, 180, 30);
        textoLeks.setText("Lek disponibles: "+jugador.getLeks());

        fonfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/kkkk.gif"))); // NOI18N
        getContentPane().add(fonfo);
        fonfo.setBounds(0, -10, 1010, 810);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        if (naveSeleccionada == 0) {
            JOptionPane.showMessageDialog(null, "No puedes ir al espacio sin nave!");
            return;
        }
        try {
            final int WIDHT = 900, HEIGHT = 600;
            setVisible(false);
            AppGameContainer gc = new AppGameContainer(new JuegoColision(naveSeleccionada, jugador));
            gc.setDisplayMode(WIDHT, HEIGHT, false);
            gc.setVSync(true);
            gc.start();
        } catch (SlickException err) {
            err.printStackTrace();
        }
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void ComprarVenture1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComprarVenture1ActionPerformed

        if (jugador.getLeks() >= 0) {
            UsuariosDao dao = new UsuariosDao();
            dao.updateLeks(0, jugador);
            jugador=dao.read(jugador.getUsuario());
            JOptionPane.showMessageDialog(null, "Nave comprada con exito");
            textoLeks.setText("Lek disponibles: "+jugador.getLeks());
            naveSeleccionada = 1;
        } else {
            JOptionPane.showMessageDialog(null, "No tienes suficientes leks");
        }
    }//GEN-LAST:event_ComprarVenture1ActionPerformed

    private void ComprarMajesty2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComprarMajesty2ActionPerformed

        if (jugador.getLeks() >= 10000) {
            UsuariosDao dao = new UsuariosDao();
            dao.updateLeks(10000, jugador);
            jugador=dao.read(jugador.getUsuario());
            JOptionPane.showMessageDialog(null, "Nave comprada con exito");
            textoLeks.setText("Lek disponibles: "+jugador.getLeks());
            naveSeleccionada = 2;
        } else {
            JOptionPane.showMessageDialog(null, "No tienes suficientes leks");
        }
    }//GEN-LAST:event_ComprarMajesty2ActionPerformed

    private void ComprarImperial3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComprarImperial3ActionPerformed

        if (jugador.getLeks() >= 30000) {
            UsuariosDao dao = new UsuariosDao();
            dao.updateLeks(30000, jugador);
            jugador=dao.read(jugador.getUsuario());
            JOptionPane.showMessageDialog(null, "Nave comprada con exito");
            textoLeks.setText("Lek disponibles: "+jugador.getLeks());
            naveSeleccionada = 3;
        } else {
            JOptionPane.showMessageDialog(null, "No tienes suficientes leks");
        }
    }//GEN-LAST:event_ComprarImperial3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Store.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Store.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Store.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Store.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
////                new Store().setVisible(true);
//
//            }
//        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton ComprarImperial3;
    private javax.swing.JToggleButton ComprarMajesty2;
    private javax.swing.JToggleButton ComprarVenture1;
    private javax.swing.JLabel ImperialPrecio;
    private javax.swing.JLabel MajestyPrecio;
    private javax.swing.JLabel VenturePrecio;
    private javax.swing.JLabel fonfo;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JLabel n1;
    private javax.swing.JLabel n2;
    private javax.swing.JLabel n3;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel textoLeks;
    private javax.swing.JLabel textoUsuario;
    // End of variables declaration//GEN-END:variables
}
