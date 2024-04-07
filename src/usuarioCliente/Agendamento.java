package usuarioCliente;

import java.util.Calendar;
import java.time.LocalDate;
import conexaoBancos.ConexaoBancoDeDados;
import dataBaseManage.UserManage;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.format.DateTimeFormatter;
    
public class Agendamento extends javax.swing.JFrame {
    
    private javax.swing.JLabel Imagem;
    private javax.swing.JButton agendarBTTN;
    private javax.swing.JButton cancelarBTTN;
    private com.toedter.calendar.JDateChooser dataEscolhida;
    private javax.swing.JLabel dataLBL;
    private javax.swing.JLabel horarioLBL;
    private javax.swing.JComboBox<String> horariosDisponiveis;
    private String usuario;
    
    public Agendamento() {
        initComponents();
    }
    public Agendamento(String usuario){
        initComponents();
        this.usuario = usuario;
        setVisible(true);
    }
    private void initComponents() {

        horarioLBL = new javax.swing.JLabel();
        dataLBL = new javax.swing.JLabel();
        dataEscolhida = new com.toedter.calendar.JDateChooser();
        cancelarBTTN = new javax.swing.JButton();
        agendarBTTN = new javax.swing.JButton();
        horariosDisponiveis = new javax.swing.JComboBox<>();
        Imagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        horarioLBL.setFont(new java.awt.Font("Segoe UI Historic", 3, 18));
        horarioLBL.setForeground(new java.awt.Color(0, 0, 0));
        horarioLBL.setText("Horários:");
        getContentPane().add(horarioLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 90, -1));

        dataLBL.setFont(new java.awt.Font("Segoe UI Historic", 3, 18));
        dataLBL.setForeground(new java.awt.Color(0, 0, 0));
        dataLBL.setText("Data de agendamento: ");
        getContentPane().add(dataLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, -1, -1));
        getContentPane().add(dataEscolhida, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, -1));

        cancelarBTTN.setFont(new java.awt.Font("Segoe UI", 3, 18));
        cancelarBTTN.setText("CANCELAR");
        cancelarBTTN.addActionListener(cancelarBTTNActionPerformed());
        getContentPane().add(cancelarBTTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, -1, -1));

        agendarBTTN.setFont(new java.awt.Font("Segoe UI", 3, 18));
        agendarBTTN.setText("AGENDAR");
        agendarBTTN.addActionListener(evt -> agendarBTTNActionPerformed());
        getContentPane().add(agendarBTTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, -1, -1));

        horariosDisponiveis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00", "09:00", "10:00", "11:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00" }));
        getContentPane().add(horariosDisponiveis, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, -1, -1));

        Imagem.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gamer\\Downloads\\UserWLPP.jpg"));
        getContentPane().add(Imagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }

    private void cancelarBTTNActionPerformed() {
        setVisible(false);
    }
    //botão para agendar horario
    private void agendarBTTNActionPerformed() {
        try {
            Connection conexao = new ConexaoBancoDeDados().getConnection();
            Calendar cd = Calendar.getInstance();
            //formatador de data
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            cd.setTime(dataEscolhida.getDate());
            int year = cd.get(Calendar.YEAR);
            String month = String.valueOf(cd.get(Calendar.MONTH));
            String day = String.valueOf(cd.get(Calendar.DATE));
            //verificador de valores simples
            if(month.length() == 1){
                month = "0"+cd.get(Calendar.MONTH);
            }
            if(day.length()==1){
                day = "0"+cd.get(Calendar.DATE);
            }
            LocalDate ld = LocalDate.parse(year+"-"+month+"-"+day);
            String data = dtf.format(ld);
            String hora = (String) horariosDisponiveis.getSelectedItem();
            UserManage umn = new UserManage(conexao);
            umn.agendarHorario(data, hora,usuario);
        } catch (SQLException ex) {
            Logger.getLogger(Agendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agendamento().setVisible(true);
            }
        });
    }
}
