package oops;

public class Professor extends Person {
	String collegeName;
	String highestDegree;
	int h_index;
	int totalCitations;
	
	public void getCollege() {
		System.out.println("College: " + collegeName);
	}
	
	public final void print() {
		System.out.println("Name: " + name + " h-index " + h_index);
	}
}
