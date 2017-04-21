package ShortestDistance;

/*
4 4
1 2 5
2 3 3
3 4 1
1 4 10

Ans
0 5 8 9 
2147483647 0 3 4 
2147483647 2147483647 0 1 
2147483647 2147483647 2147483647 0 


*/

import java.util.Scanner;

// only for directed acyclic graphs
//finds all pairs of vertices shortest distance to each other.

public class FloydWarshallAlgo {
	static int wt[][];
	static int dist[][];
	static int V,M;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		V=sc.nextInt();
		M=sc.nextInt();
		
		wt=new int[V+1][V+1];
		dist=new int[V+1][V+1];
		
		
		for(int i=0;i<M;i++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			int w=sc.nextInt();
			wt[a][b]=w;
			//wt[b][a]=w;
		}
		for(int i=1;i<=V;i++){
			for(int j=1;j<=V;j++){
				if(wt[i][j]!=0)
					dist[i][j]=wt[i][j];
				else
					dist[i][j]=Integer.MAX_VALUE;
			}
		}
		for(int i=1;i<=V;i++)
			dist[i][i]=0;
		
		for(int k=1;k<=V;k++){
			for(int i=1;i<=V;i++){
				for(int j=1;j<=V;j++){
					
					if(dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE &&
							dist[i][j]>dist[i][k]+dist[k][j]){
						dist[i][j]=dist[i][k]+dist[k][j];
					}
					//System.out.println("For "+k+" : i= "+i+" j= "+j+" dist: "+dist[i][j]);
					
				}
			}
		}
		
		for(int i=1;i<=V;i++){
			for(int j=1;j<=V;j++){
				System.out.print(dist[i][j]+" ");
			}
			System.out.println("");
		}
		sc.close();
	}

}
