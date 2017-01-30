class ListNode {
		public String data;
		public ListNode link;
		
		public ListNode() {
			this.data=null;
			this.link=null;
		}
		
		public ListNode(String data) {
			this.data=data;
			this.link=null;
		}
		
		public ListNode(String data,ListNode link) {
			this.data=data;
			this.link=link;
		}
}

class LinkedList {
	private ListNode head;
	public LinkedList() {
		head= null;
	}
	
	public void insertMiddleNode(ListNode pre,String data) {
		ListNode newNode=new ListNode(data);
		newNode.link=pre.link;
		pre.link=newNode;
	}
	
	public void insertLastNode(String data) {
		ListNode newNode=new ListNode(data);
		if(head == null) {
			this.head=newNode;
			newNode.link=newNode;
		} else {
			ListNode temp = head;
			while(temp.link !=null) temp=temp.link;
			temp.link=newNode;
			newNode.link=head;
		}
	}
	
	public void deleteNode(ListNode pre,String data) {
		if(head == null) return;
		if(head.link == null) {
			head=null;
		} else {
			pre.link=pre.link.link;
		}
	}
	
	public ListNode searchNode(String data) {
		ListNode temp=head;
		
		while(temp!=null) {
			if(data == temp.data) {
				return temp;
			}
			temp=temp.link;
		}
		return temp;
	}
	
}

public class LinkedMain {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList L = new LinkedList();
		L.insertLastNode("월");
		L.insertLastNode("화");
		L.insertLastNode("수");
		ListNode pre=L.searchNode("화");
		L.deleteNode(pre,"화");
	}

}
