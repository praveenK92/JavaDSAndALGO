package ShortestDistance;
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

Distance of 1 from 1 is: 0
Distance of 1 from 2 is: 2
Distance of 1 from 3 is: 4
Distance of 1 from 4 is: 7
Distance of 1 from 5 is: -2
*/

// for all directed Graph even with -ve edges & -ve cycles
import java.util.Scanner;
// for directed graph
public class BellmanFordAlgoMain {
	static int adj[][];
	static int dist[],path[];
	static int V,M,s;
	static Edge edges[];
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		V=sc.nextInt();
		M=sc.nextInt();
		s=sc.nextInt();
		
		adj=new int[V+1][V+1];
		dist=new int[V+1];
		path=new int[V+1];
		edges=new Edge[M];
		
		for(int i=0;i<M;i++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			int w=sc.nextInt();
			adj[a][b]=1;
			
			//adj[b][a]=1;
			edges[i]=new Edge(a,b,w);
		}
		for(int i=1;i<=V;i++){
			dist[i]=Integer.MAX_VALUE;
		}
		dist[s]=0;
		
		for(int x=1;x<V;x++){
			boolean flag=false;
			for(Edge e:edges){
				/*System.out.println(e.src+": "+dist[e.src]+"  "+e.dest+": "+dist[e.dest]+
						" dist= "+e.w);*/
				if(dist[e.src]!=Integer.MAX_VALUE){
					//System.out.println(e.src+" inside");
					int a=dist[e.src]+e.w;
					if(dist[e.dest]>a){
						dist[e.dest]=a;
						flag=true;
					}
				}
			}
			if(!flag)break;
		}
		
		boolean flag=false;
		for(Edge e:edges){
			if(dist[e.src]!=Integer.MAX_VALUE){
				int a=dist[e.src]+e.w;
				if(dist[e.dest]>a){
					dist[e.dest]=a;
					flag=true;
				}
			}
			if(flag)break;
		}
		if(flag)
			System.out.println("Not possible Negative Gain Cycle");
		else{
			for(int i=1;i<=V;i++)
				System.out.println("Distance of "+s+" from "+i+" is: "+dist[i]);			
		}
		sc.close();
	}
}
class Edge{
	int src,dest,w;
	
	Edge(int a,int b,int c){
		src=a;dest=b;w=c;
	}
	Edge(Edge x){
		this.src=x.src;
		this.dest=x.dest;
		this.w=x.w;
	}
}

