import java.util.*;

public class LinkedList<T> implements Iterable<T> {
	//Node class
	private static class Node<T> { //@param <T> generic
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

	private Node<T> head;
	public LinkedList(){ //empty list

	}
	public boolean isEmpty(){
		return head == null;
	}
	public void addFirst(T n){
		head = new Node<T>(n, head);
	}

	public T getFirst(){
		if (head == null) {throw NoSuchElementException();}
		return head.data;
	}

	public T removeFirst(){
		if (head == null) throw NoSuchElementException();
		T temp = getFirst();
		head = head.next;
		return temp;
	}

	public void addLast(T n){
		if (head == null){
			addFirst(n);
		} else {
			T temp = getFirst();
			while(temp.next != null){ temp = temp.next;}
			temp.next = new Node<T>(n, null);
		}
	}
	public T getLast(T n){
		if (head == null) throw NoSuchElementException();
		Node<T> temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		return temp.data;
	}

	public void add(T data, int index){
		Node<T> temp = head;
		if(temp == null) throw NoSuchElementException();
		for(int i = 0; i < index; i++){
			temp = temp.next;
		}
		Node<T> n = new Node<T>(data,temp.next);
		temp.next = n;
	}

	public void clear(){
		if (head == null) throw NoSuchElementException();
		Node<T> temp;
		while(head.next != null){
			temp = head.next;
			head = temp;
			temp = head.next;
		}

	}
	public boolean contains(T data){
		for(T temp : this){
			if(temp.equals(data)) return true;
		}
		return false;
	}

	public T get(int index){
		if (head == null) throw NoSuchElementException();
		Node<T> temp = head;
		int i = 0;
		while(i < index){
			temp = temp.next;
			i++;
		}
		if (temp == null) throw OutOfBoundsException();
		return temp.data;
	}
	public void insertAfter(T key, T toInsert){
		T temp = getFirst();
		for(temp:this){
			if(temp.equals(key)){
				Node<T> n = new Node<T>(toInsert,temp.next);
				temp.next = n;
			}
		}
	}
	public void insertBefore(T key, T toInsert){
		T temp = getFirst();
		for(temp:this){
			if(temp.equals(key)){
				Node<T> n = new Node<T>(toInsert,temp);
			}
		}
	}
	public void remove(T key){
		if(head == null) throw new RuntimeException("cannot delete");
		if(head.data.equals(key)){
			head = head.next;
			return;
		}
		Node<T> temp = head;
		Node<T> prev = null;

		while( temp != null ){
			if(temp.data == key){
				prev.next = temp.next;
			} else {
				prev = temp;
				temp = temp.next;
			}
		}
	}
	public LinkedList<T> deepCopy(){
		Map<Node<T>,Node<T>> map = new HashMap<Node<T>,Node<T>>();
		Node<T> newhead = new Node<T>(head.data,null);
		Node<T> p = head;
		Node<T> n = newhead;

		map.put(head, newhead); //put(key,value)
		p = p.next;
		//create copies of nodes and relate them to each other
		while(p != null){
			Node<T> temp = new Node<T>(p.data,null);
			map.put(p,temp);
			n.next = map.get(p);
			p = p.next;
		}

	}
	public LinkedList<T> reverse(){
		LinkedList<T> rList = new LinkedList<T>();
		Node<T> temp = head;
		while(temp != null){
			rList.addFirst(temp.data);
			temp = temp.next;
		}
		return rList;
	}

public static void main(String[] args){
	LinkedList<String> list = new LinkedList<String>();
	list.addFirst("p");
	list.addFirst("l");
	list.addFirst("e");
	list.addFirst("h");
	System.out.println(list);
}


}
