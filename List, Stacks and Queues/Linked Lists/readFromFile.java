package queues;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

public class readFromFile {

	public static void main(String[] args) throws IOException {
		String fileName = "test.txt";
		String line;
	    File file = new File(fileName);
	    FileReader f = new FileReader(file);
	    BufferedReader b = new BufferedReader(f);
	    
	    LinkedList<String> ll = new LinkedList<String> ();
	    
	    while((line = b.readLine()) != null) {
	    	ll.add(line);
	    }
	    
	    Collections.sort(ll);
	    System.out.println(ll);
	}

}
