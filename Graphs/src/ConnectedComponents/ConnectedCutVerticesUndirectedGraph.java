package ConnectedComponents;

import java.util.Scanner;
// for undirected graph
// not done it is wrong logic
public class ConnectedCutVerticesUndirectedGraph {
	static int adj[][];
	static int V,E;
	static boolean visited[],CutVertex[],backEdge[],RecStack[];
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		V=sc.nextInt();
		E=sc.nextInt();
		
		adj=new int[V+1][V+1];
		visited=new boolean[V+1];
		CutVertex=new boolean[V+1];
		backEdge=new boolean[V+1];
		RecStack=new boolean[V+1];
		
		for(int i=0;i<E;i++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			adj[a][b]=1;
			adj[b][a]=1;
			
		}
		sc.close();
		for(int i=1;i<=V;i++)
			if(!visited[i])
				DFS(i);
		
		for(int i=1;i<=V;i++){
			boolean flag=false;
			for(int j=1;j<=V;j++){
				if(adj[i][j]==1 && !backEdge[j]){
					flag=true;
				}
				if(flag){
					CutVertex[i]=true;
					break;
				}
			}
		}
		
		for(int i=1;i<=V;i++){
			if(CutVertex[i])System.out.print("Vertex "+i+" is CutVertex ");
		}
		System.out.println(" ");
		for(int i=1;i<=V;i++){
			System.out.println("Vertex "+i+" CutVertex "+CutVertex[i]);
		}
	}
	
	static void DFS(int v){
		visited[v]=true;
		RecStack[v]=true;
		
		for(int i=1;i<=V;i++){
			if(adj[v][i]==1){				
				if(!visited[i])
					DFS(i);
				else if(RecStack[i])
					backEdge[i]=true;
			}
		}
		RecStack[v]=false;		
	}
}