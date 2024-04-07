/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package usuarioADM;

/**
 *
 * @author Gamer
 */
public class InterfaceADM extends javax.swing.JFrame {

    private String user;
    
    public InterfaceADM() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        removerBTTN = new javax.swing.JButton();
        WelcomeLBL = new javax.swing.JLabel();
        agendarBTTN = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        IMG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        removerBTTN.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        removerBTTN.setText("REMOVER AGENDAMENTO");
        removerBTTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerBTTNActionPerformed(evt);
            }
        });
        getContentPane().add(removerBTTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 330, 50));

        WelcomeLBL.setFont(new java.awt.Font("Palatino Linotype", 2, 24)); // NOI18N
        WelcomeLBL.setForeground(new java.awt.Color(0, 0, 0));
        WelcomeLBL.setText("ADMINISTRAÇÃO");
        getContentPane().add(WelcomeLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 330, 50));

        agendarBTTN.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        agendarBTTN.setText("AGENDAR CLIENTE");
        agendarBTTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendarBTTNActionPerformed(evt);
            }
        });
        getContentPane().add(agendarBTTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 330, 50));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("--Consulta de horários feita via banco");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, -1, -1));

        IMG.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gamer\\Downloads\\UserWLPP.jpg")); // NOI18N
        getContentPane().add(IMG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //botão para remover agenda
    private void removerBTTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerBTTNActionPerformed
        RemoverAgendamento ra = new RemoverAgendamento();
        ra.setVisible(true);
    }//GEN-LAST:event_removerBTTNActionPerformed
    //botão para agendar horário
    private void agendarBTTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendarBTTNActionPerformed
        AgendarCliente ac = new AgendarCliente();
        ac.setVisible(true);
    }//GEN-LAST:event_agendarBTTNActionPerformed

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
            java.util.logging.Logger.getLogger(InterfaceADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceADM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IMG;
    private javax.swing.JLabel WelcomeLBL;
    private javax.swing.JButton agendarBTTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton removerBTTN;
    // End of variables declaration//GEN-END:variables
}
