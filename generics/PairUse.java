package generics;

public class PairUse {
	
	public static void main(String[] args) {
//		Pair p = new Pair(5, 10);
//		System.out.println("First: " + p.getFirst() + " Second: " + p.getSecond());
		Pair<String> pC = new Pair<String>("a", "b");
		System.out.println(pC.getFirst() + " " + pC.getSecond());
		
		Pair<Integer> pI = new Pair<Integer>(10, 20);
		System.out.println(pI.getFirst() + " " + pI.getSecond());
		
		Pair<Pair<String>> pp = new Pair<>();
		System.out.println(pp.getFirst() + " " + pp.getSecond());
		
		Pair<Pair<Integer>> ppI = new Pair<>();
		ppI.setFirst(pI);
		System.out.println(ppI.getFirst() + " " + ppI.getSecond());
		System.out.println(ppI.getFirst().getFirst() + " " + ppI.getFirst().getSecond());
	}
	
}
