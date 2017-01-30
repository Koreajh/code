import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class G_p {
	public int QFunc(int size,int index){        
		int count=0;
		int find=0;
		Queue<Integer> l=new LinkedList();
		PriorityQueue<Integer> pl=new PriorityQueue<Integer>();
		PriorityQueue<Integer> rpl=new PriorityQueue<Integer>(100,Collections.reverseOrder());
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<size;i++) {
			int temp=sc.nextInt();
			if(i == index) find=temp;
			l.add(temp);			//입력값을 큐에 저장
			pl.add(temp);			//입력값의 우선순위들을 저장
		}
		rpl.addAll(pl);				//우선순위를 역순으로 저장
									/*  l:10,12,11,13
									 * pl:10,11,12,13->역으로 rpl:13,12,11,10
									 * l과 rpl랑 비교해가면서  빼나가면됨 
									 * find에는 찾는 값을 저장 index는 찾고자하는 값의 인덱스
									 */
		for(int i=0;i<size;i++) {
			System.out.println("l["+i+"]:"+l.poll()+"/"+"rpl["+i+"]:"+rpl.poll());
		}

		while(!pl.isEmpty()) {
			int plPeek=l.peek();
			int rplPeek=rpl.peek();
		
			if(plPeek == rplPeek){
				rpl.poll();
				l.poll();
				count++;
				if((rplPeek == find) && (index == 0)) break;
				index--;
			}else{
				l.add(l.poll());
				if((index == 0) && (plPeek == find)) { index = l.size()-1; }
				else { index--; }
			}	
	  }
	
		return count;
	}
}



public class Queue_1966_Priority {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		G_p q=new G_p();
		Scanner sc=new Scanner(System.in);
		int tc=sc.nextInt();
		
		for(int i=0;i<tc;i++) {
			int size=sc.nextInt();
			int dap=sc.nextInt();
			int result=q.QFunc(size,dap);
			System.out.println(result);
		}
	}

}
