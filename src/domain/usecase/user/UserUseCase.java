package domain.usecase.user;

import data.repository.user.UserRepository;
import domain.entities.User.UserEntities;
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


    public UserEntities create(String name, String email, String cpf, String password) {
        verifyAllIsEmpty(name, email, cpf, password);

        return repository.createUser(name, email, cpf, password);
    }


    public UserEntities edit(String name, String email, String cpf, String password) {
        verifyAllIsEmpty(name, email, cpf, password);

        return repository.editUser(name, email, cpf, password);
    }

    public void remove(String cpf) {
        if (Utils.isEmptyParams(cpf)) {
            throw new IllegalArgumentException("O [CPF] não pode ser vazio, digite corretamente");
        }

        repository.removeUser(cpf);
    }

    public ArrayList<UserEntities> getAll() {
        return repository.getAll();
    }

    public UserEntities login(String cpf, String password) {
        if (Utils.isEmptyParams(cpf)) {
            throw new IllegalArgumentException("O [CPF] não pode ser vazio, digite corretamente");
        }
        if (Utils.isEmptyParams(password)) {
            throw new IllegalArgumentException("A [senha] não pode ser vazia, digite corretamente");
        }

        return repository.login(cpf, password);
    }
}
