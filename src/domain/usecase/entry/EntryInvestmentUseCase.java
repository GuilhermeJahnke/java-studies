package domain.usecase.entry;

import data.repository.entrys.EntryInvestmentRepository;
import domain.entities.entry.EntryInvestmentEntities;

import java.util.ArrayList;

public class EntryInvestmentUseCase {
    private final EntryInvestmentRepository repository;

    private EntryInvestmentUseCase(){
        repository = new EntryInvestmentRepository();
    }

    public EntryInvestmentEntities create(boolean rescued, String dueDate, Double amountIncome, double valor,
                                          String date, String category, String description){

        return repository.createEntryInvestment(rescued, dueDate, amountIncome, valor, date, category, description);
    }

    public EntryInvestmentEntities edit(Double amountIncome, boolean rescued, String dueDate, String description,
                                        double valor, String date, String category){

        return repository.editEntryInvestment(amountIncome, rescued, dueDate, description, valor, date, category);
    }

    public void remove(String description) {
        repository.removeEntryInvestment(description);
    }

    public ArrayList<EntryInvestmentEntities> getAll(){
        return repository.getAll();
    }

}
