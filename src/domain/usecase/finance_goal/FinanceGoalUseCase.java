package domain.usecase.finance_goal;

import data.repository.finance_goal.FinanceGoalRepository;
import domain.entities.finance_goal.FinanceGoalEntities;
import shared.Utils;

import java.util.ArrayList;

public class FinanceGoalUseCase {

    private final FinanceGoalRepository repository;


    public FinanceGoalUseCase() {
        repository = new FinanceGoalRepository();
    }

    private void verifyAllIsEmpty(String name, String description, Double value, String date,
                                  Boolean achieved) {

        if (Utils.isEmptyParams(name)) {
            throw new IllegalArgumentException("O [name] não pode ser vazio, digite corretamente");
        }
        if (Utils.isEmptyParams(description)) {
            throw new IllegalArgumentException("O [description] não pode ser vazio, digite corretamente");
        }
        if (Utils.isEmptyParams(value.toString())) {
            throw new IllegalArgumentException("O [value] não pode ser vazio, digite corretamente");
        }
        if (Utils.isEmptyParams(date)) {
            throw new IllegalArgumentException("O [date] não pode ser vazio, digite corretamente");
        }
        if (Utils.isEmptyParams(String.valueOf(achieved))) {
            throw new IllegalArgumentException("O [achieved] não pode ser vazio, digite corretamente");
        }
    }

    public FinanceGoalEntities create(String name, String description, Double value, String date,
                      boolean achieved) {
        verifyAllIsEmpty(name, description, value, date, achieved);


        FinanceGoalEntities financeGoalInstance = new FinanceGoalEntities( name, description, value, date, achieved);


        int isFinanceGoalCreated =  repository.createFinanceGoal(financeGoalInstance);

        if(isFinanceGoalCreated == 0) {
            throw new IllegalArgumentException("Não foi possível criar o objetivo financeiro");
        }
        return financeGoalInstance;
    }

    public int edit(String name, String description, Double value, String date,
                    boolean achieved) {

        verifyAllIsEmpty(name, description, value, date, achieved);

        return repository.editFinanceGoal(name, description, value, date, achieved);
    }

    public void remove(String description) {
        if (Utils.isEmptyParams(description)) {
            throw new IllegalArgumentException("O [description] não pode ser vazio, digite corretamente");
        }

        repository.removeFinanceGoal(1);
    }

    public ArrayList<FinanceGoalEntities> getAll() {
        return repository.getAll();
    }

}
