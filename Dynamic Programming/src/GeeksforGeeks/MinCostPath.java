package GeeksforGeeks;

import java.util.Scanner;
/*
3 3
1 2 3
4 8 2
1 5 3

Soln:
1 3 6 
5 9 5 
6 10 8 
The minimum cost to go from (1,1) to (3,3) is: 8


*/
public class MinCostPath {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int arr[][] = new int[m][n];
		int sol[][] = new int[m + 1][n + 1];
		
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
				// sol[i][j]=Integer.MAX_VALUE;
			}
		sc.close();

		sol[1][1] = arr[0][0];

		// fill the 1st column
		for (int i = 1; i < m; i++)
			sol[i + 1][1] = sol[i][1] + arr[i][0];
		// fill the 1st row
		for (int i = 1; i < n; i++)
			sol[1][i + 1] = sol[1][i] + arr[0][i];

		for (int i = 2; i <= m; i++) {
			for (int j = 2; j <= n; j++) {
				int t = sol[i][j - 1] < sol[i - 1][j - 1] ? sol[i][j - 1]
						: sol[i - 1][j - 1];
				sol[i][j] = arr[i - 1][j - 1]
						+ (t < sol[i - 1][j] ? t : sol[i - 1][j]);
				//System.out.print(sol[i][j]+" ");
			}
			//System.out.println("");
		}
		
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++)
				System.out.print(sol[i][j]+" ");
			System.out.println("");
		}
		System.out.println("The minimum cost to go from (1,1) to (" + m + ","
				+ n + ") is: " + sol[m][n]);
	}

}
