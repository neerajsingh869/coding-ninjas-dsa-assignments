package oops;

class Vehicle {
	String name;
	int price;
	Vehicle() {
		System.out.println("Parent constructor called!");
	}
}

class Honda extends Vehicle {
	String version;
	int noOfTyres;
	Honda(){
		System.out.println("Child constructor called!");
	}
}

public class Rough {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Honda h = new Honda();
	}

}
