package HackerRank;

import java.util.Scanner;

public class LongestIncreaingSubsequence {
	static int arr[],LIS[];
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		arr=new int[N];
		LIS=new int[N];
		
		for(int i=0;i<N;i++){
			arr[i]=sc.nextInt();
			LIS[i]=1;
		}
		sc.close();
		for(int i=1;i<N;i++){
			for(int j=0;j<i;j++){
				if(arr[j]<arr[i] && LIS[i]<LIS[j]+1){
					LIS[i]=LIS[j]+1;
				}
			}
		}
		int ans=-1;
		for(int i=0;i<N;i++)
			ans=Math.max(ans, LIS[i]);		
		System.out.print(ans);
	}
}
