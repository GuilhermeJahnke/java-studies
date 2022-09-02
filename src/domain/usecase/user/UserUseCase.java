package domain.usecase.user;

import data.repository.user.UserRepository;
import domain.entities.User.UserEntities;

import java.util.ArrayList;

public class UserUseCase {
    private final UserRepository userRepository;

    public UserUseCase(){
        userRepository = new UserRepository();
    }

    public UserEntities create(String name, String email, String cpf, String password){
        return userRepository.createUser(name, email, cpf, password);
    }

    public UserEntities edit(String name, String email, String cpf, String password){
        return userRepository.editUser(name, email, cpf, password);
    }

    public void remove(String cpf){
        userRepository.removeUser(cpf);
    }

    public ArrayList<UserEntities> getAll(){
        return userRepository.getAll();
    }


}
