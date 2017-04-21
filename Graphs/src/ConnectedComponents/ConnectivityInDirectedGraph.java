package ConnectedComponents;
//COnnectivity in Directed Graph exists if every two pair of vertices
// are strongly connected.

import java.util.Scanner;

public class ConnectivityInDirectedGraph {
	static int adj[][],revAdj[][],StronglyConnected[];
	static int V,E,count;
	static boolean visited[];
	static Stack S;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		V=sc.nextInt();
		E=sc.nextInt();
		
		adj=new int[V+1][V+1];
		revAdj=new int[V+1][V+1];
		visited=new boolean[V+1];
		StronglyConnected=new int[V+1];
		
		for(int j=0;j<E;j++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			adj[a][b]=1;
			revAdj[b][a]=1;
		}
		sc.close();	
		S=new Stack(V);
		for(int i=1;i<=V;i++){
			if(!visited[i])
				DFS(i);
		}
		
		for(int i=1;i<=V;i++)visited[i]=false;
		count=1;
		while(!S.isEmpty()){
			int v=S.peek();
			//System.out.print(v+" ");
			S.pop();
			if(!visited[v]){
				RevDFS(v);
				count++;
			}
		}
		if(count==2)
			System.out.println("Yes there is connectivity in the graph");
		else
			System.out.println("No connectivity in the graph");
		
		
	}
	static void RevDFS(int v){
		visited[v]=true;
		StronglyConnected[v]=count;
		System.out.println("Vertex: "+v+" Set: "+StronglyConnected[v]);
		for(int i=1;i<=V;i++){
			if(revAdj[v][i]==1 && !visited[i]){
				RevDFS(i);
			}
		}
	}
	static void DFS(int v){
		visited[v]=true;
		for(int i=1;i<=V;i++){
			if(adj[v][i]==1 && !visited[i]){
				DFS(i);
			}
		}
		S.push(v);
	}

}
/*
5 6
1 2 2 3 3 4 4 3
5 1 3 5
*/