import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Conta> contas = new ArrayList<>();

        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        Cliente cliente = new Cliente();
        cliente.setNome(nomeCliente);

        Conta cc = new ContaCorrente(cliente);
        Conta pp = new ContaPoupanca(cliente);

        contas.add(cc);
        contas.add(pp);

        int opcao;
        do {
            System.out.println("\n========= MENU =========");
            System.out.println("1. Depositar na Conta Corrente");
            System.out.println("2. Sacar da Conta Corrente");
            System.out.println("3. Transferir da Conta Corrente para Poupança");
            System.out.println("4. Aplicar Juros na Poupança");
            System.out.println("5. Exibir Extrato Conta Corrente");
            System.out.println("6. Exibir Extrato Conta Poupança");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Valor para depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    cc.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Valor para saque: ");
                    double valorSaque = scanner.nextDouble();
                    cc.sacar(valorSaque);
                    break;
                case 3:
                    System.out.print("Valor para transferência: ");
                    double valorTransferencia = scanner.nextDouble();
                    cc.transferir(valorTransferencia, pp);
                    break;
                case 4:
                    System.out.print("Percentual de juros (%): ");
                    double juros = scanner.nextDouble();
                    ((ContaPoupanca) pp).aplicarJurosMensal(juros);
                    break;
                case 5:
                    cc.imprimirExtrato();
                    break;
                case 6:
                    pp.imprimirExtrato();
                    break;
                case 0:
                    System.out.println("Encerrando programa.");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
