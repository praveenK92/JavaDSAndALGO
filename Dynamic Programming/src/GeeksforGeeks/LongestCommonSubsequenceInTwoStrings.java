package GeeksforGeeks;

import java.util.Scanner;

/*
AGGTAB
GXTXAYB

X= AGGTAB
Y= GXTXAYB
The LCS of X & Y is: 4

 */
public class LongestCommonSubsequenceInTwoStrings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String X = sc.nextLine();
		String Y = sc.nextLine();
		sc.close();
		int m = X.length();
		int n = Y.length();

		int LCS[][] = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {

				if (X.charAt(i - 1) == Y.charAt(j - 1)) {
					LCS[i][j] = 1 + LCS[i - 1][j - 1];
				} else {
					LCS[i][j] = LCS[i - 1][j] > LCS[i][j - 1] ? LCS[i - 1][j]
							: LCS[i][j - 1];
				}
			}
		}
		System.out.println("X= " + X + "\nY= " + Y + "\nThe LCS of X & Y is: "
				+ LCS[m][n]);
	}

}
