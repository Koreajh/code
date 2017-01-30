import java.util.Scanner;
import java.util.LinkedList;

class G {
	
	public String function(String a) {
		LinkedList l=new LinkedList();	//스택생성
		for(int i=0;i<a.length();i++) {		//문자열의 문자하나씩 for문
			if(a.charAt(i)=='(') {			// 문자가 '('이면
				l.add('(');					// 스택에 push
				
			} else if(a.charAt(i)==')' && l.size()>0) { 
				l.removeLast();// 문자가 ')'이고  스택데이터 갯수가 0이상이면 pop
			} else if(a.charAt(i)==')' && l.size()<=0) {
				return "NO";   // 문자가 ')'인데 스택데이터('(')가 없는 경우
							   // NO 리턴
			}
		}
		
		if(l.size()==0) {
			return "YES";	   // for문 다 돌고 스택에 아무것도 없으면 YES
		}
		
		return "NO";		   // 그 이외의 경우는 모두 NO
	}
}

public class Stack_9012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		G g=new G();
		int t=Integer.parseInt(sc.nextLine());
		String[] result=new String[t];
		for(int i=0;i<t;i++) {
			String a=sc.nextLine();
			result[i]=g.function(a);
		}
		
		for(int j=0;j<t;j++) {
			System.out.println(result[j]);
		}
	}

}
