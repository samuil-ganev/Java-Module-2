package schl;

import java.util.ArrayList;
import java.util.Random;

public class GenericSort {
	public static void main(String[] args) {
// Create an Integer array
		Integer[] intArray = { new Integer(2), new Integer(4), new Integer(3) };
// Create a Double array
		Double[] doubleArray = { new Double(3.4), new Double(1.3), new Double(-22.1) };
// Create a Character array
		Character[] charArray = { new Character('a'), new Character('J'), new Character('r') };
// Create a String array
		String[] stringArray = { "Tom", "Susan", "Kim" };
		Circle[] circleArray = { new Circle(3), new Circle(4), new Circle(5) };
		Rectangle[] rectangleArray = { new Rectangle(5, 6), new Rectangle(3, 4), new Rectangle(6, 7) };
//Sort the arrays
		sort(intArray);
		sort(doubleArray);
		sort(charArray);
		sort(stringArray);
// Display the sorted arrays
		System.out.print("Sorted Integer objects: ");
		printList(intArray);
		System.out.print("Sorted Double objects: ");
		printList(doubleArray);
		System.out.print("Sorted Character objects: ");
		printList(charArray);
		System.out.print("Sorted String objects: ");
		printList(stringArray);
		printList(circleArray);
		printList(rectangleArray);
	}

	/** Sort an array of comparable objects */
	public static <E extends Comparable<E>> void sort(E[] list) {
		E currentMin;
		int currentMinIndex;

		for (int i = 0; i < list.length - 1; i++) {

			currentMin = list[i];
			currentMinIndex = i;
			for (int j = i + 1; j < list.length; j++) {
				if (currentMin.compareTo(list[j]) > 0) {
					currentMin = list[j];
					currentMinIndex = j;
				}
			}

// Swap list[i] with list[currentMinIndex] if necessary;
			if (currentMinIndex != i) {
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
			}
		}
	}

	/** Print an array of objects */
	public static void printList(Object[] list) {
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");
		System.out.println();
	}

	public static <E> void shuffle(ArrayList<E> list) {
		for (int i = 0; i < list.size(); i++) {
			int randIndex = (int) (Math.random() * list.size());
			E temp = list.get(i);
			list.set(i, list.get(randIndex));
			list.set(randIndex, temp);
		}
	}

	public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
		E currentMin;
		int currentMinIndex;

		for (int i = 0; i < list.size() - 1; i++) {

			currentMin = list.get(i);
			currentMinIndex = i;
			for (int j = i + 1; j < list.size() - 1; j++) {
				if (currentMin.compareTo(list.get(j)) > 0) {
					currentMin = list.get(j);
					currentMinIndex = j;
				}
			}

// Swap list[i] with list[currentMinIndex] if necessary;
			if (currentMinIndex != i) {
				list.set(currentMinIndex, list.get(i));
				list.set(i, currentMin);
			}
		}
	}

	public static <E extends Comparable<E>> E min(ArrayList<E> list) {
		E currentMin = list.get(0);

		for (int i = 0; i < list.size() - 1; i++) {

			if (currentMin.compareTo(list.get(i)) > 0) {
				currentMin = list.get(i);

			}
		}

		return currentMin;

	}

}
