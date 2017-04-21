package ConnectedComponents;

import java.util.Scanner;

public class TwoConnectedVertices {
	static int adj[][];
	static int V,E,s,d;
	static boolean visited[];
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		V=sc.nextInt();
		E=sc.nextInt();
		s=sc.nextInt();
		d=sc.nextInt();
		
		adj=new int[V+1][V+1];
		visited=new boolean[V+1];
		
		for(int j=0;j<E;j++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			adj[a][b]=1;
		}
		DFS(s);
		if(visited[d])
			System.out.println("Path exist from "+s+" to "+d);
		else
			System.out.println("No Path exist from "+s+" to "+d);
	}
	static void DFS(int v){
		visited[v]=true;
		if(v==d)return;
		for(int i=1;i<=V;i++){
			if(adj[v][i]==1 && !visited[i]){
				DFS(i);
			}
		}
	}
}
/*
4 6
1 3
1 2
1 4 4 1 2 4
4 3 3 3
*/