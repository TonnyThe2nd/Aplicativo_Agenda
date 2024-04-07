package usuarioCliente;
 
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteFrame extends javax.swing.JFrame {
    private String username;
    public ClienteFrame() {
        initComponents();
    }
    public ClienteFrame(String username){
        initComponents();
        this.username = username;
        WelcomeLBL.setText("Bem vindo(a), " + username + "!");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        WelcomeLBL = new javax.swing.JLabel();
        SairBTTN = new javax.swing.JButton();
        acompanharBTTN = new javax.swing.JButton();
        agendarHorario = new javax.swing.JButton();
        Imagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        WelcomeLBL.setFont(new java.awt.Font("Palatino Linotype", 2, 24)); // NOI18N
        WelcomeLBL.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(WelcomeLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 390, 50));

        SairBTTN.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        SairBTTN.setText("SAIR");
        SairBTTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairBTTNActionPerformed(evt);
            }
        });
        getContentPane().add(SairBTTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 70, 30));

        acompanharBTTN.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        acompanharBTTN.setText("ACOMPANHAR HORÁRIO AGENDADO");
        acompanharBTTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acompanharBTTNActionPerformed(evt);
            }
        });
        getContentPane().add(acompanharBTTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 330, 50));

        agendarHorario.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        agendarHorario.setText("AGENDAR HORÁRIO");
        agendarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendarHorarioActionPerformed(evt);
            }
        });
        getContentPane().add(agendarHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 330, 50));

        Imagem.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gamer\\Downloads\\UserWLPP.jpg")); // NOI18N
        Imagem.setText(" ");
        getContentPane().add(Imagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //botão para sair
    private void SairBTTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairBTTNActionPerformed
        setVisible(false);
    }//GEN-LAST:event_SairBTTNActionPerformed
    //botão para acompanhar agendamento
    private void acompanharBTTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acompanharBTTNActionPerformed
        try {
            HorarioAgendado ha = new HorarioAgendado(username);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_acompanharBTTNActionPerformed
    //botão para agendar horario
    private void agendarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendarHorarioActionPerformed
        Agendamento ag = new Agendamento(username);
        
    }//GEN-LAST:event_agendarHorarioActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Imagem;
    private javax.swing.JButton SairBTTN;
    private javax.swing.JLabel WelcomeLBL;
    private javax.swing.JButton acompanharBTTN;
    private javax.swing.JButton agendarHorario;
    // End of variables declaration//GEN-END:variables
}
