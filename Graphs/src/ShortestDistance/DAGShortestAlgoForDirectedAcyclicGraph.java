package ShortestDistance;
// This algo is for DIRECTED ACYCLIC GRAPHS ONLY

/*
6 10 2
1 2 5
1 3 3
2 3 2
2 4 6
3 4 7
3 5 4
3 6 2
4 5 -1
4 6 1
5 6 -2

Distance of 2 from 1 is: 2147483647
Distance of 2 from 2 is: 0
Distance of 2 from 3 is: 2
Distance of 2 from 4 is: 6
Distance of 2 from 5 is: 5
Distance of 2 from 6 is: 3
*/

/*
5 9 1
1 2 6
2 3 5
3 2 -2
1 4 7
2 4 8
2 5 -4
4 3 -3
4 5 9
5 3 7
1 vertex Start: 1 Finish: 10
2 vertex Start: 2 Finish: 9
4 vertex Start: 5 Finish: 8
5 vertex Start: 6 Finish: 7
3 vertex Start: 3 Finish: 4
Distance of 1 from 1 is: 0
Distance of 1 from 2 is: 2
Distance of 1 from 3 is: 4
Distance of 1 from 4 is: 7
Distance of 1 from 5 is: 2

Wrong Answer. Bcz there is a CYCLE in the Graph
*/


import java.util.Scanner;

//First do topological sorting then start from the 1st node &
// calculate all the min edges. will work for all sorts of +ve or -ve edges

// we calculate for all the edges
public class DAGShortestAlgoForDirectedAcyclicGraph {
	static int wt[][],adj[][];
	static int dist[];
	static int V,M,s,time;
	static Vertex vertices[];
	static boolean visited[];
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		V=sc.nextInt();
		M=sc.nextInt();
		s=sc.nextInt();
		
		adj=new int[V+1][V+1];
		vertices=new Vertex[V+1];
		wt=new int[V+1][V+1];
		visited=new boolean[V+1];
		
		for(int i=0;i<M;i++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			int w=sc.nextInt();
			
			adj[a][b]=1;
			wt[a][b]=w;
		}
		for(int i=0;i<=V;i++){
			vertices[i]=new Vertex(i);
		}
		dist=new int[V+1];
		for(int i=0;i<=V;i++){
			dist[i]=Integer.MAX_VALUE;
		}
		dist[s]=0;
		
		time=0;
		for(int i=1;i<=V;i++)
			if(!visited[i])
				DFS(i);
		
		for(int i=1;i<=V;i++){
			boolean swap=false;
			for(int j=1;j<=V-i;j++){
				if(vertices[j].f < vertices[j+1].f){
					Vertex a=new Vertex(vertices[j]);
					vertices[j]=vertices[j+1];
					vertices[j+1]=a;
					swap=true;
				}
			}
			if(!swap)break;
		}
		for(int i=1;i<=V;i++){
			System.out.println(vertices[i].data+" vertex Start: "+vertices[i].d+" Finish: "+
		vertices[i].f);
		}
		for(int z=1;z<=V;z++){
			int v=vertices[z].data;
			if(dist[v]==Integer.MAX_VALUE)continue;
			
			for(int i=1;i<=V;i++){				
				if(adj[v][i]==1){
					int a=dist[v]+wt[v][i];
					if(dist[i]>a)dist[i]=a;
				}
			}
		}
		
		for(int i=1;i<=V;i++)
			System.out.println("Distance of "+s+" from "+i+" is: "+dist[i]);
		sc.close();
	}
	
	static void DFS(int v){
		visited[v]=true;
		time++;
		vertices[v].d=time;
		for(int i=1;i<=V;i++){
			if(adj[v][i]==1 && !visited[i])
				DFS(i);
		}
		time++;
		vertices[v].f=time;
	}

}

class Vertex{
	int data;
	int d,f;
	Vertex(int a){
		data=a;
		d=-1;f=-1;
	}
	Vertex(Vertex x){
		data=x.data;
		d=x.d;
		f=x.f;
	}
}
