package data.repository.account;
import java.util.Random;

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
            statement = connectionManager.GetConnection().prepareStatement("SELECT * FROM T_FIN_CONTA WHERE ID_ACCOUNT = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                activities = new AccountEntities(
                        resultSet.getString("NM_NAME"),
                        resultSet.getDouble("VL_SALDO"),
                        resultSet.getInt("ID_USUARIO"),
                        resultSet.getInt("ID_ACCOUNT")
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
        String sql = "INSERT INTO T_FIN_CONTA (NM_NAME, VL_SALDO, ID_ACCOUNT, ID_USUARIO) VALUES ( ?, ?, ?, ?)";

        try {
            statement = connectionManager.GetConnection().prepareStatement(sql);
            statement.setString(1, account.getName());
            statement.setDouble(2, account.getBalance());
            statement.setInt(3, account.getId());
            statement.setInt(4, account.getUserId());

            affectedRows = connectionManager.ExecuteCommand(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return affectedRows;
    }

    public int editAccount(String name, double balance) {
        int affectedRows = 0;
        PreparedStatement statement;
        String sql = "UPDATE T_FIN_CONTA SET NM_NAME = ?, VL_SALDO = ?";

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
        String sql = "DELETE FROM T_FIN_CONTA WHERE ID_ACCOUNT = ?";

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
            statement = connectionManager.GetConnection().prepareStatement("SELECT * FROM T_FIN_CONTA");
            ResultSet result = connectionManager.GetData(statement);

            while (result.next()) {
                activities = new AccountEntities(
                        result.getString("NM_NAME"),
                        result.getDouble("VL_SALDO"),
                        result.getInt("ID_USUARIO"),
                        result.getInt("ID_ACCOUNT")
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
