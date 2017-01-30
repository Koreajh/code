import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

class Q {
	public int QFunc(int size,int index){       //size- 큐에들어가는 데이터 갯수 index- 몇번쨰로 빠지는지 구할 인덱스 
		int count=0;							//큐에서 빠진 것은 카운트- 몇번쨰로 빠지는지 세기위한 변수
		LinkedList l=new LinkedList();
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<size;i++) {
			l.add(sc.nextInt());
		}
		while(true) {
			if(l.get(0)==Collections.max(l) && index==0) { //젤커서 빠지는 거고, 그 빠지는 값이 원하는 인덱스일때
				l.poll();								   //빼고	
				count++;								   //카운트	
				break;
			} else if(l.get(0)==Collections.max(l)) { //젤커서 빠지는거
				l.poll();							  //빼고
				index=index-1;						  //하나 빠졌으니까 원하는 인덱스도 -1	
				count++;							  //카운트
			} else {								// 빠져야하는데 제일 우선순위가 안크면
				l.add(l.poll());					// 그냥 맨뒤로 넘김
				if(index==0) {						// 근데 그값이 index값이였다면
					index=l.size()-1;				// index를 맨뒤 인덱스로 바꿔줌
				} else {							// 아니면
					index=index-1;					// 그냥 -1
				}
			}
		}
		return count;
	  }
}


public class Queue_1966 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q q=new Q();
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
