package oops;

import java.util.Scanner;

public class PolynomialUse {
	
	public static void main(String[] args) {
		int[] degree1 = {3, 1, 7};
		int[] coeff1 = {1, 2, 3};
		Polynomial2 first = new Polynomial2();
		for(int i = 0; i<degree1.length; i++) {
			first.setCoefficient(degree1[i],coeff1[i]);
		}
		first.print();
		System.out.println();
		int[] degree2 = {2, 1};
		int[] coeff2 = {7, 8};
		Polynomial2 second = new Polynomial2();
		for(int i = 0; i < degree2.length; i++){
			second.setCoefficient(degree2[i],coeff2[i]);
		}
		second.print();
		System.out.println();
		Scanner s = new Scanner(System.in);
		int choice = s.nextInt();
		Polynomial2 result;
		switch(choice) {
		// Add
		case 1: 
			result = first.add(second);
			result.print();
			break;
		// Subtract	
		case 2 :
			result = first.subtract(second);
			result.print();
			break;
		// Multiply
		case 3 :
			result = first.multiply(second);
			result.print();
			break;
		default:
			System.out.println("Invalid Choice");
		}
	}
	
}
