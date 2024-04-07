package mainFrame.RecuperarSenha;

import conexaoBancos.ConexaoBancoDeDados;
import dataBaseManage.UserManage;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

        
public class SenhaRec extends javax.swing.JFrame {

    public SenhaRec() {
        initComponents();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        emailLBL = new javax.swing.JLabel();
        nomeCTF = new javax.swing.JTextField();
        emailTF = new javax.swing.JTextField();
        RecuperarBttn = new javax.swing.JButton();
        CancelarBTTN = new javax.swing.JButton();
        nomeLBL = new javax.swing.JLabel();
        IMAGEM = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        emailLBL.setFont(new java.awt.Font("Lucida Calligraphy", 1, 18)); // NOI18N
        emailLBL.setForeground(new java.awt.Color(0, 0, 0));
        emailLBL.setText("E-mail");
        getContentPane().add(emailLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 80, -1));

        nomeCTF.setBackground(new java.awt.Color(255, 255, 255));
        nomeCTF.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        nomeCTF.setForeground(new java.awt.Color(0, 0, 0));
        nomeCTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeCTFActionPerformed(evt);
            }
        });
        getContentPane().add(nomeCTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 230, -1));

        emailTF.setBackground(new java.awt.Color(255, 255, 255));
        emailTF.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        emailTF.setForeground(new java.awt.Color(0, 0, 0));
        emailTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTFActionPerformed(evt);
            }
        });
        getContentPane().add(emailTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 230, -1));

        RecuperarBttn.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        RecuperarBttn.setText("RECUPERAR");
        RecuperarBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecuperarBttnActionPerformed(evt);
            }
        });
        getContentPane().add(RecuperarBttn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, -1, -1));

        CancelarBTTN.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        CancelarBTTN.setText("CANCELAR");
        CancelarBTTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarBTTNActionPerformed(evt);
            }
        });
        getContentPane().add(CancelarBTTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 140, 30));

        nomeLBL.setFont(new java.awt.Font("Lucida Calligraphy", 1, 18)); // NOI18N
        nomeLBL.setForeground(new java.awt.Color(0, 0, 0));
        nomeLBL.setText("Nome");
        getContentPane().add(nomeLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 70, -1));

        IMAGEM.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gamer\\Downloads\\CadastroBG.png")); // NOI18N
        getContentPane().add(IMAGEM, new org.netbeans.lib.awtextra.AbsoluteConstraints(-200, 0, 740, 388));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeCTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeCTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeCTFActionPerformed

    private void emailTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTFActionPerformed

    private void RecuperarBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecuperarBttnActionPerformed
        try {
            //resgatando dados inseridos do usuário
            Connection cn = new ConexaoBancoDeDados().getConnection();
            String nome = nomeCTF.getText();
            String email = emailTF.getText();
            UserManage um = new UserManage(cn);
            um.verificacaoRecuperarSenha(nome, email);
            nomeCTF.setText("");
            emailTF.setText("");
            setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(SenhaRec.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RecuperarBttnActionPerformed

    private void CancelarBTTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarBTTNActionPerformed
        setVisible(false);
    }//GEN-LAST:event_CancelarBTTNActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SenhaRec().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelarBTTN;
    private javax.swing.JLabel IMAGEM;
    private javax.swing.JButton RecuperarBttn;
    private javax.swing.JLabel emailLBL;
    private javax.swing.JTextField emailTF;
    private javax.swing.JTextField nomeCTF;
    private javax.swing.JLabel nomeLBL;
    // End of variables declaration//GEN-END:variables
}
