import java.util.Scanner;

class Up {
	public int upFunc(int num) {

		int[][] stair=new int[1000][10];	//[자릿수][해당자리숫자]
		int result=0;
		for(int i=0;i<10;i++) {				//초기값 (0~9까지)
			stair[1][i]=1;
		}
		
		for(int i=2;i<=num;i++) {			//자릿수(입력값)
			for(int j=0;j<10;j++) {			//해당자릿수의 숫자 j에 대한 for문
				for(int k=j;k<10;k++) {		//해당자릿수의 숫자 j보다 큰 값(올림수)들만 for문
					stair[i][j]+=stair[i-1][k]%10007; // 누적저장된 아랫자리수 값을 더한다.
				}
			}
		}
		
		for(int i=0;i<10;i++) {
			result+=stair[num][i];			//해당 자릿수에 대한 값(일의 자리수 값이 1~9까지) 다 더함
		}

		return result%10007;                // 답에서 요구한대로 10007을 나눠서 return 
	}
}


public class dp_11057 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Up u=new Up();
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int result=u.upFunc(num);
		System.out.println(result);
	}
}
