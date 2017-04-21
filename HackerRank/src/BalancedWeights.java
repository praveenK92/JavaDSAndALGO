import java.util.*;
import java.lang.*;

public class BalancedWeights {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		int soll[]=new int[T];
		
		for(int i=0;i<T;i++){
			int n=sc.nextInt();
			int arr[]=new int[n];
			for(int j=0;j<n;j++){
				arr[j]=sc.nextInt();
			}
			soll[i]=Sol(arr,n);		
		}
		for(int i:soll)System.out.println(i);
	}
	
	public static int Sol(int a[],int n){
		Arrays.sort(a);
		
		while(a[0]<a[n-1]){
			for(int i=1;i<n;i++){
				if(a[i]>a[0])
					a[i]=a[i]-a[0];
			}
			Arrays.sort(a);
		}
		int temp=n*a[0];
		return temp;
	}
}