package mainFrame;

import conexaoBancos.ConexaoBancoDeDados;
import dataBaseManage.UserManage;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainFrame.RecuperarSenha.SenhaRec;

public class LoginUsuario extends javax.swing.JFrame{
    
    public LoginUsuario() {
        initComponents();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        senhaLBL = new javax.swing.JLabel();
        userLBL = new javax.swing.JLabel();
        UserTF = new javax.swing.JTextField();
        recuperarSenhaBTTN = new javax.swing.JButton();
        LoginBttn = new javax.swing.JButton();
        SenhaTF = new javax.swing.JPasswordField();
        CadastroBttn = new javax.swing.JButton();
        avisoLBL = new javax.swing.JLabel();
        Imagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        senhaLBL.setBackground(new java.awt.Color(0, 0, 0));
        senhaLBL.setFont(new java.awt.Font("Lucida Calligraphy", 1, 18)); // NOI18N
        senhaLBL.setForeground(new java.awt.Color(0, 0, 0));
        senhaLBL.setText("Senha");
        getContentPane().add(senhaLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, -1, -1));

        userLBL.setBackground(new java.awt.Color(0, 0, 0));
        userLBL.setFont(new java.awt.Font("Lucida Calligraphy", 1, 18)); // NOI18N
        userLBL.setForeground(new java.awt.Color(0, 0, 0));
        userLBL.setText("Usuário");
        getContentPane().add(userLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, -1, -1));

        UserTF.setBackground(new java.awt.Color(255, 255, 255));
        UserTF.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        getContentPane().add(UserTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 120, -1));

        recuperarSenhaBTTN.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        recuperarSenhaBTTN.setText("Esqueci a senha");
        recuperarSenhaBTTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recuperarSenhaBTTNActionPerformed(evt);
            }
        });
        getContentPane().add(recuperarSenhaBTTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 120, -1));

        LoginBttn.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        LoginBttn.setText("Entrar");
        LoginBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBttnActionPerformed(evt);
            }
        });
        getContentPane().add(LoginBttn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 110, -1));

        SenhaTF.setBackground(new java.awt.Color(255, 255, 255));
        SenhaTF.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        getContentPane().add(SenhaTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 120, -1));

        CadastroBttn.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        CadastroBttn.setText("Cadastre-se");
        CadastroBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastroBttnActionPerformed(evt);
            }
        });
        getContentPane().add(CadastroBttn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 110, -1));

        avisoLBL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        avisoLBL.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(avisoLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 130, 30));

        Imagem.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gamer\\Downloads\\Opera Instantâneo_2024-03-22_113429_www.freepik.com.png")); // NOI18N
        Imagem.setText("jLabel1");
        getContentPane().add(Imagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //botão para recuperar a senha
    private void recuperarSenhaBTTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recuperarSenhaBTTNActionPerformed
            SenhaRec sr = new SenhaRec();
            sr.setVisible(true);
    }//GEN-LAST:event_recuperarSenhaBTTNActionPerformed
    //botão de login
    private void LoginBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBttnActionPerformed
        try {
            //acessando conta
            Connection conexao = new ConexaoBancoDeDados().getConnection();
            UserManage um =new UserManage(conexao);
            char[] ps = SenhaTF.getPassword();
            String convertedPassword = String.valueOf(ps);
            um.login(UserTF.getText(), convertedPassword);
            if(um.var() == true){
                setVisible(false);
            }
            UserTF.setText("");
            SenhaTF.setText("");
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_LoginBttnActionPerformed
    //botão de cadastrar
    private void CadastroBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastroBttnActionPerformed
        CadastroFrame cf = new CadastroFrame();
        cf.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_CadastroBttnActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginUsuario().setVisible(true);
            }
        });
    }
    public void setAviso(String text){
        avisoLBL.setText("Usuário inválido/Não existe!");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CadastroBttn;
    private javax.swing.JLabel Imagem;
    private javax.swing.JButton LoginBttn;
    private javax.swing.JPasswordField SenhaTF;
    private javax.swing.JTextField UserTF;
    private javax.swing.JLabel avisoLBL;
    private javax.swing.JButton recuperarSenhaBTTN;
    private javax.swing.JLabel senhaLBL;
    private javax.swing.JLabel userLBL;
    // End of variables declaration//GEN-END:variables
}
