package basededados;

import complementos.Batalha;
import complementos.Equipamento;
import complementos.Habilidade;
import complementos.Insumo;
import java.util.Vector;
import modelo.Heroi;
import modelo.Inimigo;
import modelo.Personagem;

public class FakeBanco {
    
    private static Vector<Equipamento> lojaEquipamentos = new Vector<>();
    
    private static Vector<Personagem> personagensBanco = new Vector<>();
    private static Vector<Equipamento> equipamentosBanco = new Vector<>();
    private static Vector<Habilidade> habilidadesBanco = new Vector<>();
    private static Vector<Insumo> insumosBanco = new Vector<>();
    private static Vector<Batalha> batalhasBanco = new Vector<>();
    public static Vector<Inimigo> inimigosBanco = new Vector<>();
    public static Vector<Heroi> heroisBanco = new Vector<>();

    public static void iniciaBanco(){

       //Herois
       //magos
       heroisBanco.add(new Heroi(1, "sdfgdfgsdf", 1, 50, "Dumbledore", 10, 60, 9));
       heroisBanco.add(new Heroi(1, "ahjagsksg", 5, 250, "Otavio", 50, 150, 13));
       personagensBanco.add(new Heroi(1, "sdfgdfgsdf", 1, 50, "Dumbledore", 10, 60, 9));
       personagensBanco.add(new Heroi(1, "ahjagsksg", 5, 250, "Otavio", 50, 150, 13));
       //guerreiros
       heroisBanco.add(new Heroi(2, "aabbccddee", 1, 50, "Gabrielzin 244", 20, 100, 15));
       heroisBanco.add(new Heroi(2, "lafljçjAPOJ", 5, 250, "Finn", 100, 80, 15));
       personagensBanco.add(new Heroi(2, "aabbccddee", 1, 50, "Gabrielzin 244", 20, 100, 15));
       personagensBanco.add(new Heroi(2, "lafljçjAPOJ", 5, 250, "Finn", 100, 80, 15));
       //barbaros
       heroisBanco.add(new Heroi(3, "khahoqhiowy", 1, 50, "JT", 30, 90, 30));
       heroisBanco.add(new Heroi(3, "hsjahoq", 5, 250, "Aguia", 150, 120, 15));
       personagensBanco.add(new Heroi(3, "khahoqhiowy", 1, 50, "JT", 30, 90, 30));
       personagensBanco.add(new Heroi(3, "hsjahoq", 5, 250, "Aguia", 150, 120, 15));
       
       //inimigo
       inimigosBanco.add(new Inimigo("Inferno", 1, 1, 100, "Capeta", 25, 20, 5));
       inimigosBanco.add(new Inimigo("Mar", 2, 2, 250, "Peixe Cabecudo", 70, 20, 10));
       inimigosBanco.add(new Inimigo("Vulcao", 3, 20, 100, "Scorpion", 30, 50, 30));
       inimigosBanco.add(new Inimigo("Antartica", 3, 15, 55, "Sub-Zero", 28, 35, 22));
       inimigosBanco.add(new Inimigo("Marte", 3, 60, 1000, "Vegeta", 50, 100, 66));
        
       //monstruosidades
       personagensBanco.add(new Inimigo("Inferno", 1, 1, 100, "Capeta", 25, 20, 5));
       
       //bestas
       personagensBanco.add(new Inimigo("Mar", 2, 2, 250, "Peixe Cabecudo", 70, 20, 10));
       
       //humanoides
       personagensBanco.add(new Inimigo("Vulcao", 3, 20, 100, "Scorpion", 30, 50, 30));
       personagensBanco.add(new Inimigo("Antartica", 3, 15, 55, "Sub-Zero", 28, 35, 22));
       personagensBanco.add(new Inimigo("Marte", 3, 60, 1000, "Vegeta", 50, 100, 66));
       
       //equipamentos
       equipamentosBanco.add(new Equipamento(12, 100, 10, "Machadao"));
       equipamentosBanco.add(new Equipamento(30, 100, 1, "Bomba"));
       equipamentosBanco.add(new Equipamento(10, 75, 12, "Espada"));
       equipamentosBanco.add(new Equipamento(50, 150, 1, "Pergaminho do Darth Vader"));
       equipamentosBanco.add(new Equipamento(45, 200, 15, "Varinha do Voldemort"));
       
       
       //habilidade
       //magos
       habilidadesBanco.add(new Habilidade(20, "Bola de Fogo", 14, 1));
       habilidadesBanco.add(new Habilidade(6, "Flecha da Fenix", 2, 1));
       habilidadesBanco.add(new Habilidade(12, "Semente da Destruição", 6, 1));
       //guerreiros
       habilidadesBanco.add(new Habilidade(8, "Joelhada Voadora", 2, 1));
       habilidadesBanco.add(new Habilidade(12, "Rajada de Porrada", 5, 1));
       habilidadesBanco.add(new Habilidade(20, "Suple da Morte", 10, 1));
       //barbaros
       habilidadesBanco.add(new Habilidade(8, "Soco Potente", 2, 1));
       habilidadesBanco.add(new Habilidade(4, "Rasteira", 1, 1));
       habilidadesBanco.add(new Habilidade(12, "Chutao na Costela", 5, 1));
       
       //insumo
       insumosBanco.add(new Insumo("Pocao de cura p", 12, 0, 100));
       insumosBanco.add(new Insumo("Pocao de mana p", 0, 12, 100));
       
       //setando as habilidades aos herois criados
       for(Heroi i:heroisBanco){
           
           Vector<Habilidade> h = new Vector<>();
           
           int limInf = 0;
           int limSup = 0;
           
           switch(i.getClasse()){
               case 1:
                   
                   limInf = 0;
                   limSup = 2;
                   
                   break;
                   
               case 2:
                   
                   limInf = 3;
                   limSup = 5;
                   
                   break;
                   
               case 3:
                   
                   limInf = 6;
                   limSup = 8;
                   
                   break;
                   
           }
           for(int a = limInf; a <=limSup; a++){
               h.add(habilidadesBanco.get(a));
           }
           
           i.setHabilidades(h);
           
       }
   
   }
    
    public static Vector<Inimigo> selectAllInimigos(){
        return inimigosBanco;
    }
    
    public static Vector<Heroi> selectAllHerois(){
        return heroisBanco;
    }
    
    public static Vector<Equipamento> selectAllEquipamentos(){
        return equipamentosBanco;
    }
    
    public static Vector <Insumo> selectAllInsumos(){
        return insumosBanco;
    }
   
    public static void insertPersonagem(Personagem p){
        personagensBanco.add(p);
    }
    public static void insertHeroi(Heroi h){
        heroisBanco.add(h);
    }
    
    public static void insertBatalha(Batalha b){
        batalhasBanco.add(b);
    }
    
}
