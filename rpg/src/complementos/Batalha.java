package complementos;

import java.util.Date;
import java.util.Vector;
import modelo.Heroi;
import modelo.Inimigo;
import modelo.Personagem;

public class Batalha {
    
    private Vector<Heroi> herois;
    private Vector<Inimigo> inimigos;
    
    public Batalha(Vector<Heroi> herois, Vector<Inimigo> inimigos) {
        this.herois = herois;
        this.inimigos = inimigos;   
    }

    public Vector<Heroi> getHerois() {
        return herois;
    }

    public Vector<Inimigo> getInimigos() {
        return inimigos;
    }
    
}
