package data.repository.account;

import domain.entities.account.AccountEntities;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.connection.ConnectionDAO;

public class AccountRepository {
    ConnectionDAO connectionManager = new ConnectionDAO();

    public AccountEntities findById(int id) {
        PreparedStatement statement = null;
		AccountEntities activities = null;

        try {
            statement = connectionManager.GetConnection().prepareStatement("SELECT * FROM TB_ACCOUNT WHERE ID_ACCOUNT = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                activities = new AccountEntities(
                        resultSet.getInt("ID_ACCOUNT"),
                    resultSet.getString("NM_NAME"),
                    resultSet.getDouble("BL_BALANCE")
                );
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return activities;

    }


    public int createAccount(String name, double balance) {
        
        int affectedRows = 0;
        PreparedStatement statement;
        String sql = "INSERT INTO ACCOUNT ( NM_NAME, BL_BALANCE) VALUES ( ?, ?)";

        try {
            statement = connectionManager.GetConnection().prepareStatement(sql);
            statement.setString(1, name);
            statement.setDouble(2, balance);

            affectedRows = connectionManager.ExecuteCommand(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        

        return affectedRows;
    }

    public int editAccount(String name, double balance) {
        int affectedRows = 0;
        PreparedStatement statement;
        String sql = "UPDATE ACCOUNT SET NM_NAME = ?, BL_BALANCE = ?";

        try {
            statement = connectionManager.GetConnection().prepareStatement(sql);
            statement.setString(1, name);
            statement.setDouble(2, balance);

            affectedRows = connectionManager.ExecuteCommand(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return affectedRows;
    }

    public int removeAccount(int id) {
        int affectedRows = 0;
		PreparedStatement statement;
        String sql = "DELETE FROM ACCOUNTS WHERE ID_ACCOUNT = ?";

        try {
            statement = connectionManager.GetConnection().prepareStatement(sql);
            statement.setInt(1, id);

            affectedRows = connectionManager.ExecuteCommand(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return affectedRows;
    }

    public ArrayList<AccountEntities> getAll() {
        ArrayList<AccountEntities> activitiesList = new ArrayList<>();
        PreparedStatement statement = null;
		AccountEntities activities = null;

        try {
            statement = connectionManager.GetConnection().prepareStatement("SELECT * FROM ACCOUNTS");
            ResultSet result = connectionManager.GetData(statement);

            while (result.next()) {
                activities = new AccountEntities(
                        result.getInt("ID_ACCOUNT"),
                    result.getString("NM_NAME"),
                    result.getDouble("BL_BALANCE")
                );
                activitiesList.add(activities);
            }

            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return activitiesList;
    }
}
