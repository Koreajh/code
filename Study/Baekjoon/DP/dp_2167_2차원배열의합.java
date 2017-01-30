package dp;

import java.util.Scanner;

class ArrSum {
	int[][] dp;
	
	ArrSum(int n,int m) {
		dp=new int[n+1][m+1];
	}
	public int sumFunc(int[][] arr,int i,int j,int x,int y) {
		dp[i][j]=arr[i][j];
		for(int a=i;a<=x;a++) {					//옆으로가면서 dp누적저장
			for(int b=j+1;b<=y;b++) {
				dp[a][b]=dp[a][b-1]+arr[a][b];
			} 
			if(a+1<=x) {						//끝에 왔으면 밑에 첫번째꺼로 내림
				dp[a+1][j]=arr[a+1][j]+dp[a][y];
				continue;
			}
		}
		return dp[x][y];
	}
}

public class dp_2167_2차원배열의합 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int i,j,x,y;
		int n=sc.nextInt();
		int m=sc.nextInt();
		int[][] arr=new int[n+1][m+1];
		ArrSum arrsum=new ArrSum(n,m);
		for(int a=1;a<=n;a++) {
			for(int b=1;b<=m;b++) {
				arr[a][b]=sc.nextInt();
			}
		}
		int k=sc.nextInt();
		int[] result=new int[k];
		for(int z=0;z<k;z++) {
			i=sc.nextInt();
			j=sc.nextInt();
			x=sc.nextInt();
			y=sc.nextInt();
			result[z]=arrsum.sumFunc(arr, i, j, x, y);
		}
		
		for(int z=0;z<k;z++) {
			System.out.println(result[z]);
		}

	}

}