 package main;

import main.others.Musica;
import main.others.Player;
import main.tree.*;

import main.list.duple.ListDupl;

public class App {
	public static void main(String[] args) {
		ListDupl<String> lista01 = new ListDupl<String>();
		ListDupl<String> lista02 = new ListDupl<String>();

		lista01.addRight("pao");
		lista01.addRight("top");
		lista01.addRight("peba");
		lista01.addRight("top");

		lista02.addRight("pao");
		lista02.addRight("top");
		lista02.addRight("chico");

		ListDupl<String> lista03 = lista01.getListWithCommonNames(lista02);

		lista01.showRightToLeft();
		lista02.showRightToLeft();
		while(lista03.haveNext()) {
			System.out.print(" " + lista03.getCurrent().getValue().toString() + " ");
		}
		System.out.println();
	}
}
