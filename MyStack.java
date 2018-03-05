public class MyStack<T> {
	private class StackNode<T>{
		private T data;
		private StackNode<T> next;

		public StackNode<T>(T data){
			this.data = data;
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
		StackNode<T> newNode = new StackNode<T>(node);
		newNode.next = top;
		top = newNode;
	}

	public boolean isEmpty(){
		return top == null;
	}

}
