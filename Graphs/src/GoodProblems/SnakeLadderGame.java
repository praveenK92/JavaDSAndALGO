package GoodProblems;

/*

 25
 4
 2 6
 12 11
 13 -10
 14 10

 answer: 3 turns
 */
import java.util.Scanner;

// player starts from 0 always
public class SnakeLadderGame {

	static int moves[], gain[], n;
	static Queue2 Q;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int g = sc.nextInt();
		gain = new int[n + 1];
		for (int i = 0; i < g; i++) {
			int a = sc.nextInt();
			gain[a] = sc.nextInt();
		}
		sc.close();
		
		moves = new int[n + 1];
		Q = new Queue2(n);
		Q.add(0);

		int x[] = { 1, 2, 3, 4, 5, 6 };
		while (!Q.isEmpty()) {
			int v = Q.remove();
			for (int i = 0; i < 6; i++) {
				int xx = v + x[i];
				if (isSafe(xx)) {
					if (moves[xx] == 0)
						moves[xx] = 1 + moves[v];
					else
						moves[xx] = min(moves[xx], 1 + moves[v]);

					if (gain[xx] != 0) {
						if (moves[xx + gain[xx]] == 0)
							moves[xx + gain[xx]] = 1 + moves[v];
						else
							moves[xx + gain[xx]] = min(moves[xx + gain[xx]],
									1 + moves[v]);

						if (!Q.check(xx + gain[xx]))
							Q.add(xx + gain[xx]);
					}

					else {
						// moves[xx]=1+moves[v];
						Q.add(xx);
					}
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			System.out.println(i + " place: no of moves= " + moves[i] + " ");
		}
	}

	static int min(int a, int b) {
		return a < b ? a : b;
	}

	static boolean isSafe(int x) {
		return x <= n && x >= 0;
	}
}

class Queue2 {
	int f, r, s;
	int arr[];

	Queue2(int s1) {
		f = -1;
		r = -1;
		s = s1;
		arr = new int[s];
	}

	boolean isEmpty() {
		return f == -1;
	}

	void add(int x) {
		r = (r + 1) % s;
		arr[r] = x;
		if (f == -1)
			f = 0;
	}

	int remove() {
		if (f != -1) {
			int t = arr[f];
			if (f == r) {
				f = -1;
				r = -1;
			} else
				f = (f + 1) % s;
			return t;
		} else
			return -1;
	}

	boolean check(int x) {
		for (int i = f; i <= r;) {
			if (arr[i] == x)
				return true;
			i = (i + 1) % s;
		}
		return false;
	}
}