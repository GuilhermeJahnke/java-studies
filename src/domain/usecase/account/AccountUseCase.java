package domain.usecase.account;

import data.repository.account.AccountRepository;
import domain.entities.account.AccountEntities;

import java.util.ArrayList;

public class AccountUseCase {
    private final AccountRepository repository;

    public AccountUseCase() {
        repository = new AccountRepository();
    }

    public AccountEntities create(String name, double balance) {
        return repository.createAccount(name, balance);
    }

    public AccountEntities edit(String name, double balance) {
        return repository.editAccount(name, balance);
    }

    public void remove(String name) {
        repository.removeAccount(name);
    }

    public ArrayList<AccountEntities> getAll() {
        return repository.getAll();
    }

}