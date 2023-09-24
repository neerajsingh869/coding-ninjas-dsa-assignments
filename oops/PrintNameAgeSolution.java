package oops;

import java.util.Scanner;

class Person1 {
	
	private String name;
    private int age;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
}

class PrintNameAgeSolution {
	
	public static void main(String args[]) {
	    Scanner s = new Scanner(System.in);
        String name = s.next();
        int age = s.nextInt();
        Person1 p = new Person1();
        p.setName(name);
        p.setAge(age);
        System.out.println("The name of the person is " + p.getName() +
                          " and the age is " + p.getAge() + ".");
	}
}
		
