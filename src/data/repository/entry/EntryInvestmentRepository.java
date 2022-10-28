package data.repository.entry;


import domain.entities.entry.EntryInvestmentEntities;
import data.connection.ConnectionDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EntryInvestmentRepository {
    ConnectionDAO connectionManager = new ConnectionDAO();

    public EntryInvestmentEntities findByDId(int id) {
        PreparedStatement statement = null;
        EntryInvestmentEntities entryInvestment = null;

        try {
            statement = connectionManager.GetConnection().prepareStatement("SELECT * FROM T_ENTRY_INVESTMENT WHERE ID_INVESTMENT = ?");
            statement.setInt(1,id);
            ResultSet resultSet= statement.executeQuery();

            while(resultSet.next()){
                entryInvestment = new EntryInvestmentEntities(
                        resultSet.getBoolean("INV_RESCUED"),
                        resultSet.getString("INV_DUE_DATE"),
                        resultSet.getDouble("INV_AMOUNT_INCOME"),
                        resultSet.getDouble("INV_VALOR"),
                        resultSet.getString("ID_INVESTMENT"),
                        resultSet.getString("INV_DATE"),
                        resultSet.getString("INV_CATEGORY")
                );
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entryInvestment;
    }


    public int createEntryInvestment(boolean rescued, String dueDate, Double amountIncome, double valor,
                                     String date, String category, String description) {
        int affectedRows = 0;
        PreparedStatement statement;
        String sql = "INSERT INTO T_ENTRY_INVESTMENT (INV_RESCUED, INV_DUE_DATE, INV_AMOUNT_INCOME, INV_DESCRIPTION, INV_VALOR, INV_DATE, INV_CATEGORY) VALUES ( ?,?,?,?,?,?,?)";

        try {
            statement = connectionManager.GetConnection().prepareStatement(sql);
            statement.setBoolean(1, rescued);
            statement.setString(2, dueDate);
            statement.setDouble(3, amountIncome);
            statement.setDouble(4, valor);
            statement.setString(5, date);
            statement.setString(6, category);
            statement.setString(7, description);
            affectedRows = connectionManager.ExecuteCommand(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return affectedRows;

    }

    public int editEntryInvestment(Double amountIncome, boolean rescued, String dueDate, String description,
                                                       double valor, String date, String category) {

        int affectedRows = 0;
        PreparedStatement statement;
        String sql = "UPDATE T_ENTRY_INVESTMENT SET INV_RESCUED = ?, INV_DUE_DATE = ?, INV_AMOUNT_INCOME = ?, INV_VALOR = ?, ID_INVESTMENT = ?, INV_DATE = ?, INV_CATEGORY = ?";
        try {
            statement = connectionManager.GetConnection().prepareStatement(sql);
            statement.setDouble(1, valor);
            statement.setString(2, date);
            statement.setString(3,category);
            statement.setString(4, description);
            statement.setDouble(5, amountIncome);
            statement.setBoolean(6, rescued);
            statement.setString(7, dueDate);

            affectedRows = connectionManager.ExecuteCommand(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return affectedRows;
    }

    public int removeEntryInvestment(int id) {
        int affectedRows = 0;
        PreparedStatement statement;
        String sql = "DELETE FROM T_ENTRY_INVESTMENT WHERE ID_INVESTMENT = ?";

        try {
            statement = connectionManager.GetConnection().prepareStatement(sql);
            statement.setInt(1, id);

            affectedRows = connectionManager.ExecuteCommand(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return affectedRows;
    }

    public ArrayList<EntryInvestmentEntities> getAll() {
        ArrayList<EntryInvestmentEntities> investmentList = new ArrayList<>();
        PreparedStatement statement;
        EntryInvestmentEntities investment = null;

        try {
            statement = connectionManager.GetConnection().prepareStatement("SELECT * FROM T_ENTRY_INVESTMENT");
            ResultSet result = connectionManager.GetData(statement);

            while (result.next()) {
                investment = new EntryInvestmentEntities(
                        result.getBoolean("INV_RESCUED"),
                        result.getString("INV_DUE_DATE"),
                        result.getDouble("INV_AMOUNT_INCOME"),
                        result.getDouble("INV_VALOR"),
                        result.getString("ID_INVESTMENT"),
                        result.getString("INV_DATE"),
                        result.getString("INV_CATEGORY")
                );
                investmentList.add(investment);
            }

            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return investmentList;
    }
}
