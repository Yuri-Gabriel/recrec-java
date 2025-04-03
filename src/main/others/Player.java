package main.others;

import main.list.simple.List;

public class Player {
    private List<Musica> list;

    public Player() {
        this.list = new List<Musica>();
    }

    public void listarMusicas() {
        while(this.list.haveNext()) {
            System.out.println(this.list.getCurrent().getValue().getNome());
        }
    }

    public void adicionarMusica(Musica m) {
        this.list.add(m);
    }

    public void removerMusica() {
        this.list.remove();
    }
}
