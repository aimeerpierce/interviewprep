  //Write a function kthToLastNode() that takes an integer kk and the headNode of a singly-linked list, and returns the kkth to last node in the list.



function LinkedListNode(value) {
	this.value = value;
	this.next = null;
}

function kthToLastNode(i, node){
	if(node){
		count = 1;
	} else {
		console.log('head node is null');
	}

	var temp = node;
	while(temp.next){
		count++;
		temp = temp.next;
	}

	var temp2 = node;
	console.log('count: '+count);
	console.log('i: '+i);
	console.log('temp2 next:'+temp2.next.value);
	//while(temp2.next){
		//temp = temp.next;
		//count++;
		if(count > i){
			for(j = 0; j<(count-i); j++){
				//console.log(temp2.value);
				temp2 = temp2.next;
			}
		}

	//}
	return temp2.value;
}

var a = new LinkedListNode("Angel Food");
var b = new LinkedListNode("Bundt");
var c = new LinkedListNode("Cheese");
var d = new LinkedListNode("Devil's Food");
var e = new LinkedListNode("Eccles");

a.next = b;
b.next = c;
c.next = d;
d.next = e;

console.log(kthToLastNode(3, a));
