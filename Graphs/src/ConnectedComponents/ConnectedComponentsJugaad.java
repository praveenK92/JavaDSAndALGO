package ConnectedComponents;

import java.util.Scanner;

public class ConnectedComponentsJugaad {
	static int Sets[];
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
		int count=1;
		Sets=new int[V+1];
		for(Edge x:edge){
			if(Sets[x.src]==0 && Sets[x.dest]==0){
				Sets[x.dest]=count;
				Sets[x.src]=count;
				System.out.println("hey "+x.src+" "+x.dest+" count= "+count);
				count++;
			}
			else if(Sets[x.src]==0 && Sets[x.dest]!=0){
				Sets[x.src]=Sets[x.dest];
			}
			else if(Sets[x.src]!=0 && Sets[x.dest]==0){
				Sets[x.dest]=Sets[x.src];
			}
			else{
				int a=Sets[x.src],b=Sets[x.dest],c=-1;
				c=a<b?a:b;
				for(int i=1;i<=V;i++){
					if(Sets[i]==a || Sets[i]==b)Sets[i]=c;
				}
			}
		}
		
		for(int i=1;i<=V;i++)System.out.println(i+" :"+Sets[i]);
		int ans=0;
		for(int i=1;i<count;i++){
			for(int j=1;j<=V;j++)
			if(Sets[j]==i){
				ans++;
				System.out.println(i+" j value: "+j+" "+" Ans= "+ans);
				break;
			}
		}
		for(int i=1;i<=V;i++)if(Sets[i]==0)ans++;
		
		/*int count=0,arr[];
		arr=new int[V];
		for(int i=1;i<=V;i++){
			if(Sets[i]==0)count++;
			else{
				
			}
		}*/
		System.out.println("The total no of Connected Components is: "+ans);
	
	}
}/*
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
	
}*/
