package modelo;

import basededados.FakeBanco;
import complementos.Batalha;
import java.util.Vector;

public class Inimigo extends Personagem{
    
    //atributos
    private String local;
    private int tipo;
    private int dificuldade;
    private int premio;
    
    private Vector<Batalha> batalhas;

    //construtor
    public Inimigo(String local, int tipo, int dificuldade, int premio, String nome, int vida, int mana, int golpeBase) {
        super(nome, vida, mana, golpeBase);
        this.local = local;
        this.tipo = tipo;
        this.dificuldade = dificuldade;
        this.premio = premio;
    }

    public Inimigo(String local, int tipo, int dificuldade, int premio, String nome, int vida, int golpeBase) {
        super(nome, vida, golpeBase);
        this.local = local;
        this.tipo = tipo;
        this.dificuldade = dificuldade;
        this.premio = premio;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }
    

    public String getLocal() {
        return local;
    }

    public int getTipo() {
        return tipo;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    public int getPremio(){
        return premio;
    }
    
    public String toString(){
        
        for(Inimigo i : FakeBanco.inimigosBanco){
            String dados = this.nome;
            
            return dados;   
        }
        
        return null;
    }
}
