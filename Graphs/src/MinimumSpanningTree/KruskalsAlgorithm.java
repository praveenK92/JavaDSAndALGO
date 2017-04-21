package MinimumSpanningTree;
import java.util.Scanner;


//for undirected graph
public class KruskalsAlgorithm {
	//static int wt[][];
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
			int c=sc.nextInt();

			edge[i]=new Edge(a,b,c);
			//System.out.println(edge[i].src+" "+edge[i].dest);
		}

		LinkedList Set[]=new LinkedList[V];
		for(int i=0;i<V;i++){
			Set[i]=new LinkedList(i+1,null);
		}
		for(int i=0;i<M;i++){
			boolean swap=false;
			for(int j=0;j<M-i-1;j++){
				if(edge[j].wt>edge[j+1].wt){
					Edge a=new Edge(edge[j]);
					edge[j]=edge[j+1];
					edge[j+1]=a;
					swap=true;
				}
			}
			if(!swap)break;
		}
		//for(int i=0;i<M;i++)System.out.println(edge[i].wt);

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
			if(s==d){
				continue;
			}
			else{
				x.tk=true;
				System.out.println(x.src+" "+x.dest+" "+x.wt);
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
		int ans=0;
		for(int i=0;i<M;i++){
			if(edge[i].tk){
				ans+=edge[i].wt;
			}
		}
		/*for(int i=0;i<V;i++){
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
		}*/
		System.out.println("The min wt of MST is: "+ans);

	}
}
class Edge{
	int src;
	int dest;
	int wt;
	boolean tk=false;

	Edge(){
		src=-1;dest=-1;wt=-1;
	}
	Edge(int i,int j,int w){
		src=i;
		dest=j;
		wt=w;
	}
	Edge(Edge i){
		src=i.src;
		dest=i.dest;
		wt=i.wt;
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

/*Input book

9 13
1 2 4
1 8 8
2 3 8
8 9 7
3 9 2
9 7 6
8 7 1
3 4 7
3 6 4
7 6 2
4 6 14
4 5 9
5 6 10

ans=37
*/