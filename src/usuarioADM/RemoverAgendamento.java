/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package usuarioADM;
import conexaoBancos.ConexaoBancoDeDados;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.sql.ResultSet;
import dataBaseManage.UserManage;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import usuarioCliente.Agendamento;

public class RemoverAgendamento extends javax.swing.JFrame {

    /**
     * Creates new form AgendarCliente
     */
    public RemoverAgendamento() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomeCTF = new javax.swing.JTextField();
        ClienteLBL = new javax.swing.JLabel();
        HorarioLBL = new javax.swing.JLabel();
        DataAgendaDT = new com.toedter.calendar.JDateChooser();
        horariosDisponiveis = new javax.swing.JComboBox<>();
        DataLBL = new javax.swing.JLabel();
        removerBTTN = new javax.swing.JButton();
        CancelarBTTN = new javax.swing.JButton();
        IMAGEM = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nomeCTF.setBackground(new java.awt.Color(255, 255, 255));
        nomeCTF.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        nomeCTF.setForeground(new java.awt.Color(0, 0, 0));
        nomeCTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeCTFActionPerformed(evt);
            }
        });
        getContentPane().add(nomeCTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 230, -1));

        ClienteLBL.setFont(new java.awt.Font("Lucida Calligraphy", 1, 18)); // NOI18N
        ClienteLBL.setForeground(new java.awt.Color(0, 0, 0));
        ClienteLBL.setText("Cliente");
        getContentPane().add(ClienteLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));

        HorarioLBL.setFont(new java.awt.Font("Lucida Calligraphy", 1, 18)); // NOI18N
        HorarioLBL.setForeground(new java.awt.Color(0, 0, 0));
        HorarioLBL.setText("Horário");
        getContentPane().add(HorarioLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 150, -1));
        getContentPane().add(DataAgendaDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, -1, -1));

        horariosDisponiveis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00", "09:00", "10:00", "11:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00" }));
        horariosDisponiveis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horariosDisponiveisActionPerformed(evt);
            }
        });
        getContentPane().add(horariosDisponiveis, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, -1, -1));

        DataLBL.setFont(new java.awt.Font("Lucida Calligraphy", 1, 18)); // NOI18N
        DataLBL.setForeground(new java.awt.Color(0, 0, 0));
        DataLBL.setText("Data");
        getContentPane().add(DataLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 150, -1));

        removerBTTN.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        removerBTTN.setText("REMOVER");
        removerBTTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerBTTNActionPerformed(evt);
            }
        });
        getContentPane().add(removerBTTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, -1, -1));

        CancelarBTTN.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        CancelarBTTN.setText("CANCELAR");
        CancelarBTTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarBTTNActionPerformed(evt);
            }
        });
        getContentPane().add(CancelarBTTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, -1, -1));

        IMAGEM.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gamer\\Downloads\\UserWLPP.jpg")); // NOI18N
        getContentPane().add(IMAGEM, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeCTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeCTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeCTFActionPerformed

    private void horariosDisponiveisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horariosDisponiveisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_horariosDisponiveisActionPerformed
    //botão para remover horario
    private void removerBTTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerBTTNActionPerformed
        try{
            Connection cn = new ConexaoBancoDeDados().getConnection();
            String cliente = nomeCTF.getText();
            //executando script sql
            PreparedStatement ps = cn.prepareStatement("select * from usuario where nome = '"+cliente+"';");
            ps.execute();
            ResultSet rs = ps.getResultSet();
            //verificando se existe o horario agendado do cliente
            if(rs.next() == true){
                int id = rs.getInt("id");
                Calendar cl = Calendar.getInstance();
                cl.setTime(DataAgendaDT.getDate());
                int year = cl.get(Calendar.YEAR);
                String month = String.valueOf(cl.get(Calendar.MONTH));
                String day = String.valueOf(cl.get(Calendar.DATE));
                //verificador de valores singulares
                if(month.length() == 1){
                    month = "0"+String.valueOf(cl.get(Calendar.MONTH));
                }
                if(day.length() == 1){
                    day = "0"+String.valueOf(cl.get(Calendar.DATE));
                }
                LocalDate ld = LocalDate.parse(year+"-"+month+"-"+day);
                //formatação de data
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String data = dtf.format(ld);
                String horario = (String) horariosDisponiveis.getSelectedItem();
                UserManage um = new UserManage(cn);
                um.removerHorario(data, horario, id);
                nomeCTF.setText("");
            }else{
                JOptionPane.showMessageDialog(null, "Usuário Não Encontrado!","Erro",JOptionPane.ERROR_MESSAGE);
            }
            
        }catch(SQLException e){
            Logger.getLogger(Agendamento.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_removerBTTNActionPerformed

    private void CancelarBTTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarBTTNActionPerformed
       setVisible(false);
    }//GEN-LAST:event_CancelarBTTNActionPerformed

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
            java.util.logging.Logger.getLogger(RemoverAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RemoverAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RemoverAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RemoverAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RemoverAgendamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelarBTTN;
    private javax.swing.JLabel ClienteLBL;
    private com.toedter.calendar.JDateChooser DataAgendaDT;
    private javax.swing.JLabel DataLBL;
    private javax.swing.JLabel HorarioLBL;
    private javax.swing.JLabel IMAGEM;
    private javax.swing.JComboBox<String> horariosDisponiveis;
    private javax.swing.JTextField nomeCTF;
    private javax.swing.JButton removerBTTN;
    // End of variables declaration//GEN-END:variables
}
