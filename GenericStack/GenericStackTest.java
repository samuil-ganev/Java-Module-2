package schl;

import java.util.Scanner;

public class GenericStackTest {

	public static void main(String[] args) {
		GenericStackExt<String> stack = new GenericStackExt<>();
		Scanner sc = new Scanner(System.in); 
		for(int i = 0; i < 5; i++) {
			System.out.println("Enter a string");
			stack.push(sc.next());
		}
		
		for(int i = 0; i < 5; i++) {
			System.out.println(stack.pop());
		}
		sc.close();
	}

}
