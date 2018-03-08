//3.2
//design a stack which has the ability to return th eminimum element

public class MinStack<T> {
	private class StackNode<T>{
		private T data;
		private StackNode<T> next;
		private T stackMin;

		public StackNode<T>(T data, T stackMin){
			this.data = data;
			this.stackMin = stackMin;
		}
	}

	private StackNode<T> top;

	public T pop(){
		if(top == null){
			throw EmptyStackException();
		}
		T item = top.data;
		top = top.next;
		return item;
	}

	public T peek(){
		if(top == null){
			throw EmptyStackException();
		}
		return top.data;
	}

	public void push(T node){
		if(top.stackMin > node){
			StackNode<T> newNode = new StackNode<T>(node,node);
		} else {
			StackNode<T> newNode = new StackNode<T>(node, top.stackMin);
		}
		newNode.next = top;
		top = newNode;
	}

	public boolean isEmpty(){
		return top == null;
	}

	public T min(){
		return top.stackMin;
	}

}
