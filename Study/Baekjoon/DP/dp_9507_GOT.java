package dp;

import java.util.ArrayList;
import java.util.Scanner;

class K {
	long result;
	long[] dp;	//누적값 저장 dp
	K() {
		dp=new long[67+1];
		dp[0]=1;
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;
	}
	public long koong(long n) {
	
		if(n>3) {
			if(dp[(int) n]==0){ //dp값이 주어지지 않았으면 재귀
				dp[(int) n]=koong(n-1)+koong(n-2)+koong(n-3)+koong(n-4);
			}
		}
		return dp[(int) n];	//아님 저장된 값 리턴
	}
}

public class dp_9507_GOT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int tc=sc.nextInt();
		ArrayList <Long> result=new ArrayList<Long>();
		
		for(int i=0;i<tc;i++) {
			long num=sc.nextInt();
			K k=new K();
			long res=k.koong(num);
			result.add(res);
		}
		
		for(int i=0;i<result.size();i++) {
			System.out.println(result.get(i));
		}
		
	}

}
