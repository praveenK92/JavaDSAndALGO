package GeeksforGeeks;

import java.util.Arrays;
/*
coin price  :: no of avl coins
price[]...
4 3
1 2 3

sol
1 1 1 1 
1 2 2 3 
1 2 3 4 

10 4
2 3 5 6

sol
0 1 0 1 0 1 0 1 0 1 
0 1 1 1 1 2 1 2 2 2 
0 1 1 1 2 2 2 3 3 4 
0 1 1 1 2 3 2 4 4 5 

*/
import java.util.Scanner;

public class CoinChange {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int arr[]=new int[m+1];
		for(int i=1;i<=m;i++)
			arr[i]=sc.nextInt();
		sc.close();
		int sol[][]=new int[m+1][n+1];
		Arrays.sort(arr);
		for(int i=1;i<=m;i++)
			sol[i][0]=1;
		
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				if(arr[i]<=j){
					sol[i][j]=sol[i][j-arr[i]]+sol[i-1][j];
				}
				else{
					sol[i][j]=sol[i-1][j];
				}
			}
		}
		// space efficient way
		int sol2[]=new int[n+1];
		sol2[0]=1;
		for(int i=1;i<=m;i++){
			for(int j=arr[i];j<=n;j++){
				sol2[j]+=sol2[j-arr[i]];
			}
		}
		
		for(int i:sol2)System.out.print(i+" ");
		System.out.println("the next sol");
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				 System.out.print(sol[i][j]+" ");
			}
			System.out.println("");
		}
	}

}
