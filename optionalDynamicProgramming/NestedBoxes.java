package optionalDynamicProgramming;

import java.util.*;

class Dimension {
	int width;
	int height;
	Dimension(int width, int height) {
		this.width = width;
		this.height = height;
	}
}

public class NestedBoxes {
	
	/*
	 * In a kitchen, there are a lot of hollow empty boxes of different sizes. Out of which smallest box is in the second smallest and this box in turn is in the next one and so forth. But there is a limitation of space in the kitchen due to which we have to think of some another way of nesting, so that we will end up with fewer number of boxes. So, we unpack all the boxes and measure the width and height of those boxes.
A box with width w1 and height h1 will fit in another box of width w2 and height h2, only if w1<w2 and h1<h2.
So, can you calculate the smallest number of nested boxes possible .
Input Format:
The first line of input contains the total number of boxes(n) present in the kitchen.
The second line of input contains 2n integers w1, h1, w2, h2,.....,wn, hn, where wi is the width and hi is the height ofbox number i.
Output Format:
The output contains the minimum number of nested boxes possible.
Constraints:
1 ≤ n ≤ 20000
1 ≤ wi, hi ≤ 10000
Sample Input:
4
10 10 20 30 40 50 39 51
Sample Output:
2
Explanation:
The box with size (10,10) can fit in box with size (20,30) which in turn can fit in box with size (40,50), but now this box can't fit in the box with size (39,51) as this box has lower width but more height than the nested box of size (40,50).
Hence we have 2 nested boxes at the end.
	 */
	
	public static int minBoxes(Dimension[] boxes) {
		// sort boxes array in decreasing order of width and
		// if width are same, then in increasing order of height
		Arrays.sort(boxes, new Comparator<Dimension>() {
			@Override
			public int compare(Dimension box1, Dimension box2){
				if(box1.width == box2.width){
					return box1.height - box2.height;
				}
				return box2.width - box1.width;
			}
		});
		// create new array list to do all nesting of boxes
		ArrayList<Dimension> nesting = new ArrayList<>();
		nesting.add(boxes[0]);
		for(int i = 1; i<boxes.length; i++){
			// use binary search to find the next closest larger box
			int start = 0, end = nesting.size() - 1;
			while(start <= end){
				int mid = start + (end-start)/2;
				if(nesting.get(mid).height <= boxes[i].height){
					start = mid+1;
				}
				else{
					end = mid-1;
				}
			}
			// make new box if nesting can't happen
			if(start == nesting.size()){
				nesting.add(boxes[i]);
			}
			// update the nested box if nesting can happen
			else{
				nesting.get(start).width = boxes[i].width;
				nesting.get(start).height = boxes[i].height;
			}
		}
		return nesting.size();
    }
	
	public static void main(String[] args) {
	   Scanner s = new Scanner(System.in);
	   int n = s.nextInt();
	   Dimension[] boxes = new Dimension[n];
	   for(int i = 0; i < n; ++i) {
		   int width = s.nextInt();
		   int height = s.nextInt();
		   boxes[i] = new Dimension(width, height);
	   } 
	   System.out.print(minBoxes(boxes));
	   s.close();
   }

}
