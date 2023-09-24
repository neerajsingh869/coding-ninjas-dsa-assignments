package oops;

public class Polynomial1 {
	DynamicArray polyArr;

    public Polynomial1(){
        polyArr = new DynamicArray();
    }
	/* This function sets coefficient for a particular degree value, if degree is not there in the polynomial
	 *  then corresponding term(with specified degree and value) is added in the polynomial. If the degree
	 *  is already present in the polynomial then previous coefficient is replaced by
	 *  new coefficient value passed as function argument
	*/
	public void setCoefficient(int degree, int coeff){
		polyArr.add(degree, coeff);
	}
	
	// Prints all the terms(only terms with non zero coefficients are to be printed) in increasing order of degree. 
	public void print(){
		int n = polyArr.size();
        for(int i = 0; i<n; i++){
            if(polyArr.get(i) != 0){
            	System.out.print(polyArr.get(i) + "x" + i + " ");
            }
        }
	}

	
	// Adds two polynomials and returns a new polynomial which has result
	public Polynomial1 add(Polynomial1 p){
		Polynomial1 newP = new Polynomial1();
        newP.polyArr = DynamicArray.add(this.polyArr, p.polyArr); 
        return newP;
	}
	
	// Subtracts two polynomials and returns a new polynomial which has result
	public Polynomial1 subtract(Polynomial1 p){
		Polynomial1 newP = new Polynomial1();
        newP.polyArr = DynamicArray.subtract(this.polyArr, p.polyArr); 
        return newP;
	}
	
	// Multiply two polynomials and returns a new polynomial which has result
	public Polynomial1 multiply(Polynomial1 p){
		Polynomial1 newP = new Polynomial1();
        newP.polyArr = DynamicArray.multiply(this.polyArr, p.polyArr); 
        return newP;
	}
}
