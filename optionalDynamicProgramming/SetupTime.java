package optionalDynamicProgramming;

import java.util.*;

class Student {
	int height;
	int weight;
	Student(int height, int weight) {
		this.height = height;
		this.weight = weight;
	}
}

public class SetupTime {
	
	/*
	 * There are n students in a class. The height and weight of those students are known. A row has to be made in the morning assembly and make those students stand in the row one by one. The setup time is the time to make those students stand in a row. The setup time is given as:
(i) The setup time for the first student is 1 minute.
(ii) Right after a student of height l and weight w , the next student needs no setup time for a student of height l' and weight w' if l ≤ l' and w ≤ w'.
Otherwise, it will need 1 minute for setup.
You have to find the minimum setup time in minutes to make all those students stand in a row.
Input Format:
The first line of input has an integer n, that represents the number of students, and the second line contains 2n positive integers l1 , w1 , l2 , w2 ,..., ln , wn, where li and wi are the height and weight of the i th student respectively.
Output Format:
The output should contain the minimum setup time in minutes
Constraints:
 1 <= n <= 5000 
 1<=li,wi<=10000
Sample Input:
3 
2 2 1 1 2 2
Sample Output:
1
	 */
	
	public static int minSetupTime(Student[] students) {
		// sort students array in increasing order of weight and
		// if weight are same, then in increasing order of height
		Arrays.sort(students, new Comparator<Student>() {
			@Override
			public int compare(Student std1, Student std2){
				if(std1.weight == std2.weight){
					return std1.height - std2.height;
				}
				return std1.weight - std2.weight;
			}
		});
		// create new arraylist to do all setting of students
		ArrayList<Student> setting = new ArrayList<>();
		// overall student at indices will have height in 
		// decreasing order
		setting.add(students[0]);
		for(int i = 1; i<students.length; i++){
			// use binary search to find the next closest smaller student
			int start = 0, end = setting.size() - 1;
			while(start <= end){
				int mid = start + (end-start)/2;
				if(setting.get(mid).height > students[i].height){
					start = mid+1;
				}
				else{
					end = mid-1;
				}
			}
			// make new box if setting can't happen
			if(start == setting.size()){
				setting.add(students[i]);
			}
			// update the nested box if setting can happen
			else{
				setting.get(start).weight = students[i].weight;
				setting.get(start).height = students[i].height;
			}
		}
		return setting.size();
    }
	
	public static void main(String[] args) {
	   Scanner s = new Scanner(System.in);
	   int n = s.nextInt();
	   Student[] students = new Student[n];
	   for(int i = 0; i < n; ++i) {
		   int height = s.nextInt();
		   int weight = s.nextInt();
		   students[i] = new Student(height, weight);
	   } 
	   System.out.print(minSetupTime(students));
	   s.close();
   }

}
