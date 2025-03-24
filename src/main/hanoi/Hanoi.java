package main.hanoi;

public class Hanoi {
	public static void hanoi(int n, char origin, char auxiliary, char destiny) {
		if(n == 1) {
			System.out.println(String.format("Mover disco %d de %s para %s", n, origin, destiny));
			return;
		}
		hanoi(n - 1, origin, destiny, auxiliary);
		System.out.println(String.format("Mover disco %d de %s para %s", n, origin, destiny));
		hanoi(n - 1, auxiliary, origin, destiny);
	}
	public static void hanoiTower(int n, Tower<Disk> origin, Tower<Disk> auxiliary, Tower<Disk> destiny) {
		if(n == 1) {
			moveDisks(origin, destiny);
			return;
		}
		hanoiTower(n - 1, origin, destiny, auxiliary);
		moveDisks(origin, destiny);
		hanoiTower(n - 1, auxiliary, origin, destiny);
		
	}
	private static boolean isBigger(Tower<Disk> origin, Tower<Disk> destiny) {
		if(origin.isEmpty()) {
			return false;
		}
		if(!destiny.isEmpty()) {
			return origin.getTopValue().value < destiny.getTopValue().value;
		}
		return true;
	}
	private static void moveDisks(Tower<Disk> from, Tower<Disk> to) {
		
		System.out.println("Mover disco " + from.getTopValue().value + " de " + from.getTitle() + " para " +to.getTitle());
		to.add(from.remove());
	}
}
