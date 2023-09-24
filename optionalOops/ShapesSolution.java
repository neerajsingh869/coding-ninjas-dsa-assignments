package optionalOops;

import java.util.*;

/*
 * Given a 3-D shape find the lateral surface area, total surface area and volume of the given shape.
1. Sphere (Given with radius)
2. Cylinder (Given with radius and height)
3. Cube (Given with side)
Do this using classes for each type of figure that inherits a class containing LSA, TSA.


Note : Use pi = 3.


Input Format :
First line takes an integer x, denoting the shape (1 for sphere, 2 for cylinder , 3 for cube).
Next Line -> 
For sphere: One integer (radius)
For Cylinder: Two integers(Radius and height)
For Cube: One integer(Side)
Output Format:
Three space spaced integers in a single line (LSA, TSA and Volume of the shape)
Sample Input 1:
1
3
Sample Output 1:
108 108 108
Sample Input 2:
2
2 4
Sample Output 2:
48 72 48
 */

class Shapes{
    int lsa;
    int tsa;
    int volume;
	final static int pi = 3;
    void prints()
    {
        System.out.print(lsa+" "+tsa+" "+volume);
    }
}
class sphere extends Shapes{
	private int radius;
	sphere(int radius){
		this.radius = radius;
		
	}
	void print(){
		lsa = 4*pi*radius*radius;
		tsa = lsa;
		volume = 4*pi*radius*radius*radius/3;
		prints();
	}

}
class cylinder extends Shapes{
    private int radius;
	private int height;
	cylinder(int radius, int height){
		this.radius = radius;
		this.height = height;
		
	}
	void print(){
		lsa = 2*pi*radius*height;
		tsa = lsa + 2*pi*radius*radius;
		volume = pi*radius*radius*height;
		prints();
	}
}
class cube extends Shapes{
    private int length;
	cube(int length){
		this.length = length;
		
	}
	void print(){
		lsa = 4*length*length;
		tsa = 6*length*length;
		volume = length*length*length;
		prints();
	}
}
public class ShapesSolution {
	public static void main (String[] args) {
		Scanner s=new Scanner(System.in);
		int x=s.nextInt();
		    if(x==1)
		    {
		        int r=s.nextInt();
		        sphere sp=new sphere(r);
		        sp.print();
		        
		    }
		    else if(x==2) 
		    {
		        int r=s.nextInt();
		        int h=s.nextInt();
		        cylinder c=new cylinder(r,h);
		        c.print();
		    }
		    else
		    {
		        int r=s.nextInt();
		        cube c=new cube(r);
		        c.print();
		    }
		
	}
}
