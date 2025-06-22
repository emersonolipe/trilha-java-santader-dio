public class BancoDigital extends Banco {
    private String urlApp;

    public BancoDigital(String nome, String urlApp) {
        setNome(nome);
        this.urlApp = urlApp;
    }

    public void exibirInfo() {
        System.out.println("Banco: " + getNome());
        System.out.println("App: " + urlApp);
    }
}
