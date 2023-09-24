package generics;

public class Pair2Use {
	
	public static void main(String[] args) {
		Pair2<String> pS = new Pair2<>();
		System.out.println(pS.getFirst() + " " + pS.getSecond());
		
		Pair2<String> pS1 = new Pair2<>("abc", 40);
		System.out.println(pS1.getFirst() + " " + pS1.getSecond());
	}
	
}
