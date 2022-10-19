package data.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
  
  public class ConnectionDAO {
    private Connection connection;
  
    public ConnectionDAO() throws ClassNotFoundException {
        System.out.println("Inicio");
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         OpenConnection();
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }
    }

    private void OpenConnection(){
      try {
        this.connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM92923", "230601");
        System.out.println("Conectado!");
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    public Connection GetConnection() {
      return this.connection;
    }

    public void CloseConnection() throws SQLException {
        this.connection.close();
    }

    public int ExecuteCommand(PreparedStatement statement) {
      int affectedRows = 0;
      try {
        this.connection.setAutoCommit(false); // Entender o que é isso
        affectedRows = statement.executeUpdate();
        this.connection.commit();
  
      } catch (SQLException e) {
        System.out.println("Error to execute comand");
        e.printStackTrace();
        try {
          // In case it goes wrong, it will undo the changes with the rollback
          this.connection.rollback();
        } catch (SQLException e1) {
          e1.printStackTrace();
        }
  
      }
  
      return affectedRows;
    }

  }