/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author Danniela Renderos <00087717@uca.edu.sv>
 */
public class G1 extends javax.swing.JFrame {

    /**
     * Creates new form G1
     */
    public G1() {
        initComponents();
        setSize(1001, 619);
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/mmmlll.gif"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(690, 70, 190, 160);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/in_space_vortex_by_kpekep-d9eay0l.gif"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, -40, 1000, 690);

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new G1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
