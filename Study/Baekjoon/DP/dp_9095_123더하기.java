/*
 * 
 * 입력된 숫자 n이 있다면 이를 표현하는 수는 (n-1)+1 / (n-2)+2 / (n-3)+3 으로 표현 할 수 있다.
 * 이는 각각의 경우 1,2,3을 더해줄 경우 n이 완성된다고 할 수 있으므로
 * n을 1,2,3으로 만들 수 있는 경우의 수는  [ n-1일때 경우의 수 +n-2일때 경우의 수 + n-3일때 경우의 수 ] 
 */


import java.util.Scanner;

class Plus {
	
	int[] index=new int[12];
	
	public int plus(int a) {
		index[1]=1;
		index[2]=2;
		index[3]=4;
		for(int i=4;i<=a;i++) {
			index[a]=plus(a-1)+plus(a-2)+plus(a-3);
		}
		return index[a];
	}
}


public class dp_9095_123더하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Plus p=new Plus();
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int[] tc=new int[num];
		for(int i=0;i<num;i++) {
			int j=sc.nextInt();
			tc[i]=p.plus(j);
		}
		for(int i=0;i<num;i++) {
		System.out.println(tc[i]);
		}
	}

}
