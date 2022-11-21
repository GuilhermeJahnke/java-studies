package data.repository.user;


import domain.entities.user.UserEntities;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

import data.connection.ConnectionDAO;

public class UserRepository {
    ConnectionDAO connectionManager = new ConnectionDAO();

    public UserEntities findById(int id) {
        PreparedStatement statement = null;
        UserEntities user = null;

        try {
            statement = connectionManager.GetConnection().prepareStatement("SELECT * FROM T_FIN_USUARIO WHERE ID_USUARIO = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
            	user = new UserEntities(
                        resultSet.getString("NM_USUARIO"),
                        resultSet.getString("DS_EMAIL"),
                        resultSet.getString("NM_CPF"),
                        resultSet.getString("DS_SENHA"),
                        resultSet.getInt("ID_USUARIO")
                );
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

    }
    
    public UserEntities findByEmail(String email) {
        PreparedStatement statement = null;
        UserEntities user = null;

        try {
            statement = connectionManager.GetConnection().prepareStatement("SELECT * FROM T_FIN_USUARIO WHERE DS_EMAIL = ?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
            	user = new UserEntities(
                        resultSet.getString("NM_NAME"),
                        resultSet.getString("DS_EMAIL"),
                        resultSet.getString("NM_CPF"),
                        resultSet.getString("DS_SENHA"),
                        resultSet.getInt("ID_USUARIO")
                );
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

    }

    public int create(UserEntities user) {

        int affectedRows = 0;
        PreparedStatement statement;
        String sql = "INSERT INTO T_FIN_USUARIO(NM_USUARIO, DS_EMAIL, NM_CPF, DS_SENHA, ID_USUARIO) VALUES ( ?, ?, ?, ?, ?)";

        try {
            statement = connectionManager.GetConnection().prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setInt(5, user.getId());
            statement.setString(3, user.getCpf());
            statement.setString(4, user.getPassword());

            affectedRows = connectionManager.ExecuteCommand(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return affectedRows;
    }

    public int edit(UserEntities user) {

        int affectedRows = 0;
        PreparedStatement statement;
        String sql = "UPDATE T_FIN_USUARIO SET NM_USUARIO = ?, DS_EMAIL = ?, NM_CPF = ?, DS_SENHA = ?, ID_USUARIO = ?";

        try {
            statement = connectionManager.GetConnection().prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setInt(5, user.getId());
            statement.setString(3, user.getCpf());
            statement.setString(4, user.getPassword());

            affectedRows = connectionManager.ExecuteCommand(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return affectedRows;
    }

    public int remove(int id) {
    	int affectedRows = 0;
        PreparedStatement statement;
        String sql = "DELETE FROM T_FIN_USUARIO WHERE ID_USUARIO = ?";

        try {
            statement = connectionManager.GetConnection().prepareStatement(sql);
            statement.setInt(1, id);

            affectedRows = connectionManager.ExecuteCommand(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return affectedRows;
    }

    public ArrayList<UserEntities> getAll() {
    	ArrayList<UserEntities> userEntitiesList = new ArrayList<>();
        PreparedStatement statement = null;
        UserEntities users = null;
        
        try {
            statement = connectionManager.GetConnection().prepareStatement("SELECT * FROM T_FIN_USUARIO");
            ResultSet result = connectionManager.GetData(statement);

            while (result.next()) {
            	users = new UserEntities(
            			result.getString("NM_USUARIO"),
            			result.getString("DS_EMAIL"),
            			result.getString("NM_CPF"),
            			result.getString("DS_SENHA"),
            			result.getInt("ID_USUARIO")
                );
            	userEntitiesList.add(users);
            }

            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userEntitiesList;
    }

    public UserEntities login(String email, String password){
        UserEntities userFind = findByEmail(email);
        if(userFind == null){ throw new IllegalArgumentException("Usuário não encontrado"); }

        if(Objects.equals(userFind.getEmail(), email) && Objects.equals(userFind.getPassword(), password)) {
            return userFind;
        }

        throw new IllegalArgumentException("Usuário não encontrado");

    }
}
