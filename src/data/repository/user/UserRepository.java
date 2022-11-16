package data.repository.user;


import domain.entities.user.UserEntities;

import java.util.ArrayList;
import java.util.Objects;

public class UserRepository {
    private final ArrayList<UserEntities> mockDataBase = new ArrayList<>();

    public UserEntities findByEmail(String email){
        for (UserEntities userEntity : mockDataBase) {
            if (userEntity.getEmail().equals(email)) return userEntity;
        }

        throw new IllegalArgumentException("Nenhum usuário encontrado com este email");
    }


    public UserEntities createUser(String name, String email, String cpf, String password) {
        UserEntities newUser = new UserEntities( name, email, cpf, password );

        mockDataBase.add(newUser);

        return newUser;
    }

    public UserEntities editUser(String name, String email, String cpf, String password) {
        UserEntities userEdit = findByEmail(cpf);

        userEdit.setName(name);
        userEdit.setEmail(email);
        userEdit.setCpf(cpf);
        userEdit.setPassword(password);

        return userEdit;
    }

    public void removeUser(String email) {
        mockDataBase.remove(findByEmail(email));
    }

    public ArrayList<UserEntities> getAll() {
        return mockDataBase;
    }

    public UserEntities login(String email, String password){
        UserEntities userFind = findByEmail(email);
        if(userFind == null){ throw new IllegalArgumentException("Usuário não encontrado"); }

        if(Objects.equals(userFind.getEmail(), email) && Objects.equals(userFind.getPassword(), password)) {
            return userFind;
        }

        throw new IllegalArgumentException("Usuário não encontrado");

    }

}
