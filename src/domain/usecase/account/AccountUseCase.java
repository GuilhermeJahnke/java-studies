package domain.usecase.account;

import data.repository.account.AccountRepository;
import domain.entities.account.AccountEntities;
import shared.Utils;

import java.util.ArrayList;

public class AccountUseCase {
    private final AccountRepository repository;

    public AccountUseCase() {
        repository = new AccountRepository();
    }

    private void verifyAllIsEmpty(String name, Double balance){
        if (Utils.isEmptyParams(name)) {
            throw new IllegalArgumentException("O [name] não pode ser vazio, digite corretamente");
        }
        if (Utils.isEmptyParams(balance.toString())) {
            throw new IllegalArgumentException("O [balance] não pode ser vazio, digite corretamente");
        }
    }

    public int create(String name, double balance) {
        verifyAllIsEmpty(name, balance);

        return repository.createAccount(name, balance);
    }

    public int edit(String name, double balance) {
        verifyAllIsEmpty(name, balance);

        return repository.editAccount(name, balance);
    }

    public void remove(String name) {
        if (Utils.isEmptyParams(name)) {
            throw new IllegalArgumentException("O [name] não pode ser vazio, digite corretamente");
        }

        repository.removeAccount(1);
    }

    public ArrayList<AccountEntities> getAll() {
        return repository.getAll();
    }

}