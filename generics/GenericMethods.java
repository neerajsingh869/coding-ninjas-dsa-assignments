package generics;

public class GenericMethods {
	
	public static<T> void printArray(T[] arr) {
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {
		Integer arr[] = new Integer[5];
		for(int i = 0; i<5; i++) {
			arr[i] = i+1;
		}
		printArray(arr);
		System.out.println();
		
		Character arr2[] = new Character[10];
		for(int i = 0; i<10; i++) {
			arr2[i] = (char)('a' + i);
		}
		printArray(arr2);
		System.out.println();
		
		Vehicle arr3[] = new Vehicle[5];
		for(int i = 0; i<5; i++) {
			arr3[i] = new Vehicle(i+1, "abc");
		}
		printArray(arr3);
	}

}
