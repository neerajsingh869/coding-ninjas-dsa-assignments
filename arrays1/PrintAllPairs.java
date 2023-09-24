package arrays1;

public class PrintAllPairs {
	
	public static void printAllPairs(int[] arr) {
		for(int i = 0; i<arr.length; i++) {
			for(int j = i+1; j<arr.length; j++) {
				System.out.println("("+arr[i]+" "+arr[j]+")");
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {5, 7, 1, 2, 8};
		printAllPairs(arr);
	}

}
