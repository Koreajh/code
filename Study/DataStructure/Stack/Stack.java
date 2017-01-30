import java.util.LinkedList;

class StackNode {
	char data;
	StackNode link;
}


class LinkedStack {
	private StackNode top;
	
	public boolean isEmpty() {
		return (top==null);
	}
	
	public void push(char item) {
		StackNode n=new StackNode();
		n.data=item;
		n.link=top;
		top=n;
	}
	
	public char pop() {
		if(isEmpty()) {
			System.out.println("Deleting fail!");
			return 0;
		} else {
			char item=top.data;
			top=top.link;
			return item;
		}
	}
	
	public void delete() {
		if(isEmpty()) {
			System.out.println("Deleting fail!");
		} else {
			top=top.link;
		}
	}
	
	public void printStack() {
		if(isEmpty()) {
			System.out.println("Deleting fail!");
		} else {
			StackNode temp=top;
			while(temp !=null) {
				System.out.print(temp.data+" ");
				temp=temp.link;
			}
		}
	}
}


public class Stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedStack LS=new LinkedStack();
		LinkedList<Character> LS2=new LinkedList();
		
		LS.push('A');
		LS.push('B');
		LS.push('c');
		System.out.println(LS.pop());
		LS.printStack();
		
		LS2.add('A');
		LS2.add('B');
		LS2.add('C');
		System.out.println(LS2.removeLast());
		for(int i=LS2.size()-1;i>=0;i--) {
			System.out.print(LS2.get(i)+" ");
		}
	}

}
