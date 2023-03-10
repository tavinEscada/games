package model;

public class Palavra {
    private String nome;
    private String tema;

    public Palavra(String nome, String tema) {
        this.nome = nome;
        this.tema = tema;
    }

    public String getNome() {
        return nome;
    }

    public String getTema() {
        return tema;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
    
    
}
