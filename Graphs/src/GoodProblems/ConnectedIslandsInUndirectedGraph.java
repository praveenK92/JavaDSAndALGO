package GoodProblems;
import java.util.Scanner;
// only for undirected graph find connected components

public class ConnectedIslandsInUndirectedGraph {
	
	static int m,n,count;
	static int arr[][];
	static boolean visited[][];
	static int X[]={-1,-1,-1,0,0,1,1,1};
	static int Y[]={-1,0,1,-1,1,-1,0,1};
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		m=sc.nextInt();
		n=sc.nextInt();
		arr=new int[m][n];
		visited=new boolean[m][n];
		count=0;
		
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++){
				arr[i][j]=sc.nextInt();
			}
		
		sc.close();
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(arr[i][j]==1 && !visited[i][j]){
					DFS(i,j);
					count++;
				}
			}
		}
		
		System.out.println("The total no of islands is: "+count);
		
		
	}
	static boolean isSafe(int x,int y){
		return x>=0 && y>=0 && x<m && y<n && arr[x][y]==1 && !visited[x][y];
	}
	static void DFS(int x,int y){
		visited[x][y]=true;
		for(int i=0;i<8;i++){
			int xx=x+X[i],yy=y+Y[i];
			if(isSafe(xx,yy)){
				DFS(xx,yy);
			}
		}
	}

}

/*
5 5
1 1 0 0 0
0 1 0 0 1
1 0 0 1 1
0 0 0 0 0
1 0 1 0 1

The total no of islands is: 5
*/