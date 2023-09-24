package oops;

// Method 2 (Including class in same file - Not advisable)
class Car{
	int number;
	String company;
}

public class StudentsUse {
	public static void main(String[] args) {
		Student s1 = new Student("Shailesh", 23);
//		s1.name = "Shailesh";
//		s1.setRollNo(23);
//		System.out.println(s1);
		System.out.println(s1.name + " " + s1.getRollNo());
		Car c1 = new Car();
		c1.number = 1004;
		c1.company = "Tata";
		System.out.println(c1.number + " " + c1.company);
	}
}
