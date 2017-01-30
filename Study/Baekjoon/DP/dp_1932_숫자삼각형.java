package dp;

import java.util.Scanner;

class Tri{
	int[][] dp;
	Tri(int num) {
		dp=new int[num][num];
	}
	
	public void triFunc(int[][] arr,int depth) {
		for(int i=0;i<=depth;i++) {							
			if(i==0) {					//가장 왼쪽꺼는 그냥 위에서 내려와서 dp에 누적저장
				dp[depth][i]=dp[depth-1][i]+arr[depth][i];
			} else if(i==depth) {		//가장 오른쪽꺼도 그냥 위에서 내려와서 dp에 누적저장
				dp[depth][i]=dp[depth-1][i-1]+arr[depth][i];
			} else {					//가장 왼,오른쪽 제외한 값들은 한 depth 위에 dp값 비교 
				if(dp[depth-1][i-1]>dp[depth-1][i]) {
					dp[depth][i]=dp[depth-1][i-1]+arr[depth][i];
				} else {
					dp[depth][i]=dp[depth-1][i]+arr[depth][i];
				}
			}
		}
		
	}
}

public class dp_1932_숫자삼각형 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		Tri tri=new Tri(num);
		int[][] arr=new int[num][num];
		
		for(int i=0;i<num;i++) {
			for(int j=0;j<=i;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		tri.dp[0][0]=arr[0][0];
		for(int i=1;i<num;i++) {
			tri.triFunc(arr,i);
		}
		
		int max=0;
		for(int i=0;i<num;i++) {
			if(max<tri.dp[num-1][i]) {
				max=tri.dp[num-1][i];
			}
		}
		System.out.println(max);
	}

}
