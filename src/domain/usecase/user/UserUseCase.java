package domain.usecase.user;

import data.repository.user.UserRepository;
import domain.entities.account.AccountEntities;
import domain.entities.user.UserEntities;
import shared.Utils;

import java.util.ArrayList;

public class UserUseCase {
    private final UserRepository repository;

    public UserUseCase() {
        repository = new UserRepository();
    }

    private void verifyAllIsEmpty(String name, String email, String cpf, String password) {
        if (Utils.isEmptyParams(name)) {
            throw new IllegalArgumentException("O [Nome] não pode ser vazio, digite corretamente");
        }
        if (Utils.isEmptyParams(email)) {
            throw new IllegalArgumentException("O [Email] não pode ser vazio, digite corretamente");
        }
        if (Utils.isEmptyParams(cpf)) {
            throw new IllegalArgumentException("O [CPF] não pode ser vazio, digite corretamente");
        }
        if (Utils.isEmptyParams(password)) {
            throw new IllegalArgumentException("A [Senha] não pode ser vazia, digite corretamente");
        }
    }

    public UserEntities findById(int id) {
    	return repository.findById(id);
    }

    public UserEntities create(String name, String email, String cpf, String password) {
        verifyAllIsEmpty(name, email, cpf, password);
        
        UserEntities userInstance = new UserEntities(name, email, cpf, password);
        int isUserCreated = repository.create(userInstance);
        
        if(isUserCreated == 0) {
            throw new IllegalArgumentException("Não foi possível criar a conta");
        }

        return userInstance;
    }


    public int edit(String name, String email, String cpf, String password, int id) {
        verifyAllIsEmpty(name, email, cpf, password);

        UserEntities userInstance = new UserEntities(name, email, cpf, password, id);
        return repository.edit(userInstance);
    }

    public void remove(int id) {

        repository.remove(id);
    }

    public ArrayList<UserEntities> getAll() {
        return repository.getAll();
    }

    public UserEntities login(String email, String password) {
        if (Utils.isEmptyParams(email)) {
            throw new IllegalArgumentException("O [email] não pode ser vazio, digite corretamente");
        }
        if (Utils.isEmptyParams(password)) {
            throw new IllegalArgumentException("A [senha] não pode ser vazia, digite corretamente");
        }

        return repository.login(email, password);
    }
}
