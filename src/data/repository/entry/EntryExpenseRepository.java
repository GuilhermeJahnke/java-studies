package data.repository.entry;


import data.connection.ConnectionDAO;
import domain.entities.entry.EntryExpenseEntities;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EntryExpenseRepository {
    ConnectionDAO connectionManager = new ConnectionDAO();

    public EntryExpenseEntities findById(int id) {
        PreparedStatement statement = null;
        EntryExpenseEntities entryExpenseEntities = null;

        try {
            statement = connectionManager.GetConnection().prepareStatement("SELECT * FROM T_FIN_GASTO WHERE ID_INVESTMENT = ?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                entryExpenseEntities = new EntryExpenseEntities(
                        resultSet.getString("ST_GASTO"),
                        resultSet.getString("DT_GASTO"),
                        resultSet.getDouble("VL_VALOR"),
                        resultSet.getString("DT_CRIACAO"),
                        resultSet.getString("CT_GASTO"),
                        resultSet.getString("DS_GASTO")
                        );
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entryExpenseEntities;
    }


    public int createEntryExpense(EntryExpenseEntities EntryExpenseEntity) {
        int affectedRows = 0;
        PreparedStatement statement;
        String sql = "INSERT INTO T_ENTRY_EXPENSE (ST_GASTO, DT_GASTO, VL_VALOR, DT_CRIACAO, CT_GASTO, DS_GASTO) VALUES ( ?,?,?,?,?,?,?)";

        try {
            statement = connectionManager.GetConnection().prepareStatement(sql);
            statement.setString(1, EntryExpenseEntity.getReceived());
            statement.setString(2, EntryExpenseEntity.getReceivedDate());
            statement.setDouble(3, EntryExpenseEntity.getValor());
            statement.setString(4, EntryExpenseEntity.getDate());
            statement.setString(5, EntryExpenseEntity.getCategory());
            statement.setString(6, EntryExpenseEntity.getDescription());
            affectedRows = connectionManager.ExecuteCommand(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return affectedRows;
    }

    public int editEntryExpense(EntryExpenseEntities EntryExpenseEntity) {

        int affectedRows = 0;
        PreparedStatement statement;
        String sql = "UPDATE T_ENTRY_EXPENSE SET ST_GASTO = ?, DT_GASTO = ?, VL_VALOR = ?, DT_CRIACAO = ?, CT_GASTO = ?,DS_GASTO = ? ";

        try {
            statement = connectionManager.GetConnection().prepareStatement(sql);
            statement.setString(1, EntryExpenseEntity.getReceived());
            statement.setString(2, EntryExpenseEntity.getReceivedDate());
            statement.setDouble(3, EntryExpenseEntity.getValor());
            statement.setString(4,  EntryExpenseEntity.getDate());
            statement.setString(5, EntryExpenseEntity.getCategory());
            statement.setString(6, EntryExpenseEntity.getDescription());

            affectedRows = connectionManager.ExecuteCommand(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return affectedRows;
    }

    public int removeEntryExpense(int id) {
        int affectedRows = 0;
        PreparedStatement statement;
        String sql = "DELETE FROM T_ENTRY_EXPENSE WHERE ID_EXPENSE = ?";

        try {
            statement = connectionManager.GetConnection().prepareStatement(sql);
            statement.setInt(1, id);

            affectedRows = connectionManager.ExecuteCommand(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return affectedRows;
    }

    public ArrayList<EntryExpenseEntities> getAll() {
        ArrayList<EntryExpenseEntities> expenseList = new ArrayList<>();
        PreparedStatement statement = null;
        EntryExpenseEntities entryExpenseEntities = null;

        try {
            statement = connectionManager.GetConnection().prepareStatement("SELECT * FROM T_ENTRY_EXPENSE");
            ResultSet result = connectionManager.GetData(statement);

            while (result.next()) {
                entryExpenseEntities = new EntryExpenseEntities(
                        result.getString("ST_GASTO"),
                        result.getString("DT_GASTO"),
                        result.getDouble("VL_VALOR"),
                        result.getString("DT_CRIACAO"),
                        result.getString("CT_GASTO"),
                        result.getString("DS_GASTO")
                        );
                expenseList.add(entryExpenseEntities);
            }

            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return expenseList;
    }

}
