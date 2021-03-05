package schl;

public class GenericStackExt<E> extends java.util.ArrayList<E> {
	private java.util.ArrayList <E> list = new java.util.ArrayList<>();

	public GenericStackExt() {
		
	}
	
	 public void push(E o) {
		 add(o);
	 }

	 public E pop() {
		 return remove(size() - 1);
	 }

	 public boolean isEmpty() {
		 return size() == 0;
	 }

	 public E peek() {
		 return get(size() - 1);
	 }

	@Override
	public String toString() {
		return "stack: " + list.toString();
	}
}
