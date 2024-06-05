package Projeto;
//import java.sql.*;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class ConectaBanco {
    
    private String query;
    
    //Conectando ao banco de dados
      public static Connection getConexao(){
          final String URL = "jdbc:mysql://localhost:3306/sitecompras";
          final String USER = "root";
           final String SENHA = "140106";
     try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, SENHA);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC não encontrado.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados.");
            e.printStackTrace();
        }
        return null;
     
      
  }
    
    //CREATE
    public boolean inserirDado(String CPF, String Nome,String Telefone,String Endereco){
        try{
           query = "INSERT INTO Clientes(CPF,nome,telefone,endereco) VALUES(?,?,?,?)"; 
           PreparedStatement stmt = getConexao().prepareStatement(query);
            stmt.setString(1, CPF);
            stmt.setString(2, Nome); 
            stmt.setString(3, Telefone);
            stmt.setString(4, Endereco);
            return stmt.execute();
            
            
        }catch(SQLException e){
            System.out.println("Erro ao enviar dados");
        }
        return false;
    }
    
    //READ
    public ResultSet lerDado() throws SQLException{
        query = "SELECT * FROM Clientes";
        PreparedStatement stmt = getConexao().prepareStatement(query);
        return stmt.executeQuery();
    }
    
    //UPDATE
    public int atualizarDado(String Nome,String Telefone,String Endereco,String CPF) throws SQLException{
      query =  "UPDATE Clientes SET nome = ?, telefone = ?, endereco = ? WHERE CPF = ?";
             
        PreparedStatement stmt = getConexao().prepareStatement(query); 
        stmt.setString(1, Nome);
        stmt.setString(2, Telefone);
        stmt.setString(3, Endereco);
        stmt.setString(4, CPF);
        
        return stmt.executeUpdate();
    
    }
    
    //DELETE
    public int deletarDado(String CPF) throws SQLException{
      query = "DELETE FROM Clientes where CPF = ?" ;
      PreparedStatement stmt = getConexao().prepareStatement(query);
      stmt.setString(1, CPF);
      return stmt.executeUpdate();
    }
   
    
}
