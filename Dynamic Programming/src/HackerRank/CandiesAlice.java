package HackerRank;

import java.util.Scanner;
public class CandiesAlice {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n+2];
		for(int i=1;i<=n;i++)
			arr[i]=sc.nextInt();
		
		sc.close();
		int sol[]=new int[n+2];
		
		//for(int i=1;i<=n;i++)sol[i]=1;
		
		for (int k = 1; k <= 1; k++) {
			for (int i = 1; i <= n; i++) {
				int prev = 0, next = 0;
				if (arr[i]>arr[i - 1] && arr[i]>arr[i+1]){
					prev=1+arr[i-1];
					next=1+arr[i+1];
					sol[i]=max(prev,next);
				}
				else if(arr[i]>arr[i-1] && arr[i]<arr[i+1]){
					prev=arr[i-1]+1;
					//next=arr[i+1]-1;
					sol[i]=prev;
				}
				else if(arr[i]>arr[i+1] && arr[i]<arr[i-1]){
					//prev=arr[i-1]-1;
					next=arr[i+1]+1;
					sol[i]=next;
				}
				else{
					sol[i]=1;
				}
			}
		}
		for(int i:sol)System.out.print(i+" ");
		int ans=0;
		for(int i=1;i<=n;i++){
			ans+=sol[i];
		}
		System.out.println(ans);
	}
	static int max(int x,int y){
		return x>y?x:y;
	}
	static int min(int x,int y){
		return x<y?x:y;
	}
}
