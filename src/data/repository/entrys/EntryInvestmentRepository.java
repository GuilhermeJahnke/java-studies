package data.repository.entrys;


import domain.entities.entry.EntryInvestmentEntities;

import java.util.ArrayList;

public class EntryInvestmentRepository {
    private final ArrayList<EntryInvestmentEntities> mockDataBase = new ArrayList<>();

    public EntryInvestmentEntities findByDescription(String description) {
        for (EntryInvestmentEntities entryInvestmentEntities : mockDataBase) {
            if (entryInvestmentEntities.getDescription().equals(description)) return entryInvestmentEntities;
        }

        throw new IllegalArgumentException("Nenhum lançamento de investimento encontrado com esta descrição");
    }


    public EntryInvestmentEntities createEntryInvestment(boolean rescued, String dueDate, Double amountIncome, double valor,
                                                         String date, String category, String description) {

        EntryInvestmentEntities newEntrInvestment = new EntryInvestmentEntities(rescued, dueDate, amountIncome, valor,
                date, category, description);

        mockDataBase.add(newEntrInvestment);

        return newEntrInvestment;
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
        return mockDataBase;
    }
}
