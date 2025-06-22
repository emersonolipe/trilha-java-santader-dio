import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements ContaInterface {

    private static int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    protected int agencia;
    protected int numero;
    protected  double saldo;
    protected Cliente cliente;
    private List<Transacao> historico = new ArrayList<>();

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public List<Transacao> getHistorico() {
        return historico;
    }


    @Override
    public void sacar(double valor) {
        if (saldo >= valor) {
            this.saldo -= valor;
            historico.add(new Transacao("SAQUE", valor));
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
        historico.add(new Transacao("DEPÓSITO", valor));
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (saldo >= valor) {
            this.saldo -= valor;
            contaDestino.depositar(valor);
            historico.add(new Transacao("TRANSFERÊNCIA ENVIADA", valor));
            contaDestino.getHistorico().add(new Transacao("TRANSFERÊNCIA RECEBIDA", valor));
        } else {
            System.out.println("Saldo insuficiente para transferência.");
        }
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Conta: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }
}
