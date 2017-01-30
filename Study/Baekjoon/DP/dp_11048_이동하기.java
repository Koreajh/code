import java.util.Scanner;

class MoveC {	
	public int moveFunc(int[][] index,int[][] answer,int i,int j) {
		for(int n=0;n<=i;n++){
			for(int m=0;m<=j;m++){
				if(n==0 && m==0) {
					answer[n][m]=index[n][m];
				} else if(n==0) {
					answer[n][m]=index[n][m]+answer[n][m-1];
				}else if(m==0)  {
					answer[n][m]=index[n][m]+answer[n-1][m];
				} else {
					if(answer[n][m-1] > answer[n-1][m]) {
						answer[n][m]=index[n][m]+answer[n][m-1];
					} else {
						answer[n][m]=index[n][m]+answer[n-1][m];
					}
				}	
			}
		}
		return answer[i][j];
	}
}

public class dp_11048_이동하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MoveC movec=new MoveC();
		Scanner sc=new Scanner(System.in);
		int s=sc.nextInt();
		int c=sc.nextInt();
		
		int[][] index=new int[s][c];
		int[][] answer=new int[s][c];
		for(int i=0;i<s;i++) {
			for(int j=0;j<c;j++) {
				index[i][j]=sc.nextInt();
				answer[i][j]=0;
			}
		}
		int result=movec.moveFunc(index,answer,s-1,c-1);
		System.out.println(result);
	}
}