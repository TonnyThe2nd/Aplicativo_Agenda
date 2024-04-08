package conexaoBancos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
public class ConexaoBancoDeDados {

    public Connection getConnection() throws SQLException{
        //Conexão com banco de dados PostgreSql
        //Usuário deve mudar a conexão com o banco - localhost, senha, usuairo, nome do banco
        Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BancoManicure","postgres","postgres");
        return conexao;
    }
    
}
