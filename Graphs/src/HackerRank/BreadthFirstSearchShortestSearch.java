package HackerRank;
import java.util.Scanner;
public class BreadthFirstSearchShortestSearch {
	static int V,M,s;
	static int dist[];
	static boolean adj[][];
	static Queue Q;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=1;t<=T;t++){
			V=sc.nextInt();
			M=sc.nextInt();
			
			Q=new Queue(V);
			adj=new boolean[V+1][V+1];
			dist=new int[V+1];
			
			for(int i=0;i<M;i++){
				int a=sc.nextInt();
				int b=sc.nextInt();
				adj[a][b]=true;
				adj[b][a]=true;
			}
			s=sc.nextInt();
			
			for(int i=1;i<=V;i++)dist[i]=-1;
			
			dist[s]=0;
			Q.add(s);
			while(!Q.isEmpty()){
				int v=Q.remove();
				for(int i=1;i<=V;i++){
					if(adj[v][i] && dist[i]==-1){
						dist[i]=dist[v]+6;
						Q.add(i);
					}
					else if(adj[v][i] && dist[i]>dist[v]+6){
						dist[i]=dist[v]+6;
						Q.add(i);
					}
				}
			}
			for(int i=1;i<V;i++)if(i!=s)System.out.print(dist[i]+" ");
			if(V!=s)System.out.println(dist[V]);
		}
		sc.close();
	}

}/*
class Queue{
	int f,r,s;
	int arr[];
	
	Queue(int s1){
		f=-1;r=-1;s=s1;
		arr=new int[s];
	}
	boolean isEmpty(){
		return f==-1;
	}
	void add(int x){
		r=(r+1)%s;
		arr[r]=x;
		if(f==-1)f=0;
	}
	int remove(){
		if(f!=-1){
			int t=arr[f];
			if(f==r){
				f=-1;r=-1;
			}
			else f=(f+1)%s;
				return t;
		}
		else return -1;
	}
}
*/