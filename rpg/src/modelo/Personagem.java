package modelo;

public class Personagem {
    
    //atributos
    protected String nome;
    protected int vida;
    protected int mana;
    protected int golpeBase;
    
    //construtores
    public Personagem(String nome, int vida, int mana, int golpeBase) {    
        this.nome = nome;
        this.vida = vida;
        this.mana = mana;
        this.golpeBase = golpeBase;
    }

    public Personagem(String nome, int vida, int golpeBase) {
        this.nome = nome;
        this.vida = vida;
        this.golpeBase = golpeBase;
    }
    
    
    //encapsulamento
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getGolpeBase() {
        return golpeBase;
    }

    public String getNome() {
        return nome;
    }
    
    
    public static void selecionaAlvo(){
        
        System.out.println("Selecione quem você vai atacar:");
        
    } 
    
}
