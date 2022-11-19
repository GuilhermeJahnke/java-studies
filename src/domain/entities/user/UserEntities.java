package domain.entities.user;
import java.util.Random;

public class UserEntities {
    private String name;
    private String email;
    private String cpf;
    private String password;
    private int id;

    public UserEntities(String name, String email, String cpf, String password) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.password = password;
        this.id = new Random().nextInt(9999999);;
    }
    public UserEntities(String name, String email, String cpf, String password, int id) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.password = password;
        this.id = id;;
    }

    public int getId() {
    	return id;
    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "UserEntities{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}