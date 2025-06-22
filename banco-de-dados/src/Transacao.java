import java.time.LocalDateTime;

public class Transacao {
    private LocalDateTime dataHora;
    private String tipo; // "DEPÓSITO", "SAQUE", "TRANSFERÊNCIA"
    private double valor;

    public Transacao(String tipo, double valor) {
        this.dataHora = LocalDateTime.now();
        this.tipo = tipo;
        this.valor = valor;
    }

    public String toString() {
        return String.format("[%s] %s: R$ %.2f", dataHora, tipo, valor);
    }
}
