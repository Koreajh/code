import java.util.Scanner;

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	
}

class BinarySearchTree {
	public TreeNode root=new TreeNode();
	
	public TreeNode insertKey(TreeNode root,int x) {
		TreeNode p=root;
		TreeNode newNode=new TreeNode();
		newNode.data=x;
		newNode.left=null;
		newNode.right=null;
		if(p==null) {
			return newNode;
		} else if(newNode.data<p.data) {
			p.left=insertKey(p.left,x);
			return p;
		} else if(newNode.data>p.data) {
			p.right=insertKey(p.right,x);
			return p;
		}
		else return p;
	}
	
	public void insertBST(int x) {
		root=insertKey(root,x);
	}
	
	public void postOrder(TreeNode root) {
		if(root!=null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(root.data);
			
		}
	}
}

public class Tree_5639 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bs=new BinarySearchTree();
		System.out.println(bs.root.data);
		Scanner sc=new Scanner(System.in);
		while(sc.hasNextLine()) {
			bs.insertBST(Integer.parseInt(sc.nextLine()));
		}
		System.out.println("root:"+bs.root.data);
		bs.postOrder(bs.root);
	}
}