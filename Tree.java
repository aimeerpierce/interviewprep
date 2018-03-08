public class Tree{
	private class BinaryTreeNode{
		private int value;
		private Node left;
		private Node right;
		private Node parent;

		public Node(int value){
			this.value = value;
			left = null;
			right = null;
			parent = null;
		}
	}

	public class Tree {
		Node root;

		//left node, then root, then right
		public void inOrderTraversal(Node node){
			if(node !=null){
				inOrderTraversal(node.left);
				System.out.println(node.value);
				inOrderTraversal(node.right);
			}
		}

		//current node, left, right
		public void preOrderTraversal(Node node){
			if(node!=null){
				System.out.println(node.value);
				preOrderTraversal(node.left);
				preOrderTraversal(node.right);
			}
		}

		//left, right, current
		public void postOrderTraversal(Node node){
			if(node!=null){
				postOrderTraversal(node.left);
				postOrderTraversal(node.right);
				System.out.println(node.value);
			}
		}

/*		public int findLargestSmallerKey(int num) {
      		// your code goes here
			Node temp = root;
			int smallest = -1;
			while(temp != null){
				if (num <= temp.key){
					temp = temp.left;

				} else if (num > temp.key) {
					smallest = temp.key;
					temp = temp.right;
				}
			}
			return smallest;
		}*/

		public int inOrderTraversal2(Node node){
			if (node != null){
				preOrderTraversal2(node.left);
				return node.value;
				preOrderTraversal2(node.right);
			}
		}

		public int findLargestSmallerKeyRecursive(int num){
			Node temp = root;
			while(temp != null){
				int val = inOrderTraversal2(temp);
				if(num > val){}
			}
		}
	}
}
