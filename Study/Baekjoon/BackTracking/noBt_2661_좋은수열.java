import java.util.Scanner;

class Good {
	int max;
	int min=9999999;
	public Good(int num) {
		this.max=num;
	}
	
	public void goodFunc(String good,int depth) {
		
		if(depth==1) {
			goodFunc(good+'2',depth+1);
		}
		
		if(depth>1) {
			if(isGood(good,depth)) {					// 좋은수열인지 판별
				if(max!=depth) {					
					for(char z='1';z<='3';z++) {	// 마지막값에 1 or 2 or 3 넣으면서 재귀반복
						if(good.indexOf(z,depth-1)<0) {
							goodFunc(good+z,depth+1);
						}
					}
				} else {
					 if(min>Integer.parseInt(good)) {
							min=Integer.parseInt(good);
					 }
				}
			}
		}
	     
	}
	
	public boolean isGood(String good,int c) {		//좋은 수열인지 판별함수
		
		for(int i=1;i<=c/2;i++) {                   //절반만큼까지 자르면서 비교
			if(good.substring(c-i,c).equals(good.substring(c-(2*i),c-i))) {
				return false;						//같으면 좋은수열 아니므로 false
			} 
		}
		return true;								//전부 다르면 좋은수열이므로 true
	}

}

public class noBt_2661_좋은수열 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		Good g=new Good(num);
		String good="1";
		g.goodFunc(good,1);
		System.out.println(g.min);
	}
}