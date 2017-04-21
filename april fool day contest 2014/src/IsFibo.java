import java.util.Scanner;
public class IsFibo {
	public static String isfibo(long x){
		long a=0,b=1,c;
		if(a!=x && b!=x){
			while(a!=x && b!=x && b<x){
				c=a+b;
				a=b;
				b=c;
			}
		}
		if(b==x){
			return "IsFibo";
		}
		else return "IsNotFibo";
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		long a[]=new long[T];
		for(int i=0;i<T;i++){
			a[i]=sc.nextLong();
		}
		for(int i=0;i<T;i++){
			System.out.println( isfibo(a[i]) );
		}
	}
}
