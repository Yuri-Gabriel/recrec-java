 package main;

import main.hanoi.tree.*;

public class App {
	public static void main(String[] args) {
		Player player = new Player();

		player.adicionarMusica(new Musica("what maques you builtifull"));
		player.adicionarMusica(new Musica("Empitines Maxine"));
		player.adicionarMusica(new Musica("Rap do Naruto - Player Tauz"));
		player.adicionarMusica(new Musica("Cau Auti Mai Neime"));

		player.listarMusicas();

		player.removerMusica();

		player.listarMusicas();
	}
}
