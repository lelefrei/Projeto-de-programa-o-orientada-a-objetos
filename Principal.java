import java.util.ArrayList;
import java.util.Scanner;
public class Principal {
    public static void main(String[] args) {

        ArrayList <Banco> contas = new ArrayList<Banco>();
        ArrayList <Pessoa> clientes = new ArrayList<Pessoa>();
        Scanner sc = new Scanner(System.in);

        int opcao = 0;

        do {
            System.out.println("Menu do Banco");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Cadastrar conta");
            System.out.println("3 - Consultar saldo");
            System.out.println("4 - Exibir todas as contas cadastradas");
            System.out.println("5 - Sacar dinheiro");
            System.out.println("6 - Depositar dinheiro");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();


            switch (opcao) {
                case 1:
                    System.out.println("Cadastro de cliente");
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    clientes.add(new Pessoa(nome, cpf));
                    System.out.println("Cliente cadastrado com sucesso!");
                    System.out.println();
                    break;

                case 2:
                    System.out.println("Cadastro de conta");
                    System.out.println("Digite o cpf do titular");
                    cpf = sc.next();
                    Pessoa titular = null;
                    Banco banco = null;
                    for (Pessoa c : clientes){
                        if ( c.getCpf().equals(cpf)){
                            titular = c;

                        }
                        }


                    System.out.print(" Número da conta: ");
                    int numeroConta = sc.nextInt();
                    System.out.print("Saldo: ");
                    double saldo = sc.nextDouble();

                    System.out.println("Selecione o cliente:");
                    for (int j = 0; j < clientes.size(); j++) {
                        System.out.println((j + 1) + " - " + clientes.get(j).getNome());
                    }

                    int escolha = sc.nextInt();
                    Pessoa cliente = clientes.get(escolha - 1);

                   if ( titular != null) {
                       Banco conta = new Banco(cliente, numeroConta, saldo);
                       contas.add(conta);
                       System.out.println("Conta cadastrada com sucesso!");
                   }
                   break;

                    case 3:
                    System.out.println("Consulta de saldo");
                    System.out.print("Número da conta: ");

                    numeroConta = sc.nextInt();

                     Banco conta = null;
                    for (Banco b : contas) {

                        if (b.getNumeroConta() == numeroConta) {
                            banco = b;

                        }
                        }
                         if (contas !=null){
                        for (Banco b : contas) {
                            if (b.getNumeroConta() == numeroConta){
                                System.out.println("Saldo" + b.getSaldo());
                                break;
                            }
                            }
                            }  else {
                               System.out.println(" A conta informada não existe");
                         }

                     break;

                     case 4:

                    System.out.println("Contas cadastradas");

                    for (Banco b : contas) {
                        System.out.println("Nome: " + b.getCliente().getNome());
                        System.out.println("Cpf: " + b.getCliente().getCpf());
                        System.out.println("Número da conta: " + b.getNumeroConta());
                        System.out.println("Saldo: R$" + b.getSaldo());
                        System.out.println("---------------------");
                    }
                    break;

                    case 5:

                    System.out.println("Saque");
                    System.out.print("Digite o número da conta: ");
                    int numContaSaque = sc.nextInt();

                    Banco contaSaque = null;

                    for (Banco b : contas) {
                        if (b.getNumeroConta() == numContaSaque) {
                            contaSaque = b;
                        }
                        break;
                    }

                    if (contaSaque == null) {
                        System.out.println("Conta não encontrada.");
                    } else {
                        System.out.print("Digite o valor do saque: ");
                        double valorSaque = sc.nextDouble();

                        if (contaSaque.sacar(valorSaque)) {
                            System.out.println("Saque realizado com sucesso. Novo saldo: R$" + contaSaque.getSaldo());
                        } else {
                            System.out.println("Saldo insuficiente.");
                        }
                        }

                    break;

                case 6:

                    System.out.print("Digite o número da conta: ");
                    int  numContaDeposito = sc.nextInt();

                    Banco contaDeposito = null;

                    for (Banco b : contas) {
                        if (b.getNumeroConta() == numContaDeposito) {
                            contaDeposito = b;
                            break;

                        }
                    }

                    if (contaDeposito == null) {

                        System.out.println("Conta não encontrada.");
                    } else {
                        System.out.print("Digite o valor do depósito: ");
                        double valorDeposito = sc.nextDouble();
                        contaDeposito.depositar(valorDeposito);
                        System.out.println("Depósito realizado com sucesso. Novo saldo: R$" + contaDeposito.getSaldo());
                    }

                    break;

            }


         }   while ( opcao != 7 ) ;

           System.out.println("Obrigado por utilizar nosso sistema");

         }

         }
