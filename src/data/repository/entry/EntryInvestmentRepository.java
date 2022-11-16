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
            statement = connectionManager.GetConnection().prepareStatement("SELECT * FROM T_FIN_INVESTIMENTO WHERE ID_INVESTIMENTO = ?");
            statement.setInt(1,id);
            ResultSet resultSet= statement.executeQuery();

            while(resultSet.next()){
                entryInvestment = new EntryInvestmentEntities(
                        resultSet.getBoolean("BL_RESGATADO"),
                        resultSet.getString("DT_DATA_RESGATADO"),
                        resultSet.getDouble("VL_VALOR_ESPERADO"),
                        resultSet.getDouble("VL_VALOR"),
                        resultSet.getString("DT_DATA"),
                        resultSet.getString("DS_DESCRICAO"),
                        resultSet.getString("DS_CATEGORY")
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
        String sql = "INSERT INTO T_FIN_INVESTIMENTO (BL_RESGATADO, DT_DATA_RESGATADO, VL_VALOR_ESPERADO, VL_VALOR, DT_DATA, DS_DESCRICAO, DS_CATEGORY) VALUES ( ?,?,?,?,?,?,?)";

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
        String sql = "UPDATE T_FIN_INVESTIMENTO SET BL_RESGATADO = ?, DT_DATA_RESGATADO = ?, VL_VALOR_ESPERADO = ?, VL_VALOR = ?, DT_DATA = ?, DS_DESCRICAO = ?, DS_CATEGORY = ?";
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

    public int removeEntryInvestment(int id) {
        int affectedRows = 0;
        PreparedStatement statement;
        String sql = "DELETE FROM T_FIN_INVESTIMENTO WHERE ID_INVESTIMENTO = ?";

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
            statement = connectionManager.GetConnection().prepareStatement("SELECT * FROM T_FIN_INVESTIMENTO");
            ResultSet result = connectionManager.GetData(statement);

            while (result.next()) {
                investment = new EntryInvestmentEntities(
                        result.getBoolean("BL_RESGATADO"),
                        result.getString("DT_DATA_RESGATADO"),
                        result.getDouble("VL_VALOR_ESPERADO"),
                        result.getDouble("VL_VALOR"),
                        result.getString("DT_DATA"),
                        result.getString("DS_DESCRICAO"),
                        result.getString("DS_CATEGORY")
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
