package generics;

public class Pair3Use {

	public static void main(String[] args) {
		Pair3<String, Integer> pSI = new Pair3<>();
		System.out.println(pSI.getFirst() + " " + pSI.getSecond());
		
		Pair3<Integer, String> pIS = new Pair3<>(10, "def");
		System.out.println(pIS.getFirst() + " " + pIS.getSecond());
		
		Pair3<Pair3<Integer, String>, String> ppS = new Pair3<>();
		ppS.setFirst(pIS);
		ppS.setSecond("abc");
		System.out.println(ppS.getFirst() + " " + ppS.getSecond());
		System.out.println(ppS.getFirst().getFirst() + " " + ppS.getFirst().getSecond());
		
		Pair3<Pair3<Integer, String>, Pair3<String, Integer>> ppp = new Pair3<>(pIS, pSI);
		// ppS.setFirst(pIS);
		// ppS.setSecond(pSI);
		System.out.println(ppp.getFirst() + " " + ppp.getSecond());
		System.out.println(ppp.getFirst().getFirst() + " " + ppp.getFirst().getSecond());
		System.out.println(ppp.getSecond().getFirst() + " " + ppp.getSecond().getSecond());
	}

}
