package domain.usecase.entry;

import data.repository.entry.EntryInvestmentRepository;
import domain.entities.entry.EntryInvestmentEntities;
import shared.Utils;

import java.util.ArrayList;

public class EntryInvestmentUseCase {
    private final EntryInvestmentRepository repository;

    private EntryInvestmentUseCase(){
        repository = new EntryInvestmentRepository();
    }

    private void verifyAllIsEmpty(Boolean rescued, String dueDate, Double amountIncome, Double valor,
                                  String date, String category, String description){

        if (Utils.isEmptyParams(rescued.toString())) {
            throw new IllegalArgumentException("O [received] não pode ser vazio, digite corretamente");
        }
        if (Utils.isEmptyParams(dueDate)) {
            throw new IllegalArgumentException("O [dueDate] não pode ser vazio, digite corretamente");
        }
        if (Utils.isEmptyParams(amountIncome.toString())) {
            throw new IllegalArgumentException("O [dueDate] não pode ser vazio, digite corretamente");
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

    public int create(boolean rescued, String dueDate, Double amountIncome, double valor,
                      String date, String category, String description){

        verifyAllIsEmpty(rescued, dueDate, amountIncome, valor, date, category, description);

        return repository.createEntryInvestment(rescued, dueDate, amountIncome, valor, date, category, description);
    }

    public int edit(Double amountIncome, boolean rescued, String dueDate, String description,
                    double valor, String date, String category){

        verifyAllIsEmpty(rescued, dueDate, amountIncome, valor, date, category, description);

        return repository.editEntryInvestment(amountIncome, rescued, dueDate, description, valor, date, category);
    }

    public void remove(int id) {
        if (Utils.isEmptyParams(String.valueOf(id))) {
            throw new IllegalArgumentException("O [description] não pode ser vazio, digite corretamente");
        }

        repository.removeEntryInvestment(id);
    }

    public ArrayList<EntryInvestmentEntities> getAll(){
        return repository.getAll();
    }

}
