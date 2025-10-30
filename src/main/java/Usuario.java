import java.util.Observable;
import java.util.Observer;

public class Usuario implements Observer {
    private String nome;
    private String ultimaNotificacao;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void observar(Moeda moeda) {
        moeda.addObserver(this);
    }

    public void comprar(Moeda moeda) {
        moeda.comprar();
    }

    public void vender(Moeda moeda) {
        moeda.vender();
    }

    public void update(Observable moeda, Object arg1) {
        this.ultimaNotificacao = "A moeda " + moeda.toString() + " teve sua cotacao modificada.";
    }
}