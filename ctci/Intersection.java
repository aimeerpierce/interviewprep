//2.7
//given 2 singly linked lists determine if the lists intersect
//return the intersecting node
//intersection is based on reference, not value
//if the kth node of the first linked list is the same exact node (by reference) as the jth node of the second they intersect

public class Intersection {

	private static class Node<T> { //@param <T> generic
			private T data;
			private Node<T> next;
			public Node(T data, Node<T> next){
				this.data = data;
				this.next = next;
			}
		}

	//O(N^2)
	//iterate through one list, compare each node to every node of the other list

	public boolean intersect(LinkedList<Node<Integer>> list1, LinkedList<Node<Integer>> list2){
		for(int i = 0; i < list1.size(); i++){
			for(int j = 0; j < list2.size(); j++){
				if(list1.get(i).equals(list2.get(j)){
					return true;
				}
			}
		}
		return false;
	}
}
