import java.util.Scanner;

class Cal {
	int[] count;
	
	public Boolean cal(int num) {  
		int list[]=new int[num];
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<num;i++) {
			list[i]=sc.nextInt();
			if(list[i]<11) {
				continue;
			} else {
				return false;
			}
		}
		for(int i=0;i<list.length;i++) {		
			count=new int[list.length];
			count[i]=func2(list[i],i);
			System.out.println(count[i]);
		}
		return true;
	}
	
	public int func2(int a,int i) { 
		if(a==0){				//  재귀적으로 뺴다가 뺸값이 0이면(식이 성립되면)
			return count[i]++;  //  계산조합 count변수 ++
		} else if (a<0) {       //  재귀적으로 빼다가 뺸값이 0이 안되면(식이 성립되지 않으면)
			return 0;
		}
		func2(a-1,i);			//입력된 숫자 값에서 재귀적으로 1~3을 뺸다.
		func2(a-2,i);
		func2(a-3,i);
		return count[i];
	}
}

public class nodp_9095_123더하기 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cal cal=new Cal();
		Scanner sc=new Scanner(System.in);
		Boolean flag=false;
			
			while(true) {
				if(flag==true) {
					break;
				} else {
					int num=sc.nextInt();
					flag=cal.cal(num);
				}
			}
	}
}