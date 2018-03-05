public class MyQueue<T>{
	private class QueueNode<T>{
		private T data;
		private QueueNode<T> next;

		public QueueNode<T>(T data){
			this.data = data;
		}
	}

	private QueueNode<T> first;
	private QueueNode<T> last;

	public void queue(T data){
		QueueNode<T> newNode = new QueueNode<T>(data);
		if(last != null){
			last.next = newNode;
		}
		last = newNode;
		if(first == null){
			first = last;
		}
	}

	public T dequeue(){
		if(first == null){
			throw new NoSuchElementException();
		}
		QueueNode<T> temp = first;
		first = first.next;
		if(first == null){
			last = null;
		}
		return temp.data;
	}

	public T peek(){
		return first.data;
	}

	public boolean isEmpty(){
		return first == null;
	}
}
