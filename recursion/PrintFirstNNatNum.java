package recursion;

public class PrintFirstNNatNum {

	/*
	 * Given the number 'n', write a code to print numbers 
	 * from 1 to n in increasing order recursively.
	 */
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static void print(int n){
    	if(n == 0){
            return;
        }
        print(n-1);
        System.out.print(n + " ");
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
