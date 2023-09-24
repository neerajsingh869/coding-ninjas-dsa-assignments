package oops;

public class DynamicArray {
	// Creating the reference of array
	private int[] data;
	// size will work as nextElementIndex
	// as well as the size of the array
	private int size = 0;
	
	// Default constructor
	public DynamicArray() {
		data = new int[5];
	}
	
	// Function to add element at the last in the array
	public void add(int num) {
		if(size == data.length) {
			doubleArray();
		}
		data[size++] = num;
	}
	
	// Function to add element at ith index
	public void add(int idx, int num) {
		while(idx >= data.length) {
			doubleArray();
		}
		data[idx] = num;
		if(idx+1 > size) {
			size = idx+1;
		}
	}
	
	// Function to double the array
	private void doubleArray() {
		int[] temp = new int[2*data.length];
		for(int i = 0; i<size; i++) {
			temp[i] = data[i];
		}
		data = temp;
	}
	
	// Function to get the element at idx index
	public int get(int idx) {
		if(idx >= size()) {
			// throw error
			throw new ArithmeticException("Invalid Index");
		}
		return data[idx];
	}
	
	// Function to replace the element at idx index with num
	public void set(int idx, int num) {
		if(idx >= size()) {
			// throw error
			throw new ArithmeticException("Invalid Index");
		}
		data[idx] = num;
	}
	
	// Function to remove last element and return its value
	public int removeLast() {
		if(isEmpty()) {
			// throw error
			throw new ArithmeticException("Array is Empty");
		}
		int val = data[size-1];
		data[size-1] = 0;
		size--;	
		return val;
	}
	
	// Function to return the size of the array i.e
	// the number of elements inserted till now by user
	public int size() {
		return size;
	}
	
	// Function to tell whether user has inserted any
	// element in the array or not
	public boolean isEmpty() {
		return size() == 0;
	}
	
	/* *** HIGH-FI ARITHMETIC OPERATIONS ON DYNAMIC ARRAYS *** */
	public static DynamicArray add(DynamicArray d1, DynamicArray d2) {
		DynamicArray ans = new DynamicArray();
		int i = 0;
		while(i<d1.size() && i<d2.size()) {
			ans.add(d1.get(i) + d2.get(i));
			i++;
		}
		while(i<d1.size()) {
			ans.add(d1.get(i));
			i++;
		}
		while(i<d2.size()) {
			ans.add(d2.size());
			i++;
		}
		return ans;
	}
	
	public static DynamicArray subtract(DynamicArray d1, DynamicArray d2) {
		DynamicArray ans = new DynamicArray();
		int i = 0;
		while(i<d1.size() && i<d2.size()) {
			ans.add(d1.get(i) - d2.get(i));
			i++;
		}
		while(i<d1.size()) {
			ans.add(d1.get(i));
			i++;
		}
		while(i<d2.size()) {
			ans.add(d2.size());
			i++;
		}
		return ans;
	}
	
	public static DynamicArray multiply(DynamicArray d1, DynamicArray d2) {
		int n = d1.size(), m = d2.size();
		DynamicArray ans = new DynamicArray();
		for(int i = 0; i<n+m-1; i++){
            ans.add(0);
        }
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				int value = d1.get(i)*d2.get(j);
				ans.add(i+j, ans.get(i+j) + value);
			}
		}
		return ans;
	}
}
