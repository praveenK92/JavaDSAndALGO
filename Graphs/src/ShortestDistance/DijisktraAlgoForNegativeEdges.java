package ShortestDistance;

import java.util.Scanner;

public class DijisktraAlgoForNegativeEdges {
	static int wt[][],adj[][];
	static int dist[],path[];
	static int V,M,s,d;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		V=sc.nextInt();
		M=sc.nextInt();
		s=sc.nextInt();
		d=sc.nextInt();
		
		wt=new int[V+1][V+1];
		adj=new int[V+1][V+1];
		dist=new int[V+1];
		path=new int[V+1];
		
		for(int i=0;i<M;i++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			int w=sc.nextInt();
			adj[a][b]=1;
			adj[a][b]=1;
			
			wt[a][b]=w;
			wt[b][a]=w;
		}
		for(int i=1;i<=V;i++){
			dist[i]=Integer.MAX_VALUE;
		}
		dist[s]=0;
		QueueY Q=new QueueY(V);
		Q.add(s);
		
		while(!Q.isEmpty()){
			int v=Q.peek();
			Q.remove();
			
			for(int i=1;i<=V;i++){
				if(adj[v][i]==1){
					int x=dist[v]+wt[v][i];
					if(dist[i]>x){
						dist[i]=x;
						path[i]=v;
						if(!Q.check(i)){
							Q.add(i);
						}
					}
				}
				
			}
		}
		System.out.println("Distance of "+s+" from "+d+" is: "+dist[d]);
		sc.close();
	}
}
class QueueY{
	int arr[];
	int front,rear,size;
	
	QueueY(int x){
		rear=-1;
		front=-1;
		size=x;
		arr=new int[size];
	}
	boolean check(int v){
		for(int i=front;i<=rear;i++){
			if(arr[i]==v)return true;
		}
		return false;
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