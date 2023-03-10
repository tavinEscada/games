package complementos;

import java.util.Random;
import modelo.Personagem;

public class Habilidade {
    
    private int dano;
    private String nome;
    private int quantMana;
    private int nivel;

    public Habilidade(int dano, String nome, int quantMana, int nivel) {
        this.dano = dano;
        this.nome = nome;
        this.quantMana = quantMana;
        this.nivel = nivel;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getQuantMana() {
        return quantMana;
    }

    public void setQuantMana(int quantMana) {
        this.quantMana = quantMana;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getNome() {
        return nome;
    }
    
    public static int dadoHabilidade(Habilidade h){
        Random dado = new Random();
        int dadoDano = dado.nextInt(1, h.getDano());
        
        return dadoDano;
    }
    
    public String toString(){
        return this.nome;
    }
}
