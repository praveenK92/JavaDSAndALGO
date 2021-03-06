package ConnectedComponents;
import java.util.Scanner;

public class StronglyConnectedComponentsKosarajuAlgo {
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
		
		for(int i=1;i<=V;i++){
			//System.out.println("Vertex: "+i+" Set: "+StronglyConnected[i]);
		}
		
		
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
class Stack{
	int arr[];
	int top,size;
	
	Stack(int v){
		size=v;
		top=-1;
		arr=new int[size];
	}
	void pop(){
		top--;
	}
	int peek(){
		return arr[top];
	}
	void push(int v){
		arr[++top]=v;
	}
	boolean isEmpty(){
		return top==-1;
	}
	boolean isFull(){
		return top==size;
	}
}
/*
5 5
1 5 5 2 2 1 5 3 3 4
Vertex: 1 Set: 1
Vertex: 2 Set: 1
Vertex: 5 Set: 1
Vertex: 3 Set: 2
Vertex: 4 Set: 3
*/

/*
8 14
1 2 2 3 3 4 4 3
5 1 2 5 2 6 3 7  4 8
5 6 6 7 7 6 7 8 8 8
Vertex: 1 Set: 1
Vertex: 5 Set: 1
Vertex: 2 Set: 1
Vertex: 3 Set: 2
Vertex: 4 Set: 2
Vertex: 7 Set: 3
Vertex: 6 Set: 3
Vertex: 8 Set: 4
*/
