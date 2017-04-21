package GoodProblems;

/*
 8 8
 1 1 8 8

The total no of moves to go from 1 1 to  8 8 is: 6
 */
import java.util.Scanner;

public class ChessKnightGoFromOnePointToAnother {
	// static boolean visited[][];
	static int dist[][], m, n;
	static Queue Q;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		int s1 = sc.nextInt();
		int s2 = sc.nextInt();
		int d1 = sc.nextInt();
		int d2 = sc.nextInt();

		sc.close();

		Q = new Queue(m * n);
		dist = new int[m + 1][n + 1];
		//dist[s1][s2] = 0;
		Q.add(s1, s2);

		dist[s1][s2] = 0;

		int X[] = { -2, -2, -1, -1, 1, 1, 2, 2 };
		int Y[] = { -1, 1, -2, 2, -2, 2, -1, 1 };

		while (!Q.isEmpty()) {
			Point v = new Point(Q.remove());

			if (v.x == d1 && v.y == d2)
				break;

			for (int i = 0; i < 8; i++) {
				int xx = v.x + X[i], yy = v.y + Y[i];
				//System.out.println("Point is: "+xx+" "+yy);
				if (isSafe(xx, yy)) {
					
					int t=dist[v.x][v.y] + 1;
					
					if(dist[xx][yy]==0){
						dist[xx][yy] = t;
						Q.add(xx, yy);
						//System.out.println("Point is: "+xx+" "+yy);
					}/*
					else{
						if(dist[xx][yy]<t){
							dist[xx][yy]=t;
							Q.add(xx, yy);
						}
					}*/
										
					System.out.println("I am at (" + xx + "," + yy+")"
							+ " in moves: " + dist[xx][yy]+" from ("+v.x+","+v.y+")");
				}
			}
		}
		System.out.println("The total no of moves to go from " + s1 + " " + s2
				+ " to " + " " + d1 + " " + d2 + " is: " + dist[d1][d2]);

	}

	public static boolean isSafe(int x, int y) {
		if(x<=0 || y<=0)
			return false;
		else if(x <= m && y <= n)
			return true;
		else return false;
	}

}

class Queue {
	int front, rear, size;
	Point arr[];

	Queue(int s) {
		this.size = s;
		rear = front = -1;
		arr = new Point[size];
	}

	boolean isEmpty() {
		return front == -1;
	}

	void add(int xx, int yy) {
		rear = (rear + 1) % size;
		arr[rear]=new Point(xx,yy);
		//System.out.println(rear+" Point: "+arr[rear].x+" "+arr[rear].y);
		if (front == -1)
			front = 0;
	}

	Point remove() {
		Point x = new Point(arr[front]);
		//Point x=arr[front];
		if (front == rear) {
			front = -1;
			rear = -1;
			return x;
		} else {
			front = (front + 1) % size;
			return x;
		}
	}
}

class Point {
	int x;
	int y;
	Point(){
		x=-1;y=-1;
	}
	Point(int a,int b){
		x=a;
		y=b;
	}
	Point(Point z){
		this.x=z.x;
		this.y=z.y;
	}
}
