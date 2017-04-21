package ConnectedComponents;
import java.util.Scanner;
// for undirected graph
public class ConnectedGraphs {
	static int adj[][];
	static int V,M;
	static Edge edge[];
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		V=sc.nextInt();
		M=sc.nextInt();
		
		edge=new Edge[M];
		for(int i=0;i<M;i++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			edge[i]=new Edge(a,b);
			//System.out.println(edge[i].src+" "+edge[i].dest);
		}
		sc.close();
		LinkedList Set[]=new LinkedList[V];
		for(int i=0;i<V;i++){
			Set[i]=new LinkedList(i+1,null);
		}
		// FINDing in Set
		for(Edge x:edge){
			int s=-1,d=-1;
			for(int i=0;i<V;i++){
				LinkedList a;
				a=Set[i];
				while(a!=null){
					if(a.data==x.src){
						s=i;
						//System.out.println(s+" ");
						}
					else if(a.data==x.dest){
						d=i;
						//System.out.println(d+" ");
					}
					a=a.next;
				}
			}
			// UNION of SETs
			if(s==d)continue;
			else{
				LinkedList a=Set[s],b;
				b=a;
				while(a!=null){
					b=a;
					a=a.next;
				}
				b.setNext(Set[d]);
				Set[d]=null;
			}
		}
		int count=0;
		for(int i=0;i<V;i++){
			if(Set[i]==null)continue;
			else{
				count++;
				LinkedList a=Set[i];
				while(a!=null){
					System.out.print(a.data+" ");
					a=a.next;
				}
				System.out.println("");
			}
		}
		System.out.println("The total no of Connected Components is: "+count);
	
	}
}
class Edge{
	int src;
	int dest;
	
	Edge(){
		src=-1;dest=-1;
	}
	Edge(int i,int j){
		src=i;
		dest=j;
	}
	
}
class LinkedList{
	LinkedList next;
	int data;
	
	LinkedList(){
		next=null;
		data=-1;
	}
	LinkedList(int i,LinkedList n){
		next=n;
		data=i;
	}
	void setData(int i){
		data=i;
	}
	int getData(){
		return data;
	}
	void setNext(LinkedList i){
		next=i;
	}
	LinkedList getNext(){
		return next;
	}
}
/*Example 1
10
7
1 2 1 3 2 3 2 4
5 6 5 7
8 9

Ans
1 2 3 4 
5 6 7 
8 9 
10 
The total no of Connected Components is: 4
*/
/*Example 2
11 11
4 9 6 11 7 9 2 7 1 8
9 10 4 11 2 10 4 6 7 10 1 5

Ans
1 8 5 
2 7 4 9 10 6 11 
3 
The total no of Connected Components is: 3
*/