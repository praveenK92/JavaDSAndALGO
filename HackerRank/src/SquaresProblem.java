import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SquaresProblem {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int T[]=new int[N];
		for(int i=0;i<N;i++){
			T[i]=sc.nextInt();
		}
		BigInteger ans[]=new BigInteger[N];
		long a=(long)(Math.pow(10,9)+7);
		for(int i=0;i<N;i++){
			ans[i]=BigInteger.valueOf(2).add(BigInteger.valueOf(2).pow(T[i]+1));
			ans[i]=ans[i].mod(BigInteger.valueOf(a));
			System.out.println(ans[i]);
		}
	}
}
