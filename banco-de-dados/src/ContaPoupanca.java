public class ContaPoupanca extends Conta {


    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    public void aplicarJurosMensal(double percentual) {
        double juros = saldo * percentual / 100;
        this.saldo += juros;
        getHistorico().add(new Transacao("JUROS", juros));
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Extrato da PP:");
        super.imprimirInfosComuns();
        System.out.println("Histórico de Transações:");
        for (Transacao t : getHistorico()) {
            System.out.println(t);
        }
    }
}
