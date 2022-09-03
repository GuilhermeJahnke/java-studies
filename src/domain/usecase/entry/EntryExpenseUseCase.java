package domain.usecase.entry;

import data.repository.entry.EntryExpenseRepository;
import domain.entities.entry.EntryExpenseEntities;
import shared.Utils;

import java.util.ArrayList;

public class EntryExpenseUseCase {
    private final EntryExpenseRepository repository;

    public EntryExpenseUseCase() {
        repository = new EntryExpenseRepository();
    }

    private void verifyAllIsEmpty(Boolean received, String receivedDate, Double valor, String date,
                                  String category, String description) {

        if (Utils.isEmptyParams(received.toString())) {
            throw new IllegalArgumentException("O [received] não pode ser vazio, digite corretamente");
        }
        if (Utils.isEmptyParams(receivedDate)) {
            throw new IllegalArgumentException("O [receivedDate] não pode ser vazio, digite corretamente");
        }
        if (Utils.isEmptyParams(valor.toString())) {
            throw new IllegalArgumentException("O [valor] não pode ser vazio, digite corretamente");
        }
        if (Utils.isEmptyParams(date)) {
            throw new IllegalArgumentException("O [date] não pode ser vazio, digite corretamente");
        }
        if (Utils.isEmptyParams(category)) {
            throw new IllegalArgumentException("O [category] não pode ser vazio, digite corretamente");
        }
        if (Utils.isEmptyParams(description)) {
            throw new IllegalArgumentException("O [description] não pode ser vazio, digite corretamente");
        }

    }


    public EntryExpenseEntities create(boolean received, String receivedDate, double valor, String date,
                                       String category, String description) {

        verifyAllIsEmpty(received, receivedDate, valor, date, category, description);

        return repository.createEntryExpense(received, receivedDate, valor, date, category, description);
    }

    public EntryExpenseEntities edit(boolean received, String receivedDate, String description, double valor,
                                     String date, String category) {

        verifyAllIsEmpty(received, receivedDate, valor, date, category, description);

        return repository.editEntryExpense(received, receivedDate, description, valor, date, category);
    }

    public void remove(String description) {
        if (Utils.isEmptyParams(description)) {
            throw new IllegalArgumentException("O [description] não pode ser vazio, digite corretamente");
        }

        repository.removeEntryExpense(description);
    }

    public ArrayList<EntryExpenseEntities> getAll() {
        return repository.getAll();
    }

}
