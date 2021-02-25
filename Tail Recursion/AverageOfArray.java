package schl;

public class AverageOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10, 2, 3, 4, 5, 6, 7, 8, 9};
        
      
        System.out.println(recursiveAvg(arr));
	}
	static double recursiveAvg(int a[]) {
         return recursiveAvg(a, a.length - 1, a.length,0);
    }
	
	public static double recursiveAvg(int arr[], int index, int length, int sum) {

	    if (index + 1 == 0) {
	      return sum / length;
	    }
	    return recursiveAvg(arr, index-1,length, sum+arr[index]);
	}

}
