package domain.usecase.account;

import data.repository.account.AccountRepository;
import domain.entities.account.AccountEntities;

import java.util.ArrayList;

public class AccountUseCase {
    private final AccountRepository accountRepository;

    public AccountUseCase() {
        accountRepository = new AccountRepository();
    }

    public AccountEntities create(String name, double balance) {
        return accountRepository.createAccount(name, balance);
    }

    public AccountEntities edit(String name, double balance) {
        return accountRepository.editAccount(name, balance);
    }

    public void remove(String name) {
        accountRepository.removeAccount(name);
    }

    public ArrayList<AccountEntities> getAll() {
        return accountRepository.getAll();
    }

}