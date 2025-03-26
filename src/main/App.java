 package main;

import main.hanoi.tree.*;

public class App {
	public static void main(String[] args) {

		Arvore<String> tree = new Arvore<String>();

		tree.add("eeeeeee");
		tree.add("cabo");
		tree.add("nao sei mais");
		tree.add("cabeleleira leila");
		tree.add("ping pong");
		tree.add("paralelepipedo");
		
		System.out.println("foi");

		System.out.println(tree.exist("nao sei mais"));

		tree.remove("nao sei mais");

		System.out.println(tree.exist("nao sei mais"));
		System.out.println("jahgs");
		// Tower<Disk> origin = new Tower<Disk>('A');
		// //origin.add(new Disk(5));
		// //origin.add(new Disk(4));
		// //origin.add(new Disk(3));
		// //origin.add(new Disk(2));
		// origin.add(new Disk(1));
		
		// Tower<Disk> auxiliary = new Tower<Disk>('B');
		// Tower<Disk> destiny = new Tower<Disk>('C');
		
		// Hanoi.hanoiTower(origin.length(), origin, auxiliary, destiny);
		// //Hanoi.hanoi(3, 'A', 'B', 'C');
		// System.out.println("Acabou");
		 
	}
	
	/**
	 * while(towers[2].length() < 5) {
			for(int i = 0; i < towers.length; i++) {
				for(int j = 0; j < towers.length; j++) {
					if(j != i) {
						if(isBigger(towers[i], towers[j])) {
							moveDisks(towers[i], towers[j]);
							System.out.println("Mov: " + count + " A: " + towers[0].length() + " B: " + towers[1].length() + " C: " + towers[2].length());
							count++;
						}
					}
					
				}
			}
		}
	 */
}
