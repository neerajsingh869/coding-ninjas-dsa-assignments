package recursion;

public class GeometricSum {
	
	/*
	 * Given k, find the geometric sum i.e.
	 * 		1 + 1/2 + 1/4 + 1/8 + ... + 1/(2^k) 
	 * using recursion.
	 */
	
	// Time Complexity -> O(k), Space Complexity -> O(k)
	public static double findGeometricSum(int k){
        if(k == 0){
            return 1.0;
        }
        return (1/Math.pow(2, k)) + findGeometricSum(k-1);
	}

	public static void main(String[] args) {
		
	}

}
