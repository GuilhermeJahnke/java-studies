package domain.usecase.user;

import data.repository.user.UserRepository;
import domain.entities.User.UserEntities;

import java.util.ArrayList;

public class UserUseCase {
    private final UserRepository repository;

    public UserUseCase(){
        repository = new UserRepository();
    }

    public UserEntities create(String name, String email, String cpf, String password){
        return repository.createUser(name, email, cpf, password);
    }

    public UserEntities edit(String name, String email, String cpf, String password){
        return repository.editUser(name, email, cpf, password);
    }

    public void remove(String cpf){
        repository.removeUser(cpf);
    }

    public ArrayList<UserEntities> getAll(){
        return repository.getAll();
    }


}
