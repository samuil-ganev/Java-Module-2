package schl;

public class PowerRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(powRecursive(7, 2));
	}
	public static int powRecursive( int x, int n) {
        return powRecursive(x, n, 1);
    }
	 public static int powRecursive( int x, int n, int pow ) {
	        if (n == 0) {
	            return pow;
	        }
	        
	        return powRecursive(x, n - 1,pow*x );
	    }


}
