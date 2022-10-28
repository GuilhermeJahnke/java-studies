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
                    resultSet.getString("NOME"),
                    resultSet.getDouble("VALOR")
                );
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return activities;

    }


    public int createAccount(AccountEntities account) {
        
        int affectedRows = 0;
        PreparedStatement statement;
        String sql = "INSERT INTO ACCOUNT (ACCOUNT_NAME, ACCOUNT_BALANCE) VALUES ( ?, ?)";

        try {
            statement = connectionManager.GetConnection().prepareStatement(sql);
            statement.setString(1, account.getName());
            statement.setDouble(2, account.getBalance());

            affectedRows = connectionManager.ExecuteCommand(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        

        return affectedRows;
    }

    public int editAccount(String name, double balance) {
        int affectedRows = 0;
        PreparedStatement statement;
        String sql = "UPDATE ACCOUNT SET ACCOUNT_NAME = ?, balance = ?";

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
                    result.getString("ACCOUNT_NAME"),
                    result.getDouble("ACCOUNT_BALANCE")
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
