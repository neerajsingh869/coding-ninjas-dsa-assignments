package generics;

public class Student implements PrintInterface{
	
	private String name;
	private int rollNo;
	
	Student(String name, int rollNo){
		this.name = name;
		this.rollNo = rollNo;
	}
	
	public void print() {
		System.out.println(name + " " + rollNo);
	}
	
}
