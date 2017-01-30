import java.util.HashSet;
import java.util.Scanner;

class Jump {
	
	HashSet result_set=new HashSet(); //중복된 값은 저장않는 set
	
	public void jumpFunc(int[][] matrix,int i,int j,int depth,int result) {
		 
		 if(depth>=6) {								//6자리 숫자만들어지면
		      	 result_set.add(result);            //set에 add
			 return ;
		 }
		   
		 result+=result*10+matrix[i][j];			// 현재 인덱스값을 누적저장
		 if(i<4) jumpFunc(matrix,i+1,j, depth+1,result);	//재귀적으로 인덱스이동
		 if(j<4) jumpFunc(matrix,i,j+1, depth+1,result);
		 if(i>0) jumpFunc(matrix,i-1,j, depth+1,result);
		 if(j>0) jumpFunc(matrix,i,j-1, depth+1,result);
	}
}

public class Bt_2210_숫자판점프 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix=new int [5][5];
		Scanner sc=new Scanner(System.in);
		Jump jump=new Jump();
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				matrix[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				jump.jumpFunc(matrix,i,j,0,0);
			}
		}
		System.out.println(jump.result_set.size());  // set의 갯수 출력
	}
}
