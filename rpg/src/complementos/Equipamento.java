package complementos;

import java.util.Random;

public class Equipamento {
    
    private int dano;
    private int preco;
    private int pontoVida;
    private String nome;

    public Equipamento(int dano, int preco, int pontoVida, String nome) {
        this.dano = dano;
        this.preco = preco;
        this.pontoVida = pontoVida;
        this.nome = nome;
    }

    
    public int getPontoVida() {
        return pontoVida;
    }

    public String getNome() {
        return nome;
    }

    public int getDano() {
        return dano;
    }

    public int getPreco() {
        return preco;
    }
    
    public static int dadoEquipamento(Equipamento e){
        Random dado = new Random();
        int dadoDano = dado.nextInt(1,e.getDano());
        
        //System.out.println("O resultado do D"+dano+" é: "+dadoDano);
        return dadoDano;
    }
    
}
