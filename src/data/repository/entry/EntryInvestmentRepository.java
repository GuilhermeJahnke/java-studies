package data.repository.entry;


import domain.entities.entry.EntryInvestmentEntities;
import data.connection.ConnectionDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EntryInvestmentRepository {
    ConnectionDAO connectionManager = new ConnectionDAO();

    public EntryInvestmentEntities findByDescription(int id) {
        PrepareStatement statement = null;
        EntryInvestmentEntities entryinv = null;

        try {
            statement = connectionManager.GetConnection().prepareStatement("SELECT * FROM T_FINTECH_ENTRYINVESTMENT WHERE ID_INVESTMENT = ?")
            statement.setInt(1,id)
            ResultSet ResultSet= statement.executeQuery();

            while(resulteSet.next()){
                entryinv = new EntryInvestmentEntities(
                    resulteSet.getBoolean("INV_RESCUED"),
                    resulteSet.getString("INV_DUE_DATE"),
                    resulteSet.getDouble("INV_AMOUNT_INCOME"),
                    resulteSet.getString("INV_DESCRIPTION"),
                    resulteSet.getDouble("INV_VALOR"),
                    resulteSet.getString("ID_INVESTMENT"),
                    resulteSet.getDate("INV_DATE"),
                    resulteSet.getString("INV_CATEGORY")
                );
            }
            resulteSet.close();
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }


    public int createEntryInvestment(boolean rescued, String dueDate, Double amountIncome, double valor,
                                                         String date, String category, String description) {
        int affectedRows = 0;    
        PreparedStatement statement;  
        String sql = "INSERT INTO T_FINTECH_ENTRYINVESTMENT (RESCUED, DUEDATE, AMOUNTINCOME, VALOR, DATE, CATEGORY, DESCRIPTION) VALUES ( ?,?,?,?,?,?,?)";     
        
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

    public EntryInvestmentEntities editEntryInvestment(Double amountIncome, boolean rescued, String dueDate, String description,
                                                       double valor, String date, String category) {

        EntryInvestmentEntities investmentEdit = findByDescription(description);

        investmentEdit.setValor(valor);
        investmentEdit.setDate(date);
        investmentEdit.setCategory(category);
        investmentEdit.setDescription(description);
        investmentEdit.setAmountIncome(amountIncome);
        investmentEdit.setRescued(rescued);
        investmentEdit.setDueDate(dueDate);

        return investmentEdit;
    }

    public void removeEntryInvestment(String description) {
        mockDataBase.remove(findByDescription(description));
    }

    public ArrayList<EntryInvestmentEntities> getAll() {
        ArrayList<EntryInvestmentEntities> investmentList = new ArrayList<>();
        PrepareStatement statement;
        EntryInvestmentEntities investment = null

        try {
            statement = connectionManager.GetConnection().prepareStatement("SELECT * FROM T_FINTECH_ENTRYINVESTMENT");
            ResultSet result = connectionManager.GetData(statement);

            while (result.next()) {
                investment = new EntryInvestmentEntities(
                    result.getValor("valor");
                    result.getDate("date");
                    result.getCategory("category");
                    result.getDescription("description");
                    result.getAmountIncome("amountIncome");
                    result.getRescued("rescued");
                    result.getDueDate("dueDate");
                );
                investmentList.add(activities);
            }

            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return investmentList;
    }
}
