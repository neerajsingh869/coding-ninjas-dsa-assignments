package roughWork;

public class Rough1 {
	
	public final static int M = 1000000007;
	
	public static long fact(int n) {
		if(n == 0) {
			return 1;
		}
		long ans = 1;
		for(int i = 1; i<=n; i++) {
			ans = (ans*i)%M;
		}
		return ans;
	}
	
	public static long ways(int n) {
		long ans = 0;
		for(int i = 1; i<n; i++) {
			long val = fact(n) / (fact(n-i) * fact(i));
			ans += val;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int n = 10;
		System.out.println(ways(n));
//		System.out.println(M);
	}
	
}
