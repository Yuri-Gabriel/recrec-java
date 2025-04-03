package main.others;

public class Musica {
    int id;
    String nome;

    public Musica(String nome) {
        this.setNome(nome);
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
