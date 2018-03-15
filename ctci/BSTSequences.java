//CTCI 4.9
//a binary search tree was created by traversing through an array and inserting each element
//given a BST w/ distinct elements, print all possible arrays that could have led to the tree
//e.g.
/*	2
1		3
{2,1,3}, {2,3,1}
*/

public class BSTSequences {
	abstract class Node {
		int key;
		Node left;
		Node right;
		Node parent;

		Node();

		Node(int key) {
			this.key = key;
			left = null;
			right = null;
			parent = null;
		}

		abstract int operator(int i, int j);

	}

	static class additionNode extends Node{
		int operator(int i, int j){
			return i+j;
		}
	}

	static class BinarySearchTree {
		Node root;

		void insert(int key) {

      // 1) If the tree is empty, create the root
			if(this.root == null) {
				this.root = new Node(key);
				return;
			}

      // 2) Otherwise, create a node with the key
      //    and traverse down the tree to find where to
      //    to insert the new node
			Node currentNode = this.root;
			Node newNode = new Node(key);

			while(currentNode != null) {
				if(key < currentNode.key) {
					if(currentNode.left == null) {
						currentNode.left = newNode;
						newNode.parent = currentNode;
						break;
					} else {
						currentNode = currentNode.left;
					}
				} else {
					if(currentNode.right == null) {
						currentNode.right = newNode;
						newNode.parent = currentNode;
						break;
					} else {
						currentNode = currentNode.right;
					}
				}
			}
		}

		int[] preorder(Node node){
			for(int i = 0; i < size; i++){
				if(node == null){
					return;
				} else {
					arr[i] = node.key;
					preorder(node.left);
					preorder(node.right);
				}
			}

		}

		int operator(char c, int i, int j){
			if(c == '+'){
					return i + j;
				}
			if(c == '-'){
				return i - j;
			}
			if(c == '*'){
				return i*j;
			}
			if(c=='x10+'){
				return (i*10)+j;
			}
		}

		int preorder(Node node){
			//int val;
			if(node != null) {
				if(node.key != null){
					return node.key;
				} else {
					return node.operator(preorder(node.left),preorder(node.right));
				}
			} else {
				return;
			}
		}


		public int[] treeToArray(BinarySearchTree bst){
			int size = size(bst.root);
			int[] arr = new int[size];
			Node temp = bst.root;

			for(int i = 0; i < size; i++){
				if(temp != null){
					arr[i] = temp;
					temp = temp.left;
				}
			}
		}
	}

		public static int size(Node node){
			if(node != null){
				return size(node.left) + 1 + size(node.right);
			} else {
				return(0);
			}
		}

	 public static void main(String[] args) {

     // Create a Binary Search Tree
     BinarySearchTree bst = new BinarySearchTree();
     bst.insert(20);
     bst.insert(9);
     bst.insert(25);
     bst.insert(5);
     bst.insert(12);
     bst.insert(11);
     bst.insert(14);

     int s = size(bst.root);
     System.out.println(s);

  }
}
