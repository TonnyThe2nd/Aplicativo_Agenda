package mainFrame;

import conexaoBancos.ConexaoBancoDeDados;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import dataBaseManage.UserManage;

public class CadastroFrame extends javax.swing.JFrame {
    public CadastroFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        senhaDoisLBL = new javax.swing.JLabel();
        emailLBL = new javax.swing.JLabel();
        emailTF = new javax.swing.JTextField();
        CelularDoisTF = new javax.swing.JTextField();
        CelularUMTF = new javax.swing.JTextField();
        LogradouroTF = new javax.swing.JTextField();
        numTF = new javax.swing.JTextField();
        cepTF = new javax.swing.JTextField();
        SenhaUMTF = new javax.swing.JPasswordField();
        SenhaDoisTF = new javax.swing.JPasswordField();
        nomeCTF = new javax.swing.JTextField();
        logradouroLBL = new javax.swing.JLabel();
        celularDoisLBL = new javax.swing.JLabel();
        senhaUmLBL = new javax.swing.JLabel();
        numeroLBL = new javax.swing.JLabel();
        cepLBL = new javax.swing.JLabel();
        celularUmLBL = new javax.swing.JLabel();
        nomeLBL = new javax.swing.JLabel();
        CancelarBttn = new javax.swing.JButton();
        CadastrarBttn = new javax.swing.JButton();
        AvisosLBL = new javax.swing.JLabel();
        Imagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        senhaDoisLBL.setFont(new java.awt.Font("Lucida Calligraphy", 1, 18)); // NOI18N
        senhaDoisLBL.setForeground(new java.awt.Color(0, 0, 0));
        senhaDoisLBL.setText("Confirme a senha");
        getContentPane().add(senhaDoisLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, 180, -1));

        emailLBL.setFont(new java.awt.Font("Lucida Calligraphy", 1, 18)); // NOI18N
        emailLBL.setForeground(new java.awt.Color(0, 0, 0));
        emailLBL.setText("E-mail");
        getContentPane().add(emailLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 70, -1));

        emailTF.setBackground(new java.awt.Color(255, 255, 255));
        emailTF.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        emailTF.setForeground(new java.awt.Color(0, 0, 0));
        emailTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTFActionPerformed(evt);
            }
        });
        getContentPane().add(emailTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 230, -1));

        CelularDoisTF.setBackground(new java.awt.Color(255, 255, 255));
        CelularDoisTF.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        CelularDoisTF.setForeground(new java.awt.Color(0, 0, 0));
        CelularDoisTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CelularDoisTFActionPerformed(evt);
            }
        });
        getContentPane().add(CelularDoisTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, 140, -1));

        CelularUMTF.setBackground(new java.awt.Color(255, 255, 255));
        CelularUMTF.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        CelularUMTF.setForeground(new java.awt.Color(0, 0, 0));
        CelularUMTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CelularUMTFActionPerformed(evt);
            }
        });
        getContentPane().add(CelularUMTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 140, -1));

        LogradouroTF.setBackground(new java.awt.Color(255, 255, 255));
        LogradouroTF.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        LogradouroTF.setForeground(new java.awt.Color(0, 0, 0));
        LogradouroTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogradouroTFActionPerformed(evt);
            }
        });
        getContentPane().add(LogradouroTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, 220, -1));

        numTF.setBackground(new java.awt.Color(255, 255, 255));
        numTF.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        numTF.setForeground(new java.awt.Color(0, 0, 0));
        numTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numTFActionPerformed(evt);
            }
        });
        getContentPane().add(numTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 370, 110, -1));

        cepTF.setBackground(new java.awt.Color(255, 255, 255));
        cepTF.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        cepTF.setForeground(new java.awt.Color(0, 0, 0));
        cepTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cepTFActionPerformed(evt);
            }
        });
        getContentPane().add(cepTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, 110, -1));

        SenhaUMTF.setBackground(new java.awt.Color(255, 255, 255));
        SenhaUMTF.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        getContentPane().add(SenhaUMTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 120, -1));

        SenhaDoisTF.setBackground(new java.awt.Color(255, 255, 255));
        SenhaDoisTF.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        getContentPane().add(SenhaDoisTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 120, -1));

        nomeCTF.setBackground(new java.awt.Color(255, 255, 255));
        nomeCTF.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        nomeCTF.setForeground(new java.awt.Color(0, 0, 0));
        nomeCTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeCTFActionPerformed(evt);
            }
        });
        getContentPane().add(nomeCTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 230, -1));

        logradouroLBL.setFont(new java.awt.Font("Lucida Calligraphy", 1, 18)); // NOI18N
        logradouroLBL.setForeground(new java.awt.Color(0, 0, 0));
        logradouroLBL.setText("Logradouro");
        getContentPane().add(logradouroLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 130, -1));

        celularDoisLBL.setFont(new java.awt.Font("Lucida Calligraphy", 1, 18)); // NOI18N
        celularDoisLBL.setForeground(new java.awt.Color(0, 0, 0));
        celularDoisLBL.setText("Celular - 2");
        getContentPane().add(celularDoisLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 220, 110, -1));

        senhaUmLBL.setFont(new java.awt.Font("Lucida Calligraphy", 1, 18)); // NOI18N
        senhaUmLBL.setForeground(new java.awt.Color(0, 0, 0));
        senhaUmLBL.setText("Senha");
        getContentPane().add(senhaUmLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, -1, -1));

        numeroLBL.setFont(new java.awt.Font("Lucida Calligraphy", 1, 18)); // NOI18N
        numeroLBL.setForeground(new java.awt.Color(0, 0, 0));
        numeroLBL.setText("Número");
        getContentPane().add(numeroLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 90, -1));

        cepLBL.setFont(new java.awt.Font("Lucida Calligraphy", 1, 18)); // NOI18N
        cepLBL.setForeground(new java.awt.Color(0, 0, 0));
        cepLBL.setText("CEP");
        getContentPane().add(cepLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 90, -1));

        celularUmLBL.setFont(new java.awt.Font("Lucida Calligraphy", 1, 18)); // NOI18N
        celularUmLBL.setForeground(new java.awt.Color(0, 0, 0));
        celularUmLBL.setText("Celular - 1");
        getContentPane().add(celularUmLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, 110, -1));

        nomeLBL.setFont(new java.awt.Font("Lucida Calligraphy", 1, 18)); // NOI18N
        nomeLBL.setForeground(new java.awt.Color(0, 0, 0));
        nomeLBL.setText("Nome ");
        getContentPane().add(nomeLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, -1));

        CancelarBttn.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        CancelarBttn.setText("CANCELAR");
        CancelarBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarBttnActionPerformed(evt);
            }
        });
        getContentPane().add(CancelarBttn, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 450, 120, -1));

        CadastrarBttn.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        CadastrarBttn.setText("CADASTRAR");
        CadastrarBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarBttnActionPerformed(evt);
            }
        });
        getContentPane().add(CadastrarBttn, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 450, -1, -1));

        AvisosLBL.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        AvisosLBL.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(AvisosLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, 270, 20));

        Imagem.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gamer\\Downloads\\CadastroBG.png")); // NOI18N
        getContentPane().add(Imagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTFActionPerformed
        // =TODO add your handling code here:
    }//GEN-LAST:event_emailTFActionPerformed

    private void CelularDoisTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CelularDoisTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CelularDoisTFActionPerformed

    private void LogradouroTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogradouroTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LogradouroTFActionPerformed

    private void numTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numTFActionPerformed

    private void cepTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cepTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cepTFActionPerformed

    private void CelularUMTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CelularUMTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CelularUMTFActionPerformed

    private void CancelarBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarBttnActionPerformed
        setVisible(false);
        LoginUsuario lu = new LoginUsuario();
        lu.setVisible(true);
    }//GEN-LAST:event_CancelarBttnActionPerformed

    private void CadastrarBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarBttnActionPerformed
        try {
            //resgatando dados inseridos do usuário
            Connection conexao = new ConexaoBancoDeDados().getConnection();
            char[] senha = SenhaUMTF.getPassword();
            String convert = String.valueOf(senha);
        
            char[] senhaDois = SenhaDoisTF.getPassword();
            String convertDois = String.valueOf(senhaDois);
            //verificando se senhas são iguais
            if(!convert.equals(convertDois)|| convert.isEmpty() || convertDois.isEmpty()){
                AvisosLBL.setText("Senha inválida ou Não são iguais!");
                //verificando se dados foram preenchidos
            }else if(emailTF.getText().isEmpty() || nomeCTF.getText().isEmpty() || 
                CelularUMTF.getText().isEmpty() || cepTF.getText().isEmpty() || LogradouroTF.getText().isEmpty()){
                AvisosLBL.setText("Cadastro incompleto!");
            }
            else{
                UserManage us = new UserManage(conexao);
                us.insertNewUser(nomeCTF.getText(), convert, emailTF.getText(), CelularUMTF.getText(), 
                        CelularDoisTF.getText(), cepTF.getText(), LogradouroTF.getText(), numTF.getText());
            }
            nomeCTF.setText(""); 
            SenhaUMTF.setText(""); 
            SenhaDoisTF.setText(""); 
            emailTF.setText("");
            CelularUMTF.setText(""); 
            CelularDoisTF.setText("");
            cepTF.setText("");
            LogradouroTF.setText("");
            numTF.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(CadastroFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CadastrarBttnActionPerformed

    private void nomeCTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeCTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeCTFActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AvisosLBL;
    private javax.swing.JButton CadastrarBttn;
    private javax.swing.JButton CancelarBttn;
    private javax.swing.JTextField CelularDoisTF;
    private javax.swing.JTextField CelularUMTF;
    private javax.swing.JLabel Imagem;
    private javax.swing.JTextField LogradouroTF;
    private javax.swing.JPasswordField SenhaDoisTF;
    private javax.swing.JPasswordField SenhaUMTF;
    private javax.swing.JLabel celularDoisLBL;
    private javax.swing.JLabel celularUmLBL;
    private javax.swing.JLabel cepLBL;
    private javax.swing.JTextField cepTF;
    private javax.swing.JLabel emailLBL;
    private javax.swing.JTextField emailTF;
    private javax.swing.JLabel logradouroLBL;
    private javax.swing.JTextField nomeCTF;
    private javax.swing.JLabel nomeLBL;
    private javax.swing.JTextField numTF;
    private javax.swing.JLabel numeroLBL;
    private javax.swing.JLabel senhaDoisLBL;
    private javax.swing.JLabel senhaUmLBL;
    // End of variables declaration//GEN-END:variables
}
