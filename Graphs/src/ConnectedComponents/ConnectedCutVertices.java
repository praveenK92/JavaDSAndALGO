package ConnectedComponents;
import java.util.Scanner;
// only for Directed Graph
public class ConnectedCutVertices {
	static int adj[][],parent[],child[];
	static int V,E;
	static boolean visited[],CutVertex[];
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		V=sc.nextInt();
		E=sc.nextInt();
		
		adj=new int[V+1][V+1];
		visited=new boolean[V+1];
		parent=new int[V+1];
		child=new int[V+1];
		CutVertex=new boolean[V+1];
		
		for(int i=0;i<E;i++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			adj[a][b]=1;
			parent[b]++;
			child[a]++;
		}
		sc.close();
		for(int i=1;i<=V;i++)
			if(!visited[i])
				DFS(i);
		
		for(int i=1;i<=V;i++){
			if(CutVertex[i])System.out.print("Vertex "+i+" is CutVertex");
		}
		System.out.println(" ");
		for(int i=1;i<=V;i++){
			System.out.println("Vertex "+i+" CutVertex "+CutVertex[i]);
		}
	}
	
	static void DFS(int v){
		visited[v]=true;
		
		for(int i=1;i<=V;i++){
			if(adj[v][i]==1){
				if(parent[i]<2){
					CutVertex[v]=true;
				}
				
				if(!visited[i])DFS(i);
				
			}
		}
		if(parent[v]==0 && child[v]>=2)
			CutVertex[v]=true;
		if(parent[v]==0 && child[v]==1)
			CutVertex[v]=false;
		
	}
}
/*
5 5
3 1 4 3 4 5
1 2 2 3
Vertex 1 CutVertex false
Vertex 2 CutVertex false
Vertex 3 CutVertex false
Vertex 4 CutVertex true
Vertex 5 CutVertex false

4 3
1 2 2 3 3 4
Vertex 1 CutVertex false
Vertex 2 CutVertex true
Vertex 3 CutVertex true
Vertex 4 CutVertex false
*/

