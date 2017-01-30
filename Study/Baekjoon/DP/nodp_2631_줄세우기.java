import java.util.LinkedList;
import java.util.Scanner;


class Row {
	public int rowFunc(LinkedList<Integer> chList) {
		int count=0;
		for(int i=0;i<chList.size()-1;i++) {
			if(chList.get(i)>chList.get(i+1)) {
				int temp=i+1;
				count++;
				while(chList.get(i)>chList.get(temp) && i!=0) {
					i--;
				}
				if(i==0) {
				chList.add(i,chList.remove(temp));	
				} else {
				chList.add(i+1,chList.remove(temp));
				}
			}
		}
		for(int i=0;i<chList.size();i++) {
			System.out.print(chList.get(i)+" ");
		}
		return count;
	}	
}

public class nodp_2631_줄세우기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Row row=new Row();
		int ch=sc.nextInt();
		LinkedList<Integer> chList=new LinkedList<Integer>();
		for(int i=0;i<ch;i++) {
			chList.add(sc.nextInt());
		}
		int result=row.rowFunc(chList);
		//System.out.println(result);
	}

}
