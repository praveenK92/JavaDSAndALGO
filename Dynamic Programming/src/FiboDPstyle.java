public class FiboDPstyle {
	static int fib[];
	
	public static void main(String[] args) {
		int n=10;
		int f[]=fibonacci(n);
		for(int i:f)System.out.println(i);
	}
	
	public static int[] fibonacci(int n){
		if(n==0){int a[]={0};return a;}
		else if(n==1){int a[]={0,1};return a;}
		fib=new int[n+1];
		fib[0]=0;
		fib[1]=1;
		for(int i=2;i<=n;i++){
			fib[i]=fib[i-1]+fib[i-2];
		}
		return fib;
	}

}
