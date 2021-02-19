
public class Hanoi {

	public static void main(String[] args) {
		System.out.println(hanoi(5,1,3));

	}
	public static int hanoi (int n, int fromTower, int toTower) {
		int result = 1;
		
		if (n == 1){
			return 1;
		}else {
			result += hanoi(n-1, fromTower, 6 - (fromTower + toTower));
			result += hanoi(n-1, 6 - (fromTower + toTower), toTower);
		}
		return result;
	}
}
