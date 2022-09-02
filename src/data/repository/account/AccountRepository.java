package data.repository.account;

import domain.entities.account.AccountEntities;

import java.util.ArrayList;

public class AccountRepository {
    private final ArrayList<AccountEntities> mockDataBase = new ArrayList<>();

    public AccountEntities findByName(String name) {
        for (AccountEntities accountEntity : mockDataBase) {
            if (accountEntity.getName().equals(name)) return accountEntity;
        }

        throw new IllegalArgumentException("Nenhuma conta encontrada com este nome");
    }


    public AccountEntities createAccount(String name, double balance) {
        AccountEntities newAccount = new AccountEntities(name, balance);

        mockDataBase.add(newAccount);

        return newAccount;
    }

    public AccountEntities editAccount(String name, double balance) {
        AccountEntities accountEdit = findByName(name);

        accountEdit.setName(name);
        accountEdit.setBalance(balance);

        return accountEdit;
    }

    public void removeAccount(String name) {
        mockDataBase.remove(findByName(name));
    }

    public ArrayList<AccountEntities> getAll() {
        return mockDataBase;
    }
}
