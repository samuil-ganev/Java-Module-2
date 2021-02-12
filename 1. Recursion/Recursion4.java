package schl;

public class Recursion4 {

	public static void main(String[] args) {
		System.out.println(recursive(3,4));
		System.out.println(iterative(3,4));
		//System.out.println(fibonacci(100));
		
	}
	public static double recursive (double x, int n) {
		if (n == 0) {
			return 1;
		}
		else if (n == 1) {
			return x;
		}
		else {
			return x * recursive (x, n-1);
		}
	}
	
//	public static long fibonacci (long index) {
//		if (index == 0) {
//			return 0;
//		}
//		else if (index == 1) {
//			return 1;
//		}
//		else {
//			return fibonacci(index - 1) + fibonacci (index - 2);
//		}
//	}
	
	public static double iterative (double x, int n) {
		double product = 1;
		for(int  i = 0; i < n; ++i) {
			product *= x;
		}
		return product;
	}
}
