package usuarioADM;

public class InterfaceADM extends javax.swing.JFrame {


    private javax.swing.JLabel IMG;
    private javax.swing.JLabel WelcomeLBL;
    private javax.swing.JButton agendarBTTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton removerBTTN;
    private String user;
    
    public InterfaceADM() {
        initComponents();
    }
    private void initComponents() {

        removerBTTN = new javax.swing.JButton();
        WelcomeLBL = new javax.swing.JLabel();
        agendarBTTN = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        IMG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        removerBTTN.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
        removerBTTN.setText("REMOVER AGENDAMENTO");
        removerBTTN.addActionListener(evt -> removerBTTNActionPerformed());
        getContentPane().add(removerBTTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 330, 50));

        WelcomeLBL.setFont(new java.awt.Font("Palatino Linotype", 2, 24));
        WelcomeLBL.setForeground(new java.awt.Color(0, 0, 0));
        WelcomeLBL.setText("ADMINISTRAÇÃO");
        getContentPane().add(WelcomeLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 330, 50));

        agendarBTTN.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
        agendarBTTN.setText("AGENDAR CLIENTE");
        agendarBTTN.addActionListener(evt -> agendarBTTNActionPerformed());
        getContentPane().add(agendarBTTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 330, 50));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("--Consulta de horários feita via banco");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, -1, -1));

        IMG.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gamer\\Downloads\\UserWLPP.jpg"));
        getContentPane().add(IMG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }
    //botão para remover agenda
    private void removerBTTNActionPerformed() {
        RemoverAgendamento ra = new RemoverAgendamento();
        ra.setVisible(true);
    }
    //botão para agendar horário
    private void agendarBTTNActionPerformed() {
        AgendarCliente ac = new AgendarCliente();
        ac.setVisible(true);
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceADM().setVisible(true);
            }
        });
    }
}
