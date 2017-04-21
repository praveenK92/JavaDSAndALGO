package GraphTraversals;
// Topological Sort only for DIRECTED ACYCLIC GRAPHS
import java.util.Scanner;
//directed edges
public class TopologicalSortOnFinishTimeDFS {
	static int adj[][];
	static boolean visited[];
	static int V,M,time;
	static Vertex2 Vertices[];
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		V=sc.nextInt();
		M=sc.nextInt();
		
		adj=new int[V+1][V+1];
		visited=new boolean[V+1];
		Vertices=new Vertex2[V+1];
		for(int i=0;i<=V;i++){
			//System.out.println(i+1);
			Vertices[i]=new Vertex2(i);
		}
		
		for(int i=0;i<M;i++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			adj[a][b]=1;
		}
		time=0;
		for(int i=1;i<=V;i++){
			if(!visited[i])
				DFS(i);
		}
		
		for(int i=1;i<=V;i++){
			System.out.println(Vertices[i].data+" finish time: "+Vertices[i].finish);
		}
		
		for(int i=1;i<=V;i++){
			boolean swap=false;
			for(int j=1;j<=V-i;j++){
				if(Vertices[j].finish < Vertices[j+1].finish){
					Vertex2 a=new Vertex2(Vertices[j]);
					Vertices[j]=Vertices[j+1];
					Vertices[j+1]=a;
					swap=true;
				}
			}
			if(!swap)break;
		}
		System.out.println("Topologically Sorted : ");
		for(int i=1;i<=V;i++){
			System.out.println(Vertices[i].data+" finish time: "+Vertices[i].finish);
		}
		sc.close();
	}
	static void DFS(int v){
		visited[v]=true;
		time++;
		Vertices[v].start=time;
		for(int i=1;i<=V;i++){
			if(adj[v][i]==1 && !visited[i]){
				DFS(i);
			}
		}
		time++;
		Vertices[v].finish=time;
	}

}
class Vertex2{
	int data;
	int start,finish;
	Vertex2(){
		data=-1;
		start=-1;finish=-1;
	}
	Vertex2(int d){
		data=d;
		start=-1;finish=-1;
	}
	Vertex2(Vertex2 x){
		data=x.data;
		start=x.start;
		finish=x.finish;
	}
}
/*
9 9
1 2 2 3 1 4 4 3
6 5 5 4 6 8 5 8 7 8
 */
