import java.util.Scanner;
public class Fibo {
	/*private static int fibo(int n){
		if(n==1)
			return 0;
		else if(n==2)
			return 1;
		return fibo(n-1)+fibo(n-2);
	}*/
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the fibo term you want");
		int n=sc.nextInt();
		while(n<1){
			System.out.println("Enter the fibo term you want");
			n=sc.nextInt();
		}
		long Fibo[]=new long[n];
		Fibo[0]=0;
		if(n==2)Fibo[1]=1;
		if(n>2)
		{
			Fibo[1]=1;
			for(int i=2;i<n;i++){
				Fibo[i]=Fibo[i-1]+Fibo[i-2];
			}			
		}
		for(int i=0;i<n;i++)
			System.out.println(i+".	"+Fibo[i]);
	}
}
