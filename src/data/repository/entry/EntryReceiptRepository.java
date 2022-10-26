package data.repository.entry;

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
            statement = connectionManager.GetConnection().prepareStatement("SELECT * FROM T_ENTRY_RECEIPT WHERE ID_ENTRY = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                activities = new EntryReceiptEntities(
                    resultSet.getBoolean("received"),
                    resultSet.getString("receivedDate"),
                    resultSet.getDouble("valor"),
                    resultSet.getString("date"),
                    resultSet.getString("category"),
                    resultSet.getString("description")
                );
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return activities;

    }    
    
    public int createEntryReceipt(boolean received, String receivedDate, double valor, String date, String category,
    String description) {
        
        int affectedRows = 0;
        PreparedStatement statement;
        String sql = "INSERT INTO T_ENTRY_RECEIPT (RECEBPT_RECEIVED, RECEBPT_RECIVED_DATE, RECEBPT_VALOR, RECEBPT_DATE, RECEBPT_CATEGORY, RECEBPT_DESCRIPTION) VALUES ( ?, ?, ?, ?, ?, ?)";

        try {
            statement = connectionManager.GetConnection().prepareStatement(sql);
            statement.setBoolean(1, received);
            statement.setString(2, receivedDate);
            statement.setDouble(3, valor);
            statement.setString(4, date);
            statement.setString(5, category);
            statement.setString(6, description);

            affectedRows = connectionManager.ExecuteCommand(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }         

        return affectedRows;
    }

    public int editEntryReceipt(boolean received, String receivedDate, String description,
    double valor, String date, String category) {
        int affectedRows = 0;
        PreparedStatement statement;
        String sql = "UPDATE T_ENTREY_RECEPT SET RECEBPT_RECEIVED, RECEBPT_RECIVED_DATE, RECEBPT_VALOR, RECEBPT_DATE, RECEBPT_CATEGORY, RECEBPT_DESCRIPTION = ?, balance = ?, ?, ?, ?, ?, ?";

        try {
            statement = connectionManager.GetConnection().prepareStatement(sql);
            statement.setBoolean(1, received);
            statement.setString(2, receivedDate);
            statement.setDouble(3, valor);
            statement.setString(4, date);
            statement.setString(5, category);
            statement.setString(6, description);

            affectedRows = connectionManager.ExecuteCommand(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return affectedRows;
    }

    public int removeEntryReceipt(int id) {
        int affectedRows = 0;
		PreparedStatement statement;
        String sql = "DELETE FROM T_ENTRY_RECEIPT WHERE ID_ENTRY = ?";

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
