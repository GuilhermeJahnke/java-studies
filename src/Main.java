import data.connection.ConnectionDAO;
import domain.entities.account.AccountEntities;
import domain.entities.entry.EntryExpenseEntities;
import domain.entities.entry.EntryInvestmentEntities;
import domain.entities.entry.EntryReceiptEntities;
import domain.entities.user.UserEntities;
import domain.usecase.account.AccountUseCase;
import domain.usecase.entry.EntryExpenseUseCase;
import domain.usecase.entry.EntryInvestmentUseCase;
import domain.usecase.entry.EntryReceiptUseCase;
import domain.usecase.user.UserUseCase;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    private static final UserUseCase userUseCase = new UserUseCase();
    private static final AccountUseCase accountUseCase = new AccountUseCase();
    private static final EntryExpenseUseCase expenseUseCase = new EntryExpenseUseCase();
    private static final EntryInvestmentUseCase investmentUseCase = new EntryInvestmentUseCase();
    private static final EntryReceiptUseCase receiptUseCase = new EntryReceiptUseCase();

    private static final Scanner in = new Scanner(System.in);

    //    private static final int createUserOption = 1;
//    private static final int loginOption = 2;
    private static final int createProfileOption = 1;
    private static final int getAllProfileOption = 2;
    //    private static final int getAllUserOption = 4;
//    private static final int createExpenseOption = 2;
//    private static final int getAllExpenseOption = 6;
//    private static final int createInvestmentOption = 3;
//    private static final int getAllInvestmentOption = 7;
//    private static final int createReceiptOption = 4;
//    private static final int getAllReceiptOption = 8;
    private static final int exitOption = 3;


    public static void main(String... args) {

        System.out.println("\nBEM VINDO AO SISTEMA DA NO COFFEE NO CODE");
        System.out.println("\nVAMOS DAR INICIO AO SEU CADASTRO \n");

        boolean notFinishedLooping = true;


        while (notFinishedLooping) {
            System.out.println("Digite uma opção:");
            System.out.println("Digite [1] para cadastrar um perfil:");
//            System.out.println("Digite [2] para cadastrar uma despesa:");
//            System.out.println("Digite [3] para cadastrar um investimento:");
//            System.out.println("Digite [4] para cadastrar uma receita:");
            System.out.println("Digite [2] para listar todos os perfis:");
//            System.out.println("Digite [6] para listar todas as despesas:");
//            System.out.println("Digite [7] para listar todos os investimentos:");
//            System.out.println("Digite [8] para listar todas as receitas:");
            System.out.println("Digite [3] para sair:");

//            System.out.println("Digite [1] para se cadastrar:");
//            System.out.println("Digite [2] para fazer login:");
//            System.out.println("Digite [4] para listar todos os usuarios:");
            int selectedOption = in.nextInt();


            switch (selectedOption) {
                case createProfileOption: createAccount(); break;
//            case createExpenseOption: createExpense(); break;
//            case createInvestmentOption: createInvestment(); break;
//            case createReceiptOption: createReceipt(); break;
                case getAllProfileOption: getAllAccount();break;
//            case getAllExpenseOption: getAllExpense(); break;
//            case getAllInvestmentOption: getAllInvestment();break;
//            case getAllReceiptOption: getAllReceipt();break;
                case exitOption: notFinishedLooping = false;break;
//                case createUserOption: createUser();
//                case loginOption: loginUser();
//                case getAllUserOption: getAllUser();break;
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

    private static void loginUser() {
        System.out.println("\nVamos dar início ao seu Login \n");

        System.out.println("Digite seu cpf:");
        String loginCPF = in.next();

        System.out.println("Digite sua senha:");
        String loginPassword = in.next();

        UserEntities userLogged = userUseCase.login(loginCPF, loginPassword);
        System.out.println("\nUsuário logado com sucesso!\n");
        System.out.println("Instancia criada:" + " " + userLogged + "\n");
    }

    private static void createAccount() {
        System.out.println("\nAgora vamos registrar um perfil\n");

        System.out.println("Digite o cpf do perfil:");
        int accountCpf = in.nextInt();

        System.out.println("Digite o nome do perfil:");
        String accountName = in.next();

        System.out.println("Digite o saldo da sua conta \n Exemplo: 1.800,00");
        double accountBalance = in.nextDouble();

//        AccountEntities account = accountUseCase.create(accountCpf, accountName, accountBalance);
        System.out.println("\nNovo perfil registrado com sucesso!\n");
//        System.out.println("Instancia criada:" + " " + account + "\n");
    }

    private static void createExpense() {
        System.out.println("\nAgora vamos registrar uma despesa\n");

        System.out.println("Essa despesa já foi paga? y/n");
        String received = in.next();


        System.out.println("Data de pagamento");
        String receivedDate = in.next();

        System.out.println("Valor da despesa");
        double amount = in.nextDouble();

        System.out.println("Data da despesa");
        String date = in.next();

        System.out.println("Categoria da despesa");
        String category = in.next();

        System.out.println("Descrição da despesa:");
        String description = in.next();

        System.out.println("Digite um codigo identificador da despesa:");
        String id = in.next();

        boolean receivedBool = false;

        if(received == "y") {
            receivedBool = true;
        }

//        EntryExpenseEntities expense = expenseUseCase.create(receivedBool, receivedDate, amount, date, category, description, id);

        System.out.println("\nNova despesa registrada com sucesso!\n");
//        System.out.println("Instancia criada:" + " " + expense + "\n");
    }
    private static void createInvestment() {
        System.out.println("\nAgora vamos registrar um investimento\n");

        System.out.println("Esse investimento já foi recebido? y/n");
        String rescued = in.next();


        System.out.println("Data de recebimento");
        String receivedDate = in.next();

        System.out.println("Valor recebido");
        double amountIncome = in.nextDouble();

        System.out.println("Valor do investimento");
        double amount = in.nextDouble();

        System.out.println("Data do investimento");
        String date = in.next();

        System.out.println("Categoria do investimento");
        String category = in.next();

        System.out.println("Descrição do investimento:");
        String description = in.next();

        boolean rescuedBool = false;

        if(rescued == "y") {
            rescuedBool = true;
        }

        investmentUseCase.create(rescuedBool, receivedDate, amountIncome, amount, date, category, description);

        System.out.println("\nNovo Investimento registrado com sucesso!\n");
    }
    private static void createReceipt() {
        System.out.println("\nAgora vamos registrar uma receita\n");

        System.out.println("Essa receita já foi recebida? y/n");
        String received = in.next();


        System.out.println("Data de recebimento");
        String receivedDate = in.next();

        System.out.println("Valor recebido");
        double amount = in.nextDouble();

        System.out.println("Data do recebimento");
        String date = in.next();

        System.out.println("Categoria do recebimento");
        String category = in.next();

        System.out.println("Descrição do recebimento");
        String description = in.next();

        boolean rescuedBool = false;

        if(received == "y") {
            rescuedBool = true;
        }

        receiptUseCase.create(rescuedBool, receivedDate, amount, date, category, description);

        System.out.println("\nNova Receita registrada com sucesso!\n");
    }


    private static void getAllAccount() {
        System.out.println("\nExibiremos todos os perfis registrados\n");
        ArrayList<AccountEntities> allAccounts = accountUseCase.getAll();
        System.out.println(allAccounts + "\n");
    }


    private static void getAllExpense() {
        System.out.println("\nExibiremos todas as despesas registradas\n");
        ArrayList<EntryExpenseEntities> allExpenses = expenseUseCase.getAll();
        System.out.println(allExpenses + "\n");
    }


    private static void getAllInvestment() {
        System.out.println("\nExibiremos todos os investimentos registrados\n");
        ArrayList<EntryInvestmentEntities> allInvestments = investmentUseCase.getAll();
        System.out.println(allInvestments + "\n");
    }


    private static void getAllReceipt() {
        System.out.println("\nExibiremos todas as receitas registradas\n");
        ArrayList<EntryReceiptEntities> allReceipts = receiptUseCase.getAll();
        System.out.println(allReceipts + "\n");
    }

    private static void getAllUser() {
        System.out.println("\nExibiremos todos os usuarios registrados\n");
        ArrayList<UserEntities> allUsers = userUseCase.getAll();
        System.out.println(allUsers + "\n");
    }

}
