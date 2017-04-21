package GeeksforGeeks;

import java.util.Scanner;
/*
3 3
1 2 3
4 8 2
1 5 3

sol:
1 3 6 
5 11 8 
6 11 11 
The minimum cost to go from (1,1) to (3,3) is: 11

4 4
0 1 0 0
1 1 1 0
1 0 1 1
1 0 1 0

Sol
0 1 1 1 
1 2 2 1 
2 2 3 2 
3 2 3 2 
The minimum cost to go from (1,1) to (4,4) is: 2

6 6
0 1 1 0 0 1
0 1 0 1 0 0
0 1 0 0 1 1
1 0 1 0 0 1
0 1 0 1 0 1
1 1 1 0 1 0

Sol
0 1 2 2 2 3
0 1 1 2 2 2
0 1 1 1 2 3
1 1 2 1 1 2
1 2 2 2 1 2
2 3 3 2 2 2
The minimum cost to go from (1,1) to (6,6) is: 2

*/
public class MinCostAllFourDirections {
	static int m,n;
	
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		int arr[][] = new int[m][n];
		int sol[][] = new int[m + 1][n + 1];
		
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
				// sol[i][j]=Integer.MAX_VALUE;
			}
		sc.close();

		sol[1][1] = arr[0][0];
		int X[]={-1,0,0,1};
		int Y[]={0,-1,1,0};
		
		// fill the 1st column
		for (int i = 1; i < m; i++)
			sol[i + 1][1] = sol[i][1] + arr[i][0];
		// fill the 1st row
		for (int i = 1; i < n; i++)
			sol[1][i + 1] = sol[1][i] + arr[0][i];

		for (int i = 2; i <= m; i++) {
			for (int j = 2; j <= n; j++) {
				int t = sol[i][j - 1] < sol[i - 1][j] ? sol[i][j - 1] : sol[i - 1][j];
				sol[i][j] = arr[i - 1][j - 1]+t;
			}
		}
		
		/*for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++)
				System.out.print(sol[i][j]+" ");
			System.out.println("");
		}
		//System.out.println("The minimum cost to go from (1,1) to (" + m + ","
			//	+ n + ") is: " + sol[m][n]);
		*/
		int count=0;
		for (int z = 0; z < m * n-1; z++) {
			boolean flag = false;
			count++;
			for (int i = 1; i <= m; i++)
				for (int j = 1; j <= n; j++) {

					for (int k = 0; k < 4; k++) {
						int ii = i + X[k], jj = j + Y[k];
						if (isSafe(ii, jj)) {

							if (sol[i][j] > sol[ii][jj] + arr[i - 1][j - 1]) {
								sol[i][j] = sol[ii][jj] + arr[i - 1][j - 1];
								flag = true;
							}
						}
					}
				}
			if(!flag)break;
		}
		
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++)
				System.out.print(sol[i][j]+" ");
			System.out.println("");
		}
		System.out.println("The minimum cost to go from (1,1) to (" + m + ","
				+ n + ") is: " + sol[m][n]+" & did it in "+count);
	}
	
	static boolean isSafe(int x,int y){
		return x>0 && y>0 && x<=m && y<=n;
	}
}
