package recursion;

public class BinarySearch {
	
	public static int binarySearch(int[] input, int x) {
		int n = input.length;
		return binarySearch(input, 0, n-1, x);
	}
	
	public static int binarySearch(int[] input, int st, int end, int x) {
		if(st > end) {
			return -1;
		}
		int mid = st + (end-st)/2;
		if(input[mid] == x) {
			return mid;
		}
		else if(input[mid] > x){
			return binarySearch(input, st, mid-1, x);
		}
		else {
			return binarySearch(input, mid+1, end, x);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 4, 5, 8, 9, 10};
		int x = 5;
		System.out.println(binarySearch(arr, x));
	}

}
