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
            String script = "insert into usuario(nome, senha, email,celular_um, celular_dois,cep,"
                    + "logradouro,numero_casa) values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(script);
            ps.setString(1, name);
            ps.setString(2,senha);
            ps.setString(3,email);
            ps.setString(4,numUm);
            ps.setString(5,numDois);
            ps.setString(6,cep);
            ps.setString(7,logradouro);
            ps.setString(8,numHouse);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!!","Cadastro",JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    //Acessando conta de usuário
    public void login(String name, String senha){
        try{
            //Executando script SQL
            String script = "select * from usuario where nome = (?)"
                    + "and senha = (?)";
            PreparedStatement ps = connection.prepareStatement(script);
            ps.setString(1,name);
            ps.setString(2, senha);
            ps.executeQuery();
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
        String scriptUser = "select * from usuario where nome = (?);";
        PreparedStatement psUser = connection.prepareStatement(scriptUser);
        psUser.setString(1,user);
        psUser.execute();
        ResultSet rs = psUser.getResultSet();
        rs.next();
        String idUser = rs.getString("id");
        //script para localizar agenda do usuario a partir do id
        String scriptCheck = "select * from horarios where data = (?)"
                +" and horario = (?);";
        PreparedStatement psCheck = connection.prepareStatement(scriptCheck);
        psCheck.setString(1,date);
        psCheck.setString(2,horario);
        psCheck.executeQuery();
        ResultSet check = psCheck.getResultSet();
        //verificando se horário para agenda ja existe
        if(check.next()==true){
            JOptionPane.showMessageDialog(null, "Horário indisponível!! Tente novamente.", 
                    "Horário Indisponível", JOptionPane.ERROR_MESSAGE);
        }else{
            String script = "insert into horarios(data, horario,id_usuario)"
                    + "values(?,?,?);";
            PreparedStatement ps = connection.prepareStatement(script);
            ps.setString(1, date);
            ps.setString(2,horario);
            ps.setInt(3,Integer.valueOf(idUser));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Horário Agendado com sucesso!!","Agendamento",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    //removendo horario agendado
    public void removerHorario(String data, String horario,int user)throws SQLException{
        String scriptCheck = "select * from horarios where data = (?)"
                +" and horario = (?) and id_usuario = (?);";
        PreparedStatement ps = connection.prepareStatement(scriptCheck);
        ps.setString(1, data);
        ps.setString(2, horario);
        ps.setInt(3,user);
        ps.executeQuery();
        ResultSet rs = ps.getResultSet();
        if(rs.next() == true){
            String scriptDelete = "delete from horarios where data =(?)" 
                    +"and horario = (?)and id_usuario = (?)";
            PreparedStatement psDelete = connection.prepareStatement(scriptDelete);
            psDelete.setString(1, data);
            psDelete.setString(2, horario);
            psDelete.setInt(3, user);
            psDelete.execute();
            JOptionPane.showMessageDialog(null, "Horário removido com sucesso!!","Remoção",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Horário não encontrado!! Tente novamente.", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //verificando se usuário existe para recuperar a senha
    public void verificacaoRecuperarSenha(String nome, String email) throws SQLException{
        String scriptCheck = "select * from usuario where nome = (?) and email = (?)";
        PreparedStatement ps = connection.prepareStatement(scriptCheck);
        ps.setString(1, nome);
        ps.setString(2, email);
        ps.executeQuery();
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
        String script = "update usuario " +
        "set senha = (?) " +
        "where nome = (?) and email = (?)";
        PreparedStatement psSenha = connection.prepareStatement(script);
        psSenha.setString(1,senha);
        psSenha.setString(2,nome);
        psSenha.setString(3, email);
        psSenha.executeUpdate();
        JOptionPane.showMessageDialog(null, "Senha Alterada Com Sucesso!!", 
                    "Senha Alterada", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
