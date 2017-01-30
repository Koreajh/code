import java.util.Scanner;

class Lotto {
	int max;
	
	public Lotto(int max) {
		this.max=max;
	}
	
	public void lottoFunc(int[] arr,Boolean[] arrBool,int depth,int num) {
		
		if(depth>5) {							//모든 로또번호가 선택되었을때
			for(int z=0;z<max;z++) {
				if(arrBool[z]) {
					System.out.print(arr[z]+" ");
				}
			}
			System.out.println("");
			return;
		}
		
		if(num>max-1) {						   //인덱스 선택범위에서 넘어갔을때
			return;
		}
		
		if(!arrBool[num]) {					  //선택 안됐으면
			arrBool[num]=true;				  //선택
			lottoFunc(arr,arrBool,depth+1,num+1);		
			
			arrBool[num]=false;							//다시 돌아오면서 false로
		}
		lottoFunc(arr,arrBool,depth,num+1); 		   //선택되어있으면 그냥 다음 인덱스로	
	}
}
public class Bt_6603_로또 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int num=1;
		while(num!=0) {
			num=sc.nextInt();
			int[] arr=new int[num];
			Boolean[] arrBool=new Boolean[num];
			Lotto lotto=new Lotto(num);
			for(int i=0;i<num;i++) {
				arrBool[i]=false;
				arr[i]=sc.nextInt();
			}
			lotto.lottoFunc(arr,arrBool,0,0);
			System.out.println("");
		}
	}

}
