package complementos;

public class Insumo {
    
    private String nome;
    private int pontosVida;
    private int pontosMana;
    private int preco;

    public Insumo(String nome, int pontosVida, int pontosMana, int preco) {
        this.nome = nome;
        this.pontosVida = pontosVida;
        this.pontosMana = pontosMana;
        this.preco = preco;
    }


    public String getNome() {
        return nome;
    }

    public int getPontosVida() {
        return pontosVida;
    }

    public int getPontosMana() {
        return pontosMana;
    }

    public int getPreco() {
        return preco;
    }
    
    
}
