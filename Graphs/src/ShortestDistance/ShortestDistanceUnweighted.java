package ShortestDistance;

import java.util.Scanner;

public class ShortestDistanceUnweighted {
	static int adj[][];
	static int dist[],path[];
	static int V,M,s,d;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		V=sc.nextInt();
		M=sc.nextInt();
		s=sc.nextInt();
		d=sc.nextInt();
		
		adj=new int[V+1][V+1];
		dist=new int[V+1];
		path=new int[V+1];
		
		for(int i=0;i<M;i++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			adj[a][b]=1;
			adj[b][a]=1;
		}
		for(int i=1;i<=V;i++){
			dist[i]=-1;
		}
		dist[s]=0;
		Queue Q=new Queue(V);
		Q.add(s);
		
		while(!Q.isEmpty()){
			int v=Q.peek();
			Q.remove();
			
			for(int i=1;i<=V;i++){
				if(adj[v][i]==1 && dist[i]==-1){
					dist[i]=dist[v]+1;
					Q.add(i);
					path[i]=v;
				}
			}
		}
		System.out.println("Distance of "+s+"from "+d+"is: "+dist[d]);
		sc.close();
	}
}
class Queue{
	int arr[];
	int front,rear,size;
	
	Queue(int x){
		rear=-1;
		front=-1;
		size=x;
		arr=new int[size];
	}
	boolean isEmpty(){
		return front==-1;
	}
	void add(int x){
		rear=(rear+1)%size;
		arr[rear]=x;
		if(front==-1)front=0;
	}
	int peek(){
		if(!isEmpty())
		return arr[front];
		else return -1;
	}
	void remove(){
		if(front==rear){
			front=-1;
			rear=-1;
		}
		else{
			front=(front+1)%size;
		}
	}
}