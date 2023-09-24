package oops;

import java.lang.Math;

public class Fraction {
	private int numerator;
	private int denominator;
	// Parameterized constructor to construct a Fraction object
	public Fraction(int numerator, int denominator) {
		if(denominator == 0) {
			// Throw error
			throw new ArithmeticException("Denominator can't be 0");
		}
		this.numerator = numerator;
		this.denominator = denominator;
		simplify();
	}
	// Function to convert the fraction into simplest form
	private void simplify() {
		int gcd = 1;
		int n = Math.min(numerator, denominator);
		for(int i = 2; i<=n; i++) {
			if(numerator%i == 0 && denominator%i == 0) {
				gcd = i;
			}
		}
		numerator = numerator/gcd;
		denominator = denominator/gcd;
	}
	
	public void setNumerator(int numerator) {
		this.numerator = numerator;
		simplify();
	}
	
	public int getNumerator() {
		return numerator;
	}
	
	public void setDenominator(int denominator) {
		if(denominator == 0) {
			// Throw error
			throw new ArithmeticException("Denominator can't be 0");
		}
		this.denominator = denominator;
		simplify();
	}
	
	public int getDenominator() {
		return denominator;
	}

	public void print() {
		if(denominator != 1) {
			System.out.println(numerator + "/" + denominator);
		}
		else {
			System.out.println(numerator);
		}
	}
	// Function to increment the fraction by 1
	public void increment() {
		numerator = numerator + denominator;
		simplify();
	}
	// Function to add two fractions
	public void add(Fraction f2) {
		numerator = (numerator*f2.denominator) +
						(denominator*f2.numerator);
		denominator = denominator*f2.denominator;
		simplify();
	}
	// Function to add two functions which return third function
	public static Fraction add(Fraction f1, Fraction f2) {
		int num = (f1.numerator*f2.denominator) +
						(f1.denominator*f2.numerator);
		int den = f1.denominator*f2.denominator;
		Fraction f3 = new Fraction(num, den);
		return f3;
	}
	// Function to subtract two fractions
	public void subtract(Fraction f2) {
		numerator = (numerator*f2.denominator) - 
					(denominator*f2.numerator);
		denominator = denominator*f2.denominator;
		simplify();
	}
	// Function to subtract two fractions which return the new fraction
	public static Fraction subtract(Fraction f1, Fraction f2) {
		int num = (f1.numerator*f2.denominator) - 
				(f1.denominator*f2.numerator);
		int den = f1.denominator*f2.denominator;
		Fraction f3 = new Fraction(num, den);
		return f3;
	}
	// Function to multiply two fractions
	public void multiply(Fraction f2) {
		numerator = (numerator*f2.numerator);
		denominator = (denominator*f2.denominator);
		simplify();
	}
	// Function to multiply two fractions which return the new fraction
	public static Fraction multiply(Fraction f1, Fraction f2) {
		int num = f1.numerator*f2.numerator;
		int den = f1.denominator*f2.denominator;
		Fraction f3 = new Fraction(num, den);
		return f3;
	}
	// Function to divide two fractions
	public void divideBy(Fraction f2) {
		if(f2.numerator == 0) {
			throw new ArithmeticException("Numerator of f2 can't be 0");
		}
		numerator = numerator*f2.denominator;
		denominator = denominator*f2.numerator;
		simplify();
	}
	// Function to divide two fractions which return the new fraction
	public static Fraction divideBy(Fraction f1, Fraction f2) {
		if(f2.numerator == 0) {
			throw new ArithmeticException("Numerator of f2 can't be 0");
		}
		int num = f1.numerator*f2.denominator;
		int den = f1.denominator*f2.numerator;
		Fraction f3 = new Fraction(num, den);
		return f3;
	}
	
}
