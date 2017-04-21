package HackerRank;
/*

Given a list of n integers, A={a1,a2,…,an}, and another integer,
k representing the expected sum.
Select zero or more numbers from A such that
the sum of these numbers is as near as possible,
but not exceeding, to the expected sum (k). 

2
3 12
1 6 9
5 9
3 4 4 4 8

Soln
12
9
*/
import java.util.Scanner;
public class KnapSack {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int x=1;x<=T;x++){
			int n=sc.nextInt();
			int k=sc.nextInt();
			int A[]=new int[n+1];
			for(int i=1;i<=n;i++)
				A[i]=sc.nextInt();
			
			// ks for knapsack
			int ks[][]=new int[n+1][k+1];
			
			for(int i=1;i<=n;i++){
				for(int j=1;j<=k;j++){
					if(A[i]<=j){
						int t=ks[i][j-A[i]]+A[i];
						if(t<=j){
							if(ks[i-1][j]<=j)
								ks[i][j]=t>ks[i-1][j]?t:ks[i-1][j];
							else
								ks[i][j]=t;
						}
						else{
							ks[i][j]=ks[i-1][j];
						}
					}
					else{
						ks[i][j]=ks[i-1][j];
					}
				}
			}
			
			System.out.println(ks[n][k]);
		}
		sc.close();
		
	}

}
