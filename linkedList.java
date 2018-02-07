import java.util.*;

public class linkedList<T> implements Iterable<T> {
	//Node class
	private static class Node<T> { //@param <T> is the type of node
		private T data;
		private Node<T> next;
		public Node(T data, Node<T> next){
			this.data = data;
			this.next = next;
		}
	}
	//Iterator class
	public Iterator<T> iterator(){
		return new LinkedListIterator();
	}
	private class LinkedListIterator implements Iterator<T> {
		private Node<T> nextNode;
		public LinkedListIterator(){
			nextNode = head;
		}
		public boolean hasNext(){
			return nextNode != null;
		}
		public T next() {
			if(!hasNext()) throw new NoSuchElementException();
			T res = nextNode.data;
			nextNode = nextNode.next;
			return res;
		}
		public void remove() { throw new UnsupportedOperatorException();}
	}
}
