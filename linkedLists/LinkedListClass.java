package linkedLists;

import java.util.LinkedList;

public class LinkedListClass {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(100);
		list.add(200);
		list.add(400);
		list.add(1, 500);
		list.remove();
		System.out.println(list.get(1));
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
