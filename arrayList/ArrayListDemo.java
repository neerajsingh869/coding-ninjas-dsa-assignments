package arrayList;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(5);;
		arr.add(10);
		arr.add(40);
		arr.add(50);
		arr.add(3, 70);
		System.out.println(arr.size());
		System.out.println(arr.get(3));
		System.out.println(arr.isEmpty());
		System.out.println(arr.contains(40));
		// Method 1 of Printing array elements
		System.out.println(arr);
		// Method 2 of Printing array elements
		for(Integer i:arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		// Method 3 of Printing array elements
		for(int i = 0; i<arr.size(); i++) {
			System.out.print(arr.get(i) + " ");
		}
	}

}
