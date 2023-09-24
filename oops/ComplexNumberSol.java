package oops;

import java.util.Scanner;

/*
 * A ComplexNumber class contains two data members : one is the real part (R) and the other is imaginary (I) (both integers).
Implement the Complex numbers class that contains following functions -
1. constructor
You need to create the appropriate constructor.
2. plus -
This function adds two given complex numbers and updates the first complex number.
e.g.
if C1 = 4 + i5 and C2 = 3 +i1
C1.plus(C2) results in: 
C1 = 7 + i6 and C2 = 3 + i1
3. multiply -
This function multiplies two given complex numbers and updates the first complex number.
e.g.
if C1 = 4 + i5 and C2 = 1 + i2
C1.multiply(C2) results in: 
C1 = -6 + i13 and C2 = 1 + i2
4. print -
This function prints the given complex number in the following format :
a + ib
Note : There is space before and after '+' (plus sign) and no space between 'i' (iota symbol) and b.
Input Format :
Line 1 : Two integers - real and imaginary part of 1st complex number
Line 2 : Two integers - real and imaginary part of 2nd complex number
Line 3 : An integer representing choice (1 or 2) (1 represents plus function will be called and 2 represents multiply function will be called)
Output format :
Check details of 'print' function given above.
Sample Input 1 :
4 5
6 7
1
Sample Output 1 :
10 + i12
Sample Input 2 :
4 5
6 7
2
Sample Output 2 :
-11 + i58

 */

class ComplexNumbers {
	private int real;
    private int imaginary;
    public ComplexNumbers(int real, int imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }
    public void plus(ComplexNumbers c2){
        int real = this.real + c2.real;
        int imaginary = this.imaginary + c2.imaginary;
        this.real = real;
        this.imaginary = imaginary;
    }
    public void multiply(ComplexNumbers c2){
        int real = this.real*c2.real - this.imaginary*c2.imaginary;
        int imaginary = this.real*c2.imaginary + this.imaginary*c2.real;
        this.real = real;
        this.imaginary = imaginary;
    }
    public void print(){
        System.out.print(this.real + " + i" + this.imaginary);
    }
}

class ComplexNumberSol {
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
        int real1 = s.nextInt();
        int img1 = s.nextInt();
        ComplexNumbers cn1 = new ComplexNumbers(real1, img1);
        int real2 = s.nextInt();
        int img2 = s.nextInt();
        ComplexNumbers cn2 = new ComplexNumbers(real2, img2);
        int choice = s.nextInt();
        switch(choice){
            case 1:
                cn1.plus(cn2);
                cn1.print();
                break;
            case 2:
                cn1.multiply(cn2);
                cn1.print();
                break;
        }
	}
}
		