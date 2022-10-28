package data.repository.entry;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import domain.entities.entry.EntryReceiptEntities;
import data.connection.ConnectionDAO;

import java.util.ArrayList;

public class EntryReceiptRepository {
    ConnectionDAO connectionManager = new ConnectionDAO();
    
    public EntryReceiptEntities findById(int id) {
        PreparedStatement statement = null;
		EntryReceiptEntities activities = null;

        try {
            statement = connectionManager.GetConnection().prepareStatement("SELECT * FROM T_ENTRY_RECEIPT WHERE ID_RECEIPT = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                activities = new EntryReceiptEntities(
                    resultSet.getBoolean("REC_RECEIVED"),
                    resultSet.getString("REC_RECEIVED_DATE"),
                    resultSet.getDouble("REC_VALOR"),
                    resultSet.getString("REC_DATE"),
                    resultSet.getString("REC_CATEGORY"),
                    resultSet.getString("REC_DESCRIPITION")
                );
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return activities;

    }    
    
    public int createEntryReceipt(boolean REC_RECEIVED, Date REC_RECEIVED_DATE, double REC_VALOR, Date REC_DATE, String REC_CATEGORY,
    String REC_DESCRIPITION) {
        
        int affectedRows = 0;
        PreparedStatement statement;
        String sql = "INSERT INTO T_ENTRY_RECEIPT (REC_RECEIVED, REC_RECIVED_DATE, REC_VALOR, REC_DATE, REC_CATEGORY, REC_DESCRIPTION) VALUES ( ?, ?, ?, ?, ?, ?)";

        try {
            statement = connectionManager.GetConnection().prepareStatement(sql);
            statement.setBoolean(1, REC_RECEIVED);
            statement.setDate(2, REC_RECEIVED_DATE);
            statement.setDouble(3, REC_VALOR);
            statement.setDate(4, REC_DATE);
            statement.setString(5, REC_CATEGORY);
            statement.setString(6, REC_DESCRIPITION);

            affectedRows = connectionManager.ExecuteCommand(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }         

        return affectedRows;
    }

    public int editEntryReceipt(boolean REC_RECEIVED, Date REC_RECEIVED_DATE, String REC_DESCRIPITION,
    double REC_VALOR, Date REC_DATE, String REC_CATEGORY) {
        int affectedRows = 0;
        PreparedStatement statement;
        String sql = "UPDATE T_ENTREY_RECEPT SET REC_RECEIVED, REC_RECIVED_DATE, REC_VALOR, REC_DATE, REC_CATEGORY, REC_DESCRIPTION = ?, balance = ?, ?, ?, ?, ?, ?";

        try {
            statement = connectionManager.GetConnection().prepareStatement(sql);
            statement.setBoolean(1, REC_RECEIVED);
            statement.setDate(2, REC_RECEIVED_DATE);
            statement.setDouble(3, REC_VALOR);
            statement.setDate(4, REC_DATE);
            statement.setString(5, REC_CATEGORY);
            statement.setString(6, REC_DESCRIPITION);

            affectedRows = connectionManager.ExecuteCommand(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return affectedRows;
    }

    public int removeEntryReceipt(int id) {
        int affectedRows = 0;
		PreparedStatement statement;
        String sql = "DELETE FROM T_ENTRY_RECEIPT WHERE ID_RECEIPT = ?";

        try {
            statement = connectionManager.GetConnection().prepareStatement(sql);
            statement.setInt(1, id);

            affectedRows = connectionManager.ExecuteCommand(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return affectedRows;
    }

    public ArrayList<EntryReceiptEntities> getAll() {
        ArrayList<EntryReceiptEntities> activitiesList = new ArrayList<>();
        PreparedStatement statement = null;
		EntryReceiptEntities activities = null;

        try {
            statement = connectionManager.GetConnection().prepareStatement("SELECT * FROM T_ENTRY_RECEIPT");
            ResultSet result = connectionManager.GetData(statement);

            while (result.next()) {
                activities = new EntryReceiptEntities(
                    result.getBoolean("REC_RECEIVED"),
                    result.getString("REC_RECEIVED_DATE"),
                    result.getDouble("REC_VALOR"),
                    result.getString("REC_DATE"),
                    result.getString("REC_CATEGORY"),
                    result.getString("REC_DESCRIPITION")
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
