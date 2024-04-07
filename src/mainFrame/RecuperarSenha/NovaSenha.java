package mainFrame.RecuperarSenha;

import java.sql.Connection;
import java.sql.SQLException;
import dataBaseManage.UserManage;
import conexaoBancos.ConexaoBancoDeDados;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class NovaSenha extends javax.swing.JFrame {
    
    private String nome;
    private String email;
    
    public NovaSenha() {
        initComponents();
    }

    public NovaSenha(String nome, String email) {
        this.nome = nome;
        this.email = email;
        initComponents();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        senhaDoisLBL = new javax.swing.JLabel();
        AlterarBTTN = new javax.swing.JButton();
        CancelarBTTN = new javax.swing.JButton();
        senhaUmLBL = new javax.swing.JLabel();
        SenhaDoisTF = new javax.swing.JPasswordField();
        SenhaUmTF = new javax.swing.JPasswordField();
        IMAGEM = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        senhaDoisLBL.setFont(new java.awt.Font("Lucida Calligraphy", 1, 18)); // NOI18N
        senhaDoisLBL.setForeground(new java.awt.Color(0, 0, 0));
        senhaDoisLBL.setText("Repita a Senha");
        getContentPane().add(senhaDoisLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 170, -1));

        AlterarBTTN.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        AlterarBTTN.setText("ALTERAR");
        AlterarBTTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarBTTNActionPerformed(evt);
            }
        });
        getContentPane().add(AlterarBTTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 130, -1));

        CancelarBTTN.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        CancelarBTTN.setText("CANCELAR");
        CancelarBTTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarBTTNActionPerformed(evt);
            }
        });
        getContentPane().add(CancelarBTTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 140, -1));

        senhaUmLBL.setFont(new java.awt.Font("Lucida Calligraphy", 1, 18)); // NOI18N
        senhaUmLBL.setForeground(new java.awt.Color(0, 0, 0));
        senhaUmLBL.setText("Nova Senha");
        getContentPane().add(senhaUmLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 170, -1));
        getContentPane().add(SenhaDoisTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 210, 30));
        getContentPane().add(SenhaUmTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 210, 30));

        IMAGEM.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gamer\\Downloads\\CadastroBG.png")); // NOI18N
        getContentPane().add(IMAGEM, new org.netbeans.lib.awtextra.AbsoluteConstraints(-180, 0, 740, 388));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AlterarBTTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarBTTNActionPerformed
        try {
            //resgatando dados inseridos pelo usuário 
            Connection cn = new ConexaoBancoDeDados().getConnection();
            char[] passwordUm = SenhaUmTF.getPassword();
            char[] passwordDois = SenhaDoisTF.getPassword();
            String senhaUm = String.valueOf(passwordUm);
            String senhaDois = String.valueOf(passwordDois);
            //verificando se senhas são iguais
            if(senhaUm.equals(senhaDois)){
                UserManage um = new UserManage(cn);
                um.recuperarSenha(nome, email, senhaUm);
                setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Senhas diferentes!! Tente novamente.", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
                SenhaUmTF.setText("");
                SenhaDoisTF.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(NovaSenha.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AlterarBTTNActionPerformed

    private void CancelarBTTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarBTTNActionPerformed
        setVisible(false);
    }//GEN-LAST:event_CancelarBTTNActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NovaSenha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AlterarBTTN;
    private javax.swing.JButton CancelarBTTN;
    private javax.swing.JLabel IMAGEM;
    private javax.swing.JPasswordField SenhaDoisTF;
    private javax.swing.JPasswordField SenhaUmTF;
    private javax.swing.JLabel senhaDoisLBL;
    private javax.swing.JLabel senhaUmLBL;
    // End of variables declaration//GEN-END:variables
}
