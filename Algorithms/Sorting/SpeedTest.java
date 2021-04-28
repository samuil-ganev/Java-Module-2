package sort;

public class SpeedTest {

	public static void main(String[] args) {
		
		int[] nums = new int [100000];
		for(int i = 0; i < 100000; ++i) {
			int num = (int) (Math.random() * 100000);
			nums[i] = num;
		}
		int[] nums1 = new int [100000];
		int[] nums2 = new int [100000];
		nums1 = nums;
		nums2 = nums;
		
		//bubbleSort(nums);
		//mergeSort(nums1);
		quickSort(nums2);	
	}
	
	public static void bubbleSort(int[] list) {
		long beginTime = System.currentTimeMillis();
		boolean needNextPass = true;
		for (int k = 0; k < list.length - 1 && needNextPass; k++) {
			// Array may be sorted and next pass not needed
			needNextPass = false;
			for (int i = 0; i < list.length - k - 1; i++) {
				if (list[i] > list[i + 1]) {
					// Swap list[i] with list[i + 1]
					int temp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = temp;
					needNextPass = true; // Next pass still needed
				}
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - beginTime);
	}
	public static void mergeSort(int[] list) {
		long beginTime = System.currentTimeMillis();
		mergeSort(list, true);
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - beginTime);
	}
	public static void mergeSort(int[] list, boolean e) {
		
		if (list.length > 1) {
			int[] firstHalf = new int[list.length / 2];
			System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
			mergeSort(firstHalf, true);
			int secondHalfLength = list.length - list.length / 2;
			int[] secondHalf = new int[secondHalfLength];
			System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
			mergeSort(secondHalf, true);
			merge(firstHalf, secondHalf, list);
		}
		
	}

	public static void merge(int[] list1, int[] list2, int[] temp) {
		int current1 = 0;
		int current2 = 0;
		int current3 = 0;

		while (current1 < list1.length && current2 < list2.length) {
			if (list1[current1] < list2[current2])
				temp[current3++] = list1[current1++];
			else
				temp[current3++] = list2[current2++];
		}
		while (current1 < list1.length)
			temp[current3++] = list1[current1++];
		while (current2 < list2.length)
			temp[current3++] = list2[current2++];
	}
	
	public static void quickSort(int[] list) {
		long beginTime = System.currentTimeMillis();
		quickSort(list, 0, list.length - 1);
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - beginTime);
	}

	public static void quickSort(int[] list, int first, int last) {
		if (last > first) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);
		}
		
	}

	/** Partition the array list[first..last] */
	public static int partition(int[] list, int first, int last) {
		int pivot = list[first];
		int low = first + 1;
		int high = last;
		while (high > low) {
			while (low <= high && list[low] <= pivot)
				low++;
			while (low <= high && list[high] > pivot)
				high--;
			if (high > low) {
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}
		while (high > first && list[high] >= pivot)
			high--;
		if (pivot > list[high]) {
			list[first] = list[high];
			list[high] = pivot;
			return high;
		} else {
			return first;
		}
	}
	
	public static void selectionSort(double[] list) {
		long beginTime = System.currentTimeMillis();
		for (int i = 0; i < list.length - 1; i++) {
			double currentMin = list[i];
			int currentMinIndex = i;
			for (int j = i + 1; j < list.length; j++) {
				if (currentMin > list[j]) {
					currentMin = list[j];
					currentMinIndex = j;
				}
			}
			if (currentMinIndex != i) {
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - beginTime);
	}


}
