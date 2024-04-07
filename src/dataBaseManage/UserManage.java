package dataBaseManage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import usuarioCliente.ClienteFrame;
import usuarioADM.InterfaceADM;
import mainFrame.RecuperarSenha.NovaSenha;
public class UserManage{
    private final Connection connection;
    private boolean verificadorAcesso;
    
    public UserManage(Connection connection){
        this.connection = connection;
        
    }
  
    //Cadastro de novos usuários
    public void insertNewUser(String name, String senha, String email, String numUm, String numDois,
            String cep, String logradouro, String numHouse) throws SQLException{
            //Executando script SQL
            PreparedStatement ps = connection.prepareStatement("insert into usuario(nome, senha, email,celular_um, celular_dois,cep,logradouro,numero_casa)"+
                    "values('"+name+"','"+senha+"','"+email+"','"+
                    numUm+"','"+numDois+"','"+cep+"','"+logradouro+"','"+numHouse+"')");
            ps.execute();
        
    }
    
    //Acessando conta de usuário
    public void login(String name, String senha){
        try{
            //Executando script SQL
            PreparedStatement ps = connection.prepareStatement("select * from usuario where nome = '"+name+"'"
                    + "and senha = '"+ senha+"'");
            ps.execute();
            ResultSet rs = ps.getResultSet();
            //Verificando se usuário existe
            if(rs.next() == true){
                //Verificando se usuário é adm ou cliente
                if(rs.getString("nome").equals("Antonio") && rs.getString("senha").equals("antonio123")){
                    InterfaceADM adm = new InterfaceADM();
                    adm.setVisible(true);
                    verificadorAcesso = true;
                }else{
                    String nome = rs.getString("nome");
                    ClienteFrame cf = new ClienteFrame(nome);
                    cf.setVisible(true);
                    verificadorAcesso = true;
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "Usuário Inválido ou inexistente!! Tente novamente.", 
                        "Usuário inválido", JOptionPane.ERROR_MESSAGE);
            }
        }catch(SQLException e){
            System.out.println("Erro");
        }
        
    }
    //verificador se login foi concluido ou não
    public boolean var(){
        return verificadorAcesso;
    }
    
    //agendamento de horário
    public void agendarHorario(String date, String horario, String user)throws SQLException{
        //script para localizar id do usuario
        PreparedStatement psUser = connection.prepareStatement("select * from usuario where nome = '"+user+"';");
        psUser.execute();
        ResultSet rs = psUser.getResultSet();
        rs.next();
        String idUser = rs.getString("id");
        //script para localizar agenda do usuario a partir do id
        PreparedStatement psCheck = connection.prepareStatement("select * from horarios where data = '"
                +date+"' and horario = '"+horario+"';");
        psCheck.execute();
        ResultSet check = psCheck.getResultSet();
        //verificando se horário para agenda ja existe
        if(check.next()==true){
            JOptionPane.showMessageDialog(null, "Horário indisponível!! Tente novamente.", 
                    "Horário Indisponível", JOptionPane.ERROR_MESSAGE);
        }else{
            PreparedStatement ps = connection.prepareStatement("insert into horarios(data, horario,id_usuario)"
                    + "values('"+date+"','"+horario+"','"+idUser+"');");
            ps.execute();
        }
    }
    
    //removendo horario agendado
    public void removerHorario(String data, String horario,int user)throws SQLException{
        PreparedStatement ps = connection.prepareStatement("select * from horarios where data ='"+data+"'"
                + "and horario = '"+horario+"' and id_usuario = "+user);
        ps.execute();
        ResultSet rs = ps.getResultSet();
        if(rs.next() == true){
            PreparedStatement psDelete = connection.prepareStatement("delete from horarios where data =" 
                    +"'"+data+"' and horario = '" + horario+ "' and id_usuario = " + user);
            psDelete.execute();
        }else{
            JOptionPane.showMessageDialog(null, "Horário não encontrado!! Tente novamente.", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //verificando se usuário existe para recuperar a senha
    public void verificacaoRecuperarSenha(String nome, String email) throws SQLException{
        PreparedStatement ps = connection.prepareStatement("select * from usuario where nome = '"
                + nome +"' and email = '"+email+"'");
        ps.execute();
        ResultSet rs = ps.getResultSet();
        if(rs.next() == true){
            NovaSenha ns = new NovaSenha(nome, email);
            ns.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Usuário não encontrado!! Tente novamente.", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //trocando a senha do usuário para recuperar senha
    public void recuperarSenha(String nome, String email, String senha)throws SQLException{
        PreparedStatement psSenha = connection.prepareStatement("update usuario " +
        "set senha = '"+senha+"' " +
        "where nome = '"+nome+"' and email = '"+email+"'");
        psSenha.execute();
        JOptionPane.showMessageDialog(null, "Senha Alterada Com Sucesso!!", 
                    "Senha Alterada", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
