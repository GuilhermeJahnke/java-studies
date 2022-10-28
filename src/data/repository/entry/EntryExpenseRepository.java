package data.repository.entry;


import data.connection.ConnectionDAO;
import domain.entities.entry.EntryExpenseEntities;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EntryExpenseRepository {
    ConnectionDAO connectionManager = new ConnectionDAO();

    private final ArrayList<EntryExpenseEntities> mockDataBase = new ArrayList<>();

    public EntryExpenseEntities findById(int id) {
        PreparedStatement statement = null;
        EntryExpenseEntities entryExpenseEntities = null;

        try {
            statement = connectionManager.GetConnection().prepareStatement("SELECT * FROM T_FINTECH_ENTRYINVESTMENT WHERE ID_INVESTMENT = ?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                entryExpenseEntities = new EntryExpenseEntities(
                        resultSet.getBoolean("EXP_RECEIVED"),
                        resultSet.getString("EXP_RECEIVED_DATE"),
                        resultSet.getDouble("EXP_VALOR"),
                        resultSet.getString("EXP_DATE"),
                        resultSet.getString("EXP_CATEGORY"),
                        resultSet.getString("EXP_DESCRIPTION")
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
        String sql = "INSERT INTO T_ENTRY_EXPENSE (EXP_RECEIVED, EXP_RECEIVED_DATE, EXP_VALOR, EXP_DATE, EXP_CATEGORY, EXP_DESCRIPTION) VALUES ( ?,?,?,?,?,?,?)";

        try {
            statement = connectionManager.GetConnection().prepareStatement(sql);
            statement.setBoolean(1, EntryExpenseEntity.getReceived());
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
        String sql = "UPDATE T_ENTRY_EXPENSE SET EXP_RECEIVED = ?, EXP_RECEIVED_DATE = ?, EXP_VALOR = ?, EXP_DATE = ?, EXP_CATEGORY = ?,EXP_DESCRIPTION = ? ";

        try {
            statement = connectionManager.GetConnection().prepareStatement(sql);
            statement.setBoolean(1, EntryExpenseEntity.getReceived());
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
                        result.getBoolean("EXP_RECEIVED"),
                        result.getString("EXP_RECEIVED_DATE"),
                        result.getDouble("EXP_VALOR"),
                        result.getString("EXP_DATE"),
                        result.getString("EXP_CATEGORY"),
                        result.getString("EXP_DESCRIPTION")
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
