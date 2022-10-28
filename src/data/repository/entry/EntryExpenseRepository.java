package data.repository.entry;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.entities.entry.EntryExpenseEntities;
import data.connection.ConnectionDAO;

import java.util.ArrayList;

public class EntryExpenseRepository {
    ConnectionDAO connectionManager = new ConnectionDAO();

    public EntryExpenseEntities findByDescription(String description) {

        throw new IllegalArgumentException("Nenhum lançamento de despesa encontrado com esta descrição");
    }

    public int createEntryExpense(EntryExpenseEntities EntryExpenseEntity)   {
        int affectedRows = 0;
        PreparedStatement statement;

        // TO DO: Change SQL with the correct table and columns names
        String sql = "NSERT INTO T_FIN_GASTO(RECEIVED, RECEIVEDDATE, VALOR, DATE, CATEGORY, DESCRIPTION) VALUES (?, ?, ?, ?, ?, ?)";

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

        // TO DO: Change SQL with the correct table and columns names
        String sql = "UPDATE T_EXPENSE_RECEIPT SET EXPENSE_RECEIVED, EXPENSE_RECEIVED_DATE, EXPENSE_VALOR, EXPENSE_DATE, EXPENSE_CATEGORY, EXPENSE_DESCRIPTION = ?, balance = ?, ?, ?, ?, ?, ?";

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
        
        // TO DO: Change SQL with the correct table and columns names
        String sql = "DELETE FROM T_EXPENSE_RECEIPT WHERE ID_ENTRY = ?";

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
        ArrayList<EntryExpenseEntities> activitiesList = new ArrayList<>();
        PreparedStatement statement = null;
		EntryExpenseEntities activities = null;

        try {
            // TO DO: Change SQL with the correct table and columns names
            statement = connectionManager.GetConnection().prepareStatement("SELECT * FROM T_EXPENSE_RECEIPT");
            ResultSet result = connectionManager.GetData(statement);

            while (result.next()) {
                activities = new EntryExpenseEntities(
                    result.getBoolean("received"),
                    result.getString("receivedDate"),
                    result.getDouble("valor"),
                    result.getString("date"),
                    result.getString("category"),
                    result.getString("description")
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
