package data.repository.user;


import domain.entities.user.UserEntities;

import java.util.ArrayList;
import java.util.Objects;

public class UserRepository {
    private final ArrayList<UserEntities> mockDataBase = new ArrayList<>();

    public UserEntities findByCpf(String cpf){
        for (UserEntities userEntity : mockDataBase) {
            if (userEntity.getCpf().equals(cpf)) return userEntity;
        }

        throw new IllegalArgumentException("Nenhum usuário encontrado com este cpf");
    }


    public UserEntities createUser(String name, String email, String cpf, String password) {
        UserEntities newUser = new UserEntities( name, email, cpf, password );

        mockDataBase.add(newUser);

        return newUser;
    }

    public UserEntities editUser(String name, String email, String cpf, String password) {
        UserEntities userEdit = findByCpf(cpf);

        userEdit.setName(name);
        userEdit.setEmail(email);
        userEdit.setCpf(cpf);
        userEdit.setPassword(password);

        return userEdit;
    }

    public void removeUser(String cpf) {
        mockDataBase.remove(findByCpf(cpf));
    }

    public ArrayList<UserEntities> getAll() {
        return mockDataBase;
    }

    public UserEntities login(String cpf, String password){
        UserEntities userFind = findByCpf(cpf);
        if(userFind == null){ throw new IllegalArgumentException("Usuário não encontrado"); }

        if(Objects.equals(userFind.getCpf(), cpf) && Objects.equals(userFind.getPassword(), password)) {
            return userFind;
        }

        throw new IllegalArgumentException("Usuário não encontrado");

    }

}
