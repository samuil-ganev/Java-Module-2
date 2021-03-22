package queues;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class zad2 {

	 public static void main(String[] args) throws IOException {

		 	String fileName = "test.txt";
		    File file = new File(fileName);
		    FileReader f = new FileReader(file);
		    BufferedReader b = new BufferedReader(f);
		    Stack<Character> q = new Stack<Character>();
		    
		    String line = b.readLine();

		    for (int i=0;i<line.length();++i) {

		      char ch = line.charAt(i);

		      if (ch == '(' || ch == '{' || ch == '[') {
		        q.push(ch);
		      } else if (ch == ')' && q.peek() == '(') {
		    	  q.pop(); 
		      } else if (ch == '}' && q.peek() == '{') {
		    	  q.pop();
		      } else if (ch == ']' && q.peek() == '[') {
		    	  q.pop();
		      } else {
		    	  break;
		      }
		          
		      }

		    

		    if (q.isEmpty()) {
		      System.out.println("Empty");
		    } else {
		      System.out.println("Error");
		    }
		    
		  }

		}
