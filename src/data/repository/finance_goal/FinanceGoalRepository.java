package data.repository.finance_goal;

import data.connection.ConnectionDAO;
import domain.entities.finance_goal.FinanceGoalEntities;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FinanceGoalRepository {
    ConnectionDAO connectionManager = new ConnectionDAO();

    public FinanceGoalEntities findById(int id) {
        PreparedStatement statement = null;
        FinanceGoalEntities activities = null;

        try {
            statement = connectionManager.GetConnection().prepareStatement("SELECT * FROM T_FIN_OBJETIVO_FINANCEIRO WHERE ID_OBJETIVO = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                activities = new FinanceGoalEntities(
                        resultSet.getString("NM_NOME"),
                        resultSet.getString("DS_DESCRICAO"),
                        resultSet.getDouble("VL_VALOR"),
                        resultSet.getString("DT_DATA"),
                        resultSet.getBoolean("BL_ALCANCADO")
                );
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return activities;

    }


    public int createFinanceGoal(FinanceGoalEntities financeGoalEntities) {

        int affectedRows = 0;
        PreparedStatement statement;
        String sql = "INSERT INTO T_FIN_OBJETIVO_FINANCEIRO (NM_NOME, DS_DESCRICAO, VL_VALOR, DT_DATA, BL_ALCANCADO) VALUES ( ?, ?, ? , ?, ?)";

        try {
            statement = connectionManager.GetConnection().prepareStatement(sql);

            statement.setString(1,financeGoalEntities.getName());
            statement.setString(2,financeGoalEntities.getDescription());
            statement.setDouble(3, financeGoalEntities.getValue());
            statement.setString(4, financeGoalEntities.toString());
            statement.setBoolean(5, financeGoalEntities.getAchieved());

            affectedRows = connectionManager.ExecuteCommand(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return affectedRows;
    }

    public int editFinanceGoal(String name, String description, double value, String date, boolean achieved) {
        int affectedRows = 0;
        PreparedStatement statement;
        String sql = "UPDATE T_FIN_OBJETIVO_FINANCEIRO SET NM_NOME = ?, DS_DESCRICAO = ?, VL_VALOR=?, DT_DATA=?, BL_ALCANCADO=? ";

        try {
            statement = connectionManager.GetConnection().prepareStatement(sql);

            statement.setString(1, name);
            statement.setString(2,description);
            statement.setDouble(3, value);
            statement.setString(4, date);
            statement.setBoolean(5, achieved);

            affectedRows = connectionManager.ExecuteCommand(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return affectedRows;
    }

    public int removeFinanceGoal(int id) {
        int affectedRows = 0;
        PreparedStatement statement;
        String sql = "DELETE FROM T_FIN_OBJETIVO_FINANCEIRO WHERE ID_OBJETIVO = ?";

        try {
            statement = connectionManager.GetConnection().prepareStatement(sql);
            statement.setInt(1, id);

            affectedRows = connectionManager.ExecuteCommand(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return affectedRows;
    }

    public ArrayList<FinanceGoalEntities> getAll() {
        ArrayList<FinanceGoalEntities> financeGoalList = new ArrayList<>();
        PreparedStatement statement = null;
        FinanceGoalEntities financeGoalEntities = null;

        try {
            statement = connectionManager.GetConnection().prepareStatement("SELECT * FROM T_ACCOUNT");
            ResultSet result = connectionManager.GetData(statement);

            while (result.next()) {
                financeGoalEntities = new FinanceGoalEntities(
                        result.getString("NM_NOME"),
                        result.getString("DS_DESCRICAO"),
                        result.getDouble("VL_VALOR"),
                        result.getString("DT_DATA"),
                        result.getBoolean("BL_ALCANCADO")
                );
                financeGoalList.add(financeGoalEntities);
            }

            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return financeGoalList;
    }

}
