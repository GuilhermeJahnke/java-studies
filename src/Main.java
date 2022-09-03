import domain.entities.account.AccountEntities;
import domain.entities.user.UserEntities;
import domain.usecase.account.AccountUseCase;
import domain.usecase.user.UserUseCase;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    private static final UserUseCase userUseCase = new UserUseCase();
    private static final AccountUseCase accountUseCase = new AccountUseCase();

    public static void main(String... args){
        Scanner in = new Scanner(System.in);

        System.out.println("\nBEM VINDO AO SISTEMA DA NO COFFEE NO CODE");
        System.out.println("\nVAMOS DAR INICIO AO SEU CADASTRO \n");

        System.out.println("Digite seu nome:");
        String userName = in.nextLine();
        System.out.println("Digite seu email:");
        String userEmail = in.nextLine();
        System.out.println("Digite seu cpf:");
        String userCpf = in.nextLine();
        System.out.println("Digite sua senha:");
        String userPassword = in.nextLine();

        UserEntities user = userUseCase.create(userName, userEmail, userCpf, userPassword);

        System.out.println("\nParabéns cadastro realizado com sucesso! \n");
        System.out.println(user);

        System.out.println("\nVamos dar início ao seu Login \n");

        System.out.println("Digite seu cpf:");
        String loginCPF = in.nextLine();

        System.out.println("Digite sua senha:");
        String loginPassword = in.nextLine();

        UserEntities userLogged = userUseCase.login(loginCPF, loginPassword);
        System.out.println("\nUsuário logado com sucesso!\n");
        System.out.println(userLogged);

        System.out.println("\nAgora vamos registrar um perfil\n");

        System.out.println("Digite o nome do perfil:");
        String accountName = in.nextLine();

        System.out.println("Digite o saldo da sua conta \n Exemplo: 1.800,00");
        double accountBalance = in.nextDouble();

        AccountEntities account = accountUseCase.create(accountName, accountBalance);
        System.out.println("\nNovo perfil registrado com sucesso!\n");
        System.out.println(account);

        System.out.println("\n\nAgora vamos exibir todos os usuarios registrados\n");
        ArrayList<UserEntities> allUsers = userUseCase.getAll();
        System.out.println(allUsers);

        System.out.println("\n\nE também exibiremos todos os perfis registrados\n");
        ArrayList<AccountEntities> allAccounts = accountUseCase.getAll();
        System.out.println(allAccounts);

        System.out.println("\nINTEGRANTES\n");

        System.out.println("\nGuilherme Jahnke Vieira - RM: 93041");
        System.out.println("\nThamires Aluiza dos Santos - RM: 94908");
        System.out.println("\nGustavo Guilherme Silva de Souza - RM: 92923");
        System.out.println("\nFilipe Souza Zapotoczny Costa - RM: 94285");

        System.out.println("\nOBRIGADO POR TESTAR O SISTEMA DA NO COFFEE NO CODE\n");
    }

}
