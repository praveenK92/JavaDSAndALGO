package ShortestDistance;

/*
4 5
4 1 2 4 2 3 3 2 4 3

sol:
true false false false 
true true true true 
true true true true 
true true true true 
*/
import java.util.Scanner;
// Connected graph from 1 vertex to another
public class TransitiveClosure {
	static int adj[][];
	static boolean dist[][];
	static int V,M;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		V=sc.nextInt();
		M=sc.nextInt();
		
		adj=new int[V+1][V+1];
		dist=new boolean[V+1][V+1];
		
		for(int i=0;i<M;i++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			adj[a][b]=1;
			dist[a][b]=true;
		}
		for(int i=1;i<=V;i++){
			dist[i][i]=true;
		}
		
		for(int k=1;k<=V;k++){
			for(int i=1;i<=V;i++){
				for(int j=1;j<=V;j++){
					dist[i][j]=dist[i][j]||(dist[i][k] && dist[k][j]);
					//System.out.println("For "+k+" : i= "+i+" j= "+j+" dist: "+dist[i][j]);
				}
			}
		}
		for(int i=1;i<=V;i++){
			for(int j=1;j<=V;j++){
				System.out.print(dist[i][j]+" ");
			}
			System.out.println("\b");
		}
		sc.close();
	}
}
