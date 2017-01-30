import java.util.Scanner;

class LongDe{
	int max;
	int l=0;
	int[] dp;
	
	public LongDe(int max) {
		this.max=max;
		dp=new int[max];
	}
	
	public void DFunc(int[] arr){
	    
	    for(int i=0; i<max; i++)
	    {
	    	System.out.println("i:"+i);
	        dp[i]=1;
	        for(int j=i-1; j>=0; j--)
	        {
	        	System.out.println("j:"+j);
	            if(arr[i]<arr[j] && dp[i]<=dp[j])
	            {
	                dp[i]=dp[j]+1;
	            }
	        }
	    }
	    for(int i=0; i<max;i++)
	    {
	        if(l<dp[i])
	            l=dp[i];
	    }
	}
}

public class dp_11722 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int[] arr=new int[num];
		LongDe ld=new LongDe(num);
		for(int i=0;i<num;i++) {
			arr[i]=sc.nextInt();
		}
		ld.DFunc(arr);
		System.out.println(ld.l);
	}
}