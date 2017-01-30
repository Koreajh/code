import java.util.Scanner;

class Estair {
	public int EstairFunc(int num) {
		int result=0;
		int[][] arr=new int[10][num];
		arr[0][0]=0;
		for(int i=1;i<10;i++) {
			arr[i][0]=1;
		}
		for(int i=1;i<num;i++) {
			arr[0][i]=arr[i][0];
			for(int j=1;j<9;j++) {
				arr[j][i]=arr[j-1][i-1]+arr[j+1][i-1];
			}
			arr[9][i]=arr[8][i-1];
		}
		
		for(int i=0;i<10;i++) {
			result+=arr[i][num-1];
		}
		return result;
	}
}


public class dp_10844 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Estair es=new Estair();
		int num=sc.nextInt();
		int result=es.EstairFunc(num);
		System.out.println(result);

	}

}
