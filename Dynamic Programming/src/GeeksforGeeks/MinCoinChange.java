package GeeksforGeeks;

/*
20 3
2 5 10

Sol
2147483647 1 2147483647 2 2147483647 3 2147483647 4 2147483647 5 2147483647 6 2147483647 7 2147483647 8 2147483647 9 2147483647 10 
2147483647 1 2147483647 2 1 3 2 4 3 2 4 3 5 4 3 5 4 6 5 4 
2147483647 1 2147483647 2 1 3 2 4 3 1 4 2 5 3 2 4 3 5 4 2 


*/
import java.util.Scanner;

// get the required amount in min no of coins

public class MinCoinChange {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		int arr[] = new int[s + 1];
		for (int i = 1; i <= s; i++)
			arr[i] = sc.nextInt();
		
		sc.close();
		
		int sol[][] = new int[s + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			sol[0][i] = Integer.MAX_VALUE;
		}

		for (int i = 1; i <= s; i++) {
			for (int j = 1; j <= n; j++) {
				if (arr[i] <= j) {
					if (sol[i][j - arr[i]] != Integer.MAX_VALUE) {
						int t = 1 + sol[i][j - arr[i]];
						sol[i][j] = t < sol[i - 1][j] ? t : sol[i - 1][j];
					} else {
						sol[i][j] = sol[i - 1][j];
					}
				} else {
					sol[i][j] = sol[i - 1][j];
				}
			}
		}
		for (int i = 1; i <= s; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(sol[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
