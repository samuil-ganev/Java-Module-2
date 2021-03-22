package queues;


import java.util.Arrays;
import java.util.PriorityQueue;


public class UnIntDiff {

	 public static void main(String[] args) {
		 PriorityQueue<String> q1 = new PriorityQueue<String>(Arrays.asList("George" , "Jim" , "John" , "Blake" , "Kevin" , "Michael" ));
		 PriorityQueue<String> q2 = new PriorityQueue<String>(Arrays.asList( "George" , "Katie" , "Kevin" , "Michelle" , "Ryan" ));
		 
		 PriorityQueue<String> union = new PriorityQueue<String>(q1);
		 union.addAll(q2);
		 
		 PriorityQueue<String> intersection = new PriorityQueue<String>(q1);
		 union.retainAll(q2);
		 
		 PriorityQueue<String> difference = new PriorityQueue<String>(q1);
		 difference.removeAll(intersection);
		 	
	 }	 
}
