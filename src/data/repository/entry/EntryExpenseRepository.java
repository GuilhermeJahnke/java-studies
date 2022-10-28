package data.repository.entry;


import domain.entities.entry.EntryExpenseEntities;

import java.util.ArrayList;

public class EntryExpenseRepository {
    private final ArrayList<EntryExpenseEntities> mockDataBase = new ArrayList<>();

    public EntryExpenseEntities findByDescription(String description) {
        for (EntryExpenseEntities entryExpenseEntities : mockDataBase) {
            if (entryExpenseEntities.getDescription().equals(description)) return entryExpenseEntities;
        }

        throw new IllegalArgumentException("Nenhum lançamento de despesa encontrado com esta descrição");
    }


    public EntryExpenseEntities createEntryExpense(boolean received, String receivedDate, double valor,
                                                   String date, String category, String description) {

        EntryExpenseEntities newEntryExpense = new EntryExpenseEntities(received, receivedDate, valor,
                date, category, description);

        mockDataBase.add(newEntryExpense);

        return newEntryExpense;
    }

    public EntryExpenseEntities editEntryExpense(boolean received, String receivedDate, String description, double valor,
                                                 String date, String category) {
        EntryExpenseEntities expenseEdit = findByDescription(description);

        expenseEdit.setValor(valor);
        expenseEdit.setDate(date);
        expenseEdit.setCategory(category);
        expenseEdit.setDescription(description);
        expenseEdit.setReceived(received);
        expenseEdit.setReceivedDate(receivedDate);

        return expenseEdit;
    }

    public void removeEntryExpense(String description) {
        mockDataBase.remove(findByDescription(description));
    }

    public ArrayList<EntryExpenseEntities> getAll() {
        return mockDataBase;
    }

}
