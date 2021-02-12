package schl;

public class Recursion1 {

	public static void main(String[] args) {
		System.out.println("Sum is " + xMethod(5));
		System.out.println("Sum is " + iterative(5));
		
	}
	public static int xMethod(int n) {
        if (n == 1)
            return 1;
        else
            return n + xMethod(n - 1);
	}
	
	public static int iterative (int n) {
		int sum = 0;
		for(int i = n; i > 0;--i) {
			sum += i;
		}
		return sum;
	}

}
