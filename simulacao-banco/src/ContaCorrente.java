public class ContaCorrente extends Conta {

    private static final double TAXA_SAQUE = 1.5;

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void sacar(double valor) {
        double valorComTaxa = valor + TAXA_SAQUE;
        if (saldo >= valorComTaxa) {
            this.saldo -= valorComTaxa;
            getHistorico().add(new Transacao("SAQUE (com taxa)", valorComTaxa));
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Extrato da CC:");
        super.imprimirInfosComuns();
        System.out.println("Histórico de Transações:");
        for (Transacao t : getHistorico()) {
            System.out.println(t);
        }
    }
}
