package GeeksforGeeks;
/*
50 3
10 60
20 100
30 120
The max Knapsack is: 300
50 3
10 60
20 200
30 150


*/

import java.util.Scanner;

public class KnapSackWithInfiniteResources {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int W=sc.nextInt();
		int n=sc.nextInt();
		int wt[]=new int[n+1];
		int pr[]=new int[n+1];
		for(int i=1;i<=n;i++){
			wt[i]=sc.nextInt();
			pr[i]=sc.nextInt();
		}
		
		sc.close();
		// ks for knapsack
		int ks[][]=new int[n+1][W+1];
		
		for(int i=1;i<=n;i++){
			for(int j=1;j<=W;j++){
				if(wt[i]<=j){
					int t=pr[i]+ks[i][j-wt[i]];
					ks[i][j]=t>ks[i-1][j]?t:ks[i-1][j];
				}
				else{
					ks[i][j]=ks[i-1][j];
				}
			}
		}
		
		System.out.println("The max Knapsack is: "+ks[n][W]);
		
	}
}
