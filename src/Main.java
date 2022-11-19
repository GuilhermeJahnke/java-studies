import domain.entities.account.AccountEntities;
import domain.entities.user.UserEntities;
import domain.usecase.account.AccountUseCase;
import domain.usecase.user.UserUseCase;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    private static final UserUseCase userUseCase = new UserUseCase();
    private static final AccountUseCase accountUseCase = new AccountUseCase();
    private static final Scanner in = new Scanner(System.in);
    private static final int createProfileOption = 1;
    private static final int getAllProfileOption = 2;
    private static final int createUserOption = 3;
    private static final int getAllUsersOption = 4;
    private static final int exitOption = 5;


    public static void main(String... args) {

        System.out.println("\nBEM VINDO AO SISTEMA DA NO COFFEE NO CODE");
        System.out.println("\nVAMOS DAR INICIO AO SEU CADASTRO \n");

        boolean notFinishedLooping = true;


        while (notFinishedLooping) {
            System.out.println("Digite uma opção:");
            System.out.println("Digite [1] para cadastrar um perfil:");
            System.out.println("Digite [2] para listar todos os perfis:");
            System.out.println("Digite [3] para cadastrar uma conta:");
            System.out.println("Digite [4] para listar todos os perfis:");
            System.out.println("Digite [5] para sair:");
            int selectedOption = in.nextInt();


            switch (selectedOption) {
                case createProfileOption: createAccount(); break;
                case getAllProfileOption: getAllAccount();break;
                case createUserOption: createUser();break;
                case getAllUsersOption: getAllUsers();break;
                case exitOption: notFinishedLooping = false;break;
            }
        }

        System.out.println("\nINTEGRANTES");

        System.out.println("\n - Guilherme Jahnke Vieira - RM: 93041");
        System.out.println("\n - Thamires Aluiza dos Santos - RM: 94908");
        System.out.println("\n - Gustavo Guilherme Silva de Souza - RM: 92923");
        System.out.println("\n - Filipe Souza Zapotoczny Costa - RM: 94285");
        System.out.println("\n - Bernardo Moraes Silva - RM: 93532");

        System.out.println("\n\nOBRIGADO POR TESTAR O SISTEMA DA NO COFFEE NO CODE\n");
    }

    private static void createAccount() {
        System.out.println("\nAgora vamos registrar um perfil\n");
        
        System.out.println("Digite o id da conta:");
        int accountUserId = in.nextInt();

        System.out.println("Digite o cpf do perfil:");
        int accountCpf = in.nextInt();

        System.out.println("Digite o nome do perfil:");
        String accountName = in.next();

        System.out.println("Digite o saldo da sua conta \n Exemplo: 1.800,00");
        double accountBalance = in.nextDouble();
        
        UserEntities user = userUseCase.findById(accountUserId);


        AccountEntities account = accountUseCase.create(accountName, accountBalance, user);
        System.out.println("\nNovo perfil registrado com sucesso!\n");
    }
    
    private static void createUser() {
        System.out.println("\nVamos começar a criação de usuario\n");

        System.out.println("Digite seu nome:");
        String userName = in.next();

        System.out.println("\nDigite seu email:");
        String userEmail = in.next();

        System.out.println("\nDigite seu cpf:");
        String userCpf = in.next();

        System.out.println("\nDigite sua senha:");
        String userPassword = in.next();

        UserEntities user = userUseCase.create(userName, userEmail, userCpf, userPassword);

        System.out.println("\nParabéns cadastro realizado com sucesso! \n");
        System.out.println("Instancia criada:" + " " + user + "\n");
    }
    
    private static void getAllAccount() {
        System.out.println("\nExibiremos todos os perfis registrados\n");
        ArrayList<AccountEntities> allAccounts = accountUseCase.getAll();
        System.out.println(allAccounts + "\n");
    }
    
    private static void getAllUsers() {
        System.out.println("\nExibiremos todos os perfis registrados\n");
        ArrayList<UserEntities> allUsers = userUseCase.getAll();
        System.out.println(userUseCase + "\n");
    }

}
