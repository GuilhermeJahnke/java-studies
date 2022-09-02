import domain.entities.account.AccountEntities;
import domain.usecase.account.AccountUseCase;

import java.util.Scanner;


public class Main {
    private static final AccountUseCase accountUseCase = new AccountUseCase();
    public static void main(String... args){
        Scanner in = new Scanner(System.in);
        System.out.println("Digite seu nome");
        String name = in.nextLine();
        System.out.println("Digite o saldo da sua conta");
        double balance = in.nextDouble();

        AccountEntities account = accountUseCase.create(name, balance);
        System.out.println(account);

    }

}
