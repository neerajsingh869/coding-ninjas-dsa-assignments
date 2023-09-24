package generics;

public class GenericsMethod2 {
	
	public static<T extends Vehicle> void printArray(T[] arr) {
		for(int i = 0; i<arr.length; i++) {
			arr[i].print();
		}
	}

	public static void main(String[] args) {
		Vehicle arr3[] = new Vehicle[5];
		for(int i = 0; i<5; i++) {
			arr3[i] = new Vehicle(i+1, "abc");
		}
		printArray(arr3);
	}

}
