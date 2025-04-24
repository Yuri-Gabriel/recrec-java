package main.list.duple;

public class ListDuplNumber<N extends Number> extends ListDupl<N> {
    public void addOddNumberInRight(N number) {
		if(number.doubleValue() % 2 != 0) {
			this.addRight(number);
		}
	}

	public void addOddNumberInLeft(N number) {
		if(number.doubleValue() % 2 != 0) {
			this.addLeft(number);
		}
	}
}
