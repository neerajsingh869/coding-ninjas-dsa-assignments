package oops;

// Method 1 (Making class in other file - Advisable)
public class Student {
	String name;
	private int rollNo;
	
	public Student() {
		
	}
	
	public Student(String name, int rollNo) {
		this.name = name;
		this.rollNo = rollNo;
	}
	
	public int getRollNo() {
		return rollNo;
	}
	
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
		System.out.println(this);
	}
}
