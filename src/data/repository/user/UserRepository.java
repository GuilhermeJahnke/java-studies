package data.repository.user;


import domain.entities.User.UserEntities;

import java.util.ArrayList;

public class UserRepository {
    private final ArrayList<UserEntities> mockDataBase = new ArrayList<>();

    public UserEntities findByName (String cpf){
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
        UserEntities userEdit = findByName(cpf);

        userEdit.setName(name);
        userEdit.setEmail(email);
        userEdit.setCpf(cpf);
        userEdit.setPassword(password);

        return userEdit;
    }

    public void removeUser(String cpf) {
        mockDataBase.remove(findByName(cpf));
    }

    public ArrayList<UserEntities> getAll() {
        return mockDataBase;
    }
}
