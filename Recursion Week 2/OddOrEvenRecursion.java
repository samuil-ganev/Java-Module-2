package schl;

public class OddOrEvenRecursion {

	public static void main(String[] args) {
		System.out.print(even(7));

	}
	public static boolean even (int a) {
		if (a == 1) {
			return false;
		}else if(a == 0) {
			return true;
		}else {
			return even (a -2);
		}
	}
}
