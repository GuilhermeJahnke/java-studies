package domain.entities.account;
import java.util.Random;

public class AccountEntities {
    private int id;
    int userId;
    private String name;
    private double balance;


    public AccountEntities(String name, double balance, int userId) {
        this.id = new Random().nextInt(9999999);
        this.name = name;
        this.balance = balance;
        this.userId = userId;
    }
    
    public AccountEntities(String name, double balance, int userId, int id) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }
    
    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "AccountEntities{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
