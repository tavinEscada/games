package modelo;

import complementos.Batalha;
import complementos.Equipamento;
import complementos.Habilidade;
import complementos.Insumo;
import java.util.Vector;

public class Heroi extends Personagem{
    
    //atributos
    private int classe;
    private String historia;
    private int nivel;
    private int dinheiro;
    private Equipamento equipamento;
    
    
    //associações
    private Vector<Habilidade> habilidades = new Vector<>();
    //private Vector<Equipamento> equipamentos = new Vector<>();
    private Vector<Insumo> insumos = new Vector<>();
    
    
    //construtores
    public Heroi(int classe, String historia, int nivel, int dinheiro, Vector<Habilidade> habilidades, Equipamento equipamento, Vector<Insumo> insumos, String nome, int vida, int mana, int golpeBase) {
        super(nome, vida, mana, golpeBase);
        this.classe = classe;
        this.historia = historia;
        this.nivel = nivel;
        this.dinheiro = dinheiro;
        this.habilidades = habilidades;
        this.equipamento = equipamento;
        this.insumos = insumos;
    }

    public Heroi(int classe, String historia, int nivel, int dinheiro, String nome, int vida, int mana, int golpeBase) {
        super(nome, vida, mana, golpeBase);
        this.classe = classe;
        this.historia = historia;
        this.nivel = nivel;
        this.dinheiro = dinheiro;
    }
    
    

    public Vector<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(Vector<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public Vector<Insumo> getInsumos() {
        return insumos;
    }

    public void setInsumos(Vector<Insumo> insumos) {
        this.insumos = insumos;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getClasse() {
        return classe;
    }

    public String getHistoria() {
        return historia;
    }

    public int getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(int dinheiro) {
        this.dinheiro = dinheiro;
    }
    
    public void insertInsumo(Insumo i){
        this.insumos.add(i);
    }


    public String toString(){
        return this.nome;
    }
}
