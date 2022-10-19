package data.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
  
  public class ConnectionDAO {
  
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //Registra o Driver
        System.out.println("Inicio");
        Class.forName("oracle.jdbc.driver.OracleDriver");
  
        // //Abre uma conexão
        Connection conexao = DriverManager.getConnection(
            "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM92923", "230601");
        
        System.out.println("Conectado!");
        
        conexao.close();
    }
  }

  