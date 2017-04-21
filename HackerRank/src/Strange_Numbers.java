import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Strange_Numbers {
	private static ArrayList<Long> list=new ArrayList<Long>();
	private static long prev=0;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		long arr[][]=new long[N][2];
		long sol[]=new long[N];
		
		for(int i=0;i<N;i++){
			arr[i][0]=sc.nextInt();
			arr[i][1]=sc.nextInt();
		}
		
		for(long i=0;i<=9;i++){
			list.add(i);
		}
		prev=9;
		for(long i=10;i<=1000000;i++){
			if(recursive(i)){
				list.add(i);
				prev=i;
			}
		}
		
		for(int i=0;i<N;i++){
			long count=0;
			for(long j=arr[i][0];j<=arr[i][1];j++){
				if(j==0){
					count++;
					continue;
				}
				
				else if(j<100000 && j<prev){
					if(list.contains(j)){
						count++;
						continue;
					}
					else
						continue;
				}
				
				else if(recursive(j)){
					list.add(j);
					prev=j;
					count++;
					System.out.println("no is: "+j);
				}
				else continue;
			}
			sol[i]=count;
		}
		
		for(int i=0;i<N;i++){
			System.out.println(sol[i]);
		}
}
	
	public static boolean recursive(long b){
		if(b==0)return false;
		else if(b<100000){
			if(list.contains(b))return true;
			else return false;
		}
		
		long x=b;
		int len=0;
		boolean flag=false;
		
		while(x!=0){
			x=x/10;
			len++;
		}
		if(len==1)return true;
		else if(b%len==0){
			long k=b/len;
			flag=recursive(k);
			
			if(flag)return true;
			else return false;
			}
		else return false;
	}
}