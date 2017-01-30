import java.util.Scanner;


class Func {
	
	public void func() {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int[] result=new int[num];
		for(int i=0;i<num;i++) {
			int type=sc.nextInt();
			int[] typeList=new int[type];
			for(int j=0;j<type;j++) {
				typeList[j]=sc.nextInt();
			}
			int money=sc.nextInt();
			result[i]+=func2(money,typeList,type);
		}
		for(int i=0;i<result.length;i++) {
			System.out.println(result[i]);
		}
	}
	
	public int func2(int money,int[] typeList,int type) {
		int count=0;
		if(type==1 || money==0) {
			if(money%typeList[0]==0) {
				return 1;
			}
			else {
				return 0;
			}
		}
		int leng=money/typeList[--type];
		for(int i=0;i<=leng;i++) {
			count+=func2(money-typeList[type]*i,typeList,type);
		}
		return count;
	}
}

public class nodp_9084_µ¿Àü {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Func f=new Func();
		f.func();
	}
}