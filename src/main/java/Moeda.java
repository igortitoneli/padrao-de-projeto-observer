import java.util.Observable;

public class Moeda extends Observable {

    private Integer cotacao;
    private String nome;

    public Moeda(String nome, Integer cotacao) {
        this.nome = nome;
        this.cotacao = cotacao;
    }

    public void comprar() {
        this.cotacao = this.cotacao + 1;
        this.notificar();
    }

    public void vender() {
        this.cotacao = this.cotacao - 1;
        this.notificar();
    }

    public void notificar() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Moeda{" +
                "nome=" + nome + '\'' +
                ", cotacao=" + cotacao + '\'' +
                '}';
    }
}