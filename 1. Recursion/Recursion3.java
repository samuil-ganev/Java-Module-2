package schl;

public class Recursion3 {

	public static void main(String[] args) {
		System.out.println(recursive(5));
		System.out.println(iterative(5));
	}
	public static long recursive (int n) {
		if (n == 0) {
			return 1;
		}
		else if (n == 1) {
			return 2;
		}
		else {
			return 2 * recursive (n-1);
		}
	}
	
	public static long iterative (int n) {
		long product = 1;
		for(int  i = 0; i < n; ++i) {
			product *= 2;
		}
		return product;
	}

}
