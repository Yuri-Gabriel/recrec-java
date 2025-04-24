 package main;

import main.tree.Node;

@FunctionalInterface
interface Funcional {
    public void action();
}

public class App {
	public static void main(String[] args) {
		testeFuncional(() -> {
			System.out.println("oi oi oi");
		});
	}

	public static void testeFuncional(Funcional func) {
        func.action();
    }
}
