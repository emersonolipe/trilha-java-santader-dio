import exception.ParametrosInvalidosException;
import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        System.out.println("Digite o primeiro parâmetro");
        int parametroUm = terminal.nextInt();
        System.out.println("Digite o segundo parâmetro");
        int parametroDois = terminal.nextInt();

        try {
            contar(parametroUm, parametroDois);

        } catch (ParametrosInvalidosException exception) {
            System.out.println(exception.getClass().getSimpleName() + ": " + exception.getMessage());
        }

    }
    static void contar(int parametroUm, int parametroDois ) throws ParametrosInvalidosException {
        if(parametroUm > parametroDois) {
            throw new ParametrosInvalidosException("O primeiro parametro nao pose ser maior que o segundo.");
        }

        int contagem = parametroDois - parametroUm;
        //realizar o for para imprimir os números com base na variável contagem
        for(int i = 0; i < contagem; i++) {
            System.out.println("Imprimindo o número " + (i+1));
        }
    }
}