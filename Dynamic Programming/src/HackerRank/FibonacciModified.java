package HackerRank;
import java.util.Scanner;
import java.math.*;
public class FibonacciModified {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long a=sc.nextLong();
		long b=sc.nextLong();
		int n=sc.nextInt();
		sc.close();
		//BigInteger nb=new BigInteger(Integer.toString(1));
		BigInteger sol[]=new BigInteger[n];
		sol[0]=BigInteger.valueOf(a);
		sol[1]=BigInteger.valueOf(b);
		for(int i=2;i<n;i++){
			sol[i]=sol[i-1].pow(2).add(sol[i-2]);
		}
		
		System.out.println(sol[n-1]);
	}

}
