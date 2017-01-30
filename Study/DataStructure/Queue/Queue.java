/*
 * 원형큐
 */
class ArrayQueue {
	private int front;
	private int rear;
	private int queueSize;
	private char itemArray[];
	
	public ArrayQueue(int QueueSize){
		front=0;
		rear=0;
		this.queueSize=queueSize;
		itemArray=new char[this.queueSize];
	}
	
	public boolean isEmpty() {
		return front==rear;
	}
	
	public boolean isFull() {
		return (((rear+1) % this.queueSize) == front);
	}
	
	public void enQueue(char item) {
		if(isFull()) {
			System.out.println("Queue is Full");
		} else {
			rear=(rear+1) % this.queueSize;
			itemArray[rear]=item;
		}
	}
	
	public char deQueue() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return 0;
		} else {
			front=(front+1) % this.queueSize;
			return itemArray[front];
		}
	}
	
	public void delete() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
		} else {
			front=(front+1)% this.queueSize;
		}
	}
}

/*
 * 연결큐
 */
class QNode {
	char data;
	QNode link;
}

class LinkedQueue {
	QNode front;
	QNode rear;
	
	public LinkedQueue() {
		front=null;
		rear=null;
	}
	
	public boolean isEmpty() {
		return (front == null);
	}
	
	public void enQueue(char item) {
		QNode newNode=new QNode();
		newNode.data=item;
		newNode.link=null;
		
		if(isEmpty()) {
			front=newNode;
			rear=newNode;
		} else {
			rear.link=newNode;
			rear=newNode;
		}
	}
	
	public char deQueue() {
		if(isEmpty()) {
			System.out.println("queue is empty");
			return 0;
		} else {
			char item=front.data;
			front=front.link;
			if(front == null) rear=null;
			
			return item;
		}
		
	}
}

public class Queue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 원형큐
		 */
		int queueSize=4;
		char deletedItem;
		ArrayQueue aq=new ArrayQueue(queueSize);
		
		aq.enQueue('A');
		aq.enQueue('B');
		deletedItem=aq.deQueue();
		System.out.println(deletedItem);
		
		/*
		 * 연결큐
		 */
		int deletedItem2;
		LinkedQueue lq=new LinkedQueue();
		lq.enQueue('A');
		lq.enQueue('B');
		deletedItem2=lq.deQueue();
		System.out.println(deletedItem2);

	}

}
