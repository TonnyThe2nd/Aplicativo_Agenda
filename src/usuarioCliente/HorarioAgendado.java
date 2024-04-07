package usuarioCliente;

import conexaoBancos.ConexaoBancoDeDados;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HorarioAgendado extends javax.swing.JFrame {

    private javax.swing.JLabel DataDBLBL;
    private javax.swing.JLabel DataLBL;
    private javax.swing.JLabel HOrarioDBLBL;
    private javax.swing.JLabel HorarioLBL;
    private javax.swing.JLabel Imagem;
    private javax.swing.JLabel TextLB1;
    private javax.swing.JButton VoltarBTTN;
    private String username;
            
    public HorarioAgendado() {
        initComponents();
    }
    public HorarioAgendado(String username) throws SQLException{
        this.username = username;
        initComponents();
        setHorario();
        setVisible(true);
    }
    private void initComponents() {

        TextLB1 = new javax.swing.JLabel();
        HOrarioDBLBL = new javax.swing.JLabel();
        DataDBLBL = new javax.swing.JLabel();
        DataLBL = new javax.swing.JLabel();
        HorarioLBL = new javax.swing.JLabel();
        VoltarBTTN = new javax.swing.JButton();
        Imagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TextLB1.setFont(new java.awt.Font("Segoe UI Historic", 3, 24));
        TextLB1.setForeground(new java.awt.Color(0, 0, 0));
        TextLB1.setText("Horário agendado:");
        getContentPane().add(TextLB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 220, -1));

        HOrarioDBLBL.setFont(new java.awt.Font("Segoe UI Historic", 3, 24));
        HOrarioDBLBL.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(HOrarioDBLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 320, 100));

        DataDBLBL.setFont(new java.awt.Font("Segoe UI Historic", 3, 24)); 
        DataDBLBL.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(DataDBLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 210, 80));

        DataLBL.setFont(new java.awt.Font("Segoe UI Historic", 3, 24));
        DataLBL.setForeground(new java.awt.Color(0, 0, 0));
        DataLBL.setText("Data:");
        getContentPane().add(DataLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 460, 60));

        HorarioLBL.setFont(new java.awt.Font("Segoe UI Historic", 3, 24));
        HorarioLBL.setForeground(new java.awt.Color(0, 0, 0));
        HorarioLBL.setText("Horário:");
        getContentPane().add(HorarioLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 100, -1));

        VoltarBTTN.setFont(new java.awt.Font("Segoe UI Black", 3, 14));
        VoltarBTTN.setText("VOLTAR");
        VoltarBTTN.addActionListener(evt -> VoltarBTTNActionPerformed());
        getContentPane().add(VoltarBTTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 130, 40));

        Imagem.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gamer\\Downloads\\UserWLPP.jpg")); // NOI18N
        getContentPane().add(Imagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }

    private void VoltarBTTNActionPerformed() {
        setVisible(false);
    }
    //alterar texto para horario agendado
    private void setHorario() throws SQLException{
        Connection conexao = new ConexaoBancoDeDados().getConnection();
        PreparedStatement psUser = conexao.prepareStatement("select id from usuario where nome = '"+username+"';");
        psUser.execute();
        ResultSet rsUser = psUser.getResultSet();
        rsUser.next();
        String id = rsUser.getString("id");
        //script sql
        PreparedStatement psTime = conexao.prepareStatement("select data from horarios where id_usuario = '"+id+"';");
        psTime.execute();
        ResultSet rsTime = psTime.getResultSet();
        //verificando se horário existe
        if(rsTime.next()==true){
            String data = rsTime.getString("data");
            DataDBLBL.setText(data);
            //script sql
            PreparedStatement psHour = conexao.prepareStatement("select horario from horarios where id_usuario = '"+id+"';");
            psHour.execute();
            ResultSet rsHour = psHour.getResultSet();
            rsHour.next();
            String horario = rsHour.getString("horario");
            HOrarioDBLBL.setText(horario);
        
        }else{
            //caso horário não exista
            HorarioLBL.setText("");
            DataLBL.setText("Ops!! Não há agendamentos...");
        }    
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HorarioAgendado().setVisible(true);
            }
        });
    }
}
