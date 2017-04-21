package ShortestDistance;
/*
5 5 1 5
1 2 3
1 4 11
2 3 5
3 4 2
4 5 1
 */
import java.util.Scanner;
// 
public class DijisktraAlgoShortestDistanceWeighted {
	static int wt[][];
	static int dist[],path[];
	static int V,M,s,d;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		V=sc.nextInt();
		M=sc.nextInt();
		s=sc.nextInt();
		d=sc.nextInt();
		
		wt=new int[V+1][V+1];
		dist=new int[V+1];
		path=new int[V+1];
		
		for(int i=0;i<M;i++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			int w=sc.nextInt();
			wt[a][b]=w;
			wt[b][a]=w;
		}
		for(int i=1;i<=V;i++){
			dist[i]=-1;
		}
		dist[s]=0;
		QueueX Q=new QueueX(V);
		Q.add(s);
		
		while(!Q.isEmpty()){
			int v=Q.peek();
			Q.remove();
			
			for(int i=1;i<=V;i++){
				if(wt[v][i]!=0 && dist[i]==-1){
					dist[i]=dist[v]+wt[v][i];
					Q.add(i);
					path[i]=v;
				}
				else if(wt[v][i]!=0){
					int a=dist[v]+wt[v][i];
					if(dist[i]>a){
						dist[i]=a;
						Q.add(i);
						path[i]=v;
					}
					//dist[i]=(dist[i]<a)?dist[i]:a;
				}
				
			}
		}
		System.out.println("Distance of "+s+" from "+d+" is: "+dist[d]);
		
		sc.close();
	}
}
class QueueX{
	int arr[];
	int front,rear,size;
	
	QueueX(int x){
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