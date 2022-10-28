package data.repository.entry;


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
            statement = connectionManager.GetConnection().prepareStatement("SELECT * FROM T_FINTECH_ENTRYINVESTMENT WHERE ID_INVESTMENT = ?")
            statement.setInt(1,id)
            ResultSet ResultSet= statement.executeQuery();

            while(resulteSet.next()){
                entryExpenseEntities = new EntryExpenseEntities(
                        resulteSet.getBoolean("EXP_RECEIVED"),
                        resulteSet.getString("EXP_RECEIVED_DATE"),
                        resulteSet.getDouble("EXP_VALOR"),
                        resulteSet.getString("EXP_DATE"),
                        resulteSet.getString("EXP_CATEGORY"),
                        resulteSet.getString("EXP_DESCRIPTION"),
                );
            }
            resulteSet.close();
        }

    }


    public int createEntryExpense(boolean received, String receivedDate, double valor,
                                                   String date, String category, String description) {
        int affectedRows = 0;
        PreparedStatement statement;
        String sql = "INSERT INTO T_ENTRY_EXPENSE (EXP_RECEIVED, EXP_RECEIVED_DATE, EXP_VALOR, EXP_DATE, EXP_CATEGORY, EXP_DESCRIPTION) VALUES ( ?,?,?,?,?,?,?)";

        try {
            statement = connectionManager.GetConnection().prepareStatement(sql);
            statement.setBoolean(1, received);
            statement.setString(2, receivedDate);
            statement.setDouble(3, valor);
            statement.setDouble(4, date);
            statement.setString(5, category);
            statement.setString(6, description);
            affectedRows = connectionManager.ExecuteCommand(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return affectedRows;
    }

    public int editEntryExpense(int id, boolean received, String receivedDate, String description, double valor,
                                                 String date, String category) {

        int affectedRows = 0;
        PreparedStatement statement;
        String sql = "UPDATE T_ENTRY_EXPENSE SET EXP_RECEIVED = ?, EXP_RECEIVED_DATE = ?, EXP_VALOR = ?, EXP_DATE = ?, EXP_CATEGORY = ?,EXP_DESCRIPTION = ? ";

        try {
            statement = connectionManager.GetConnection().prepareStatement(sql);
            statement.setBoolean(1, received);
            statement.setString(2, receivedDate);
            statement.setString(3, description);
            statement.setDouble(4, valor);
            statement.setString(5, date);
            statement.setString(6, category);

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return affectedRows;
    }

    public void removeEntryExpense(String description) {
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
                activities = new AccountEntities(
                        result.getBoolean("EXP_RECEIVED"),
                        result.getString("EXP_RECEIVED_DATE"),
                        result.getDouble("EXP_VALOR"),
                        result.getString("EXP_DATE"),
                        result.getString("EXP_CATEGORY"),
                        result.getString("EXP_DESCRIPTION"),
                );
                expenseList.add(activities);
            }

            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return expenseList;
    }

}
