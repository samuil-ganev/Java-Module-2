package schl;

public class Recursion2 {

	public static void main(String[] args) {
		xMethod(1234567);
		System.out.println("");
		iterative(1234567);

	}
	public static void xMethod(int n) {
        if (n > 0) {
            System.out.print(n % 10);
            xMethod(n / 10);
        }
	}
	
	public static void iterative (int n) {
		while(n > 0) {
			System.out.print(n%10);
			n = n/10;
		}
	}

}
