package domain.usecase.entry;

import data.repository.entrys.EntryExpenseRepository;
import domain.entities.entry.EntryExpenseEntities;

import java.util.ArrayList;

public class EntryExpenseUseCase {
    private final EntryExpenseRepository repository;

    public EntryExpenseUseCase() {
        repository = new EntryExpenseRepository();
    }

    public EntryExpenseEntities create(boolean received, String receivedDate, double valor, String date,
                                       String category, String description) {

        return repository.createEntryExpense(received, receivedDate, valor, date, category, description);
    }

    public EntryExpenseEntities edit(boolean received, String date, String description) {
        return repository.editEntryExpense(received, date, description);
    }

    public void remove(String description) {
        repository.removeEntryExpense(description);
    }

    public ArrayList<EntryExpenseEntities> getAll() {
        return repository.getAll();
    }

}
