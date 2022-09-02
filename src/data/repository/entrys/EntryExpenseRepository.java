package data.repository.entrys;


import domain.entities.account.AccountEntities;
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

    public EntryExpenseEntities editEntryExpense(boolean received, String date, String description) {
        EntryExpenseEntities expenseEdit = findByDescription(description);

        expenseEdit.setReceived(received);
        expenseEdit.setReceivedDate(date);

        return expenseEdit;
    }

    public void removeEntryExpense(String description) {
        mockDataBase.remove(findByDescription(description));
    }

    public ArrayList<EntryExpenseEntities> getAll() {
        return mockDataBase;
    }

}
