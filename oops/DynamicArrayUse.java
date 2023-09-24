package oops;

public class DynamicArrayUse {

	public static void main(String[] args) {
//		DynamicArray d = new DynamicArray();
//		for(int i = 1; i<5; i++) {
//			d.add(i+100);
//		}
//		System.out.println(d.size());
//		System.out.println(d.get(1));
//		d.set(3, 170);
//		System.out.println(d.get(3));
//		d.add(99, 200);
//		System.out.println(d.size());
//		while(!d.isEmpty()) {
//			System.out.println(d.removeLast());
//			System.out.println("size - " + d.size());
//		}
		
		/* CHECKING THE FUNCTIONALITY OF HIGH-FI WORKS */
		DynamicArray d1 = new DynamicArray();
		for(int i = 0; i<10; i++) {
			d1.add(i+2, i+1);
		}
		for(int i = 0; i<d1.size(); i++) {
			System.out.print(d1.get(i)+ " ");
		}
		System.out.println();
		DynamicArray d2 = new DynamicArray();
		for(int i = 0; i<5; i++) {
			d2.add(i+2, 100+i);
		}
		for(int i = 0; i<d2.size(); i++) {
			System.out.print(d2.get(i)+ " ");
		}
		System.out.println();
		DynamicArray d3 = DynamicArray.add(d1, d2);
		for(int i = 0; i<d3.size(); i++) {
			System.out.print(d3.get(i)+ " ");
		}
		System.out.println();
		DynamicArray d4 = DynamicArray.subtract(d1, d2);
		for(int i = 0; i<d4.size(); i++) {
			System.out.print(d4.get(i)+ " ");
		}
		System.out.println();
		DynamicArray d5 = DynamicArray.multiply(d1, d2);
		for(int i = 0; i<d5.size(); i++) {
			System.out.print(d5.get(i)+ " ");
		}
		System.out.println();
		DynamicArray d6 = new DynamicArray();
		int[] degree1 = {3, 1, 7};
		int[] coeff1 = {1, 2, 3};
		for(int i = 0; i<degree1.length; i++) {
			d6.add(degree1[i],coeff1[i]);
		}
		for(int i = 0; i<d6.size(); i++) {
			System.out.print(d6.get(i) + " ");
		}
	}

}
