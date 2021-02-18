package schl;

public class DecimalToBinary {

	public static void main(String[] args) {
		System.out.println(dec2Bin(256));

	}
	public static String dec2Bin (int a) {
		if (a == 1) {
			return "1";
		}else if(a == 0) {
			return "0";
		}
		
		return dec2Bin(a/2) + a %2;
	}
}
