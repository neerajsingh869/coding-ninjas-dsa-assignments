package arrayList;

import java.util.ArrayList;

public class RemoveConsDuplicates {
	
	// Method 1 of removing consecutive duplicates
	public static ArrayList<Integer> removeConsDuplicates1(ArrayList<Integer> arr){
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i = 0; i<arr.size()-1; i++) {
			if(arr.get(i) != arr.get(i+1)) {
				ans.add(arr.get(i));
			}
		}
		ans.add(arr.get(arr.size()-1));
		return ans;
	}
	
	// Method 2 of removing consecutive duplicates
	public static void removeConsDuplicates2(ArrayList<Integer> arr) {
		for(int i = 0; i<arr.size()-1; i++) {
			if(arr.get(i) == arr.get(i+1)) {
				arr.remove(i);
				i--;
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(10);
		arr.add(10);
		arr.add(20);
		arr.add(20);
		arr.add(20);
		arr.add(30);
		arr.add(40);
		ArrayList<Integer> arr1 = removeConsDuplicates1(arr);
		for(Integer i:arr1) {
			System.out.print(i+ " ");
		}
		System.out.println();
		removeConsDuplicates2(arr);
		for(Integer i: arr) {
			System.out.print(i+" ");
		}
	}

}
