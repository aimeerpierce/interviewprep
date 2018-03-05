import java.util.LinkedList;
import java.util.ListIterator;

//2.4
//write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x
//eg 3-5-8-5-10-2 ---> 3-2-8-5-10-5
public class Partition {

	public static LinkedList<Integer> partition(LinkedList<Integer> list, int x){

		LinkedList<Integer> partitionList = new LinkedList<Integer>();

		//check if each value in the list is greater or equal to x
		for(int i = 0; i < list.size(); i++){
			//if the value of the list is greater than x, add it to the end of the new list
			if(list.get(i) >= x){
				partitionList.addLast(list.get(i));
			} else {
			//if the value is less than x, add it to the front of the new list
				partitionList.addFirst(list.get(i));
			}
		}

		return partitionList;

	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(3);
		list.add(5);
		list.add(8);
		list.add(2);
		list.add(9);
		list.add(1);
		list.add(5);

		System.out.println(list);
		System.out.println(partition(list,6));
	}


}
