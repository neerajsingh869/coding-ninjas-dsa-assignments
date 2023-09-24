package generics;

public class Pair2<T> {
	private T first;
	private int second;
	
	public Pair2() {};
	
	public Pair2(T first, int second) {
		this.first = first;
		this.second = second;
	}
	
	public T getFirst() {
		return first;
	}
	
	public void setFirst(T first) {
		this.first = first;
	}
	
	public int getSecond() {
		return second;
	}
	
	public void setSecond(int second) {
		this.second = second;
	}
}
