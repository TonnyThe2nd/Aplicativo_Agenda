/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
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
