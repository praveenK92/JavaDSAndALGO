package MinimumSpanningTree;

import java.util.Scanner;

public class KruskalJugaad {
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
			int c=sc.nextInt();

			edge[i]=new Edge(a,b,c);
			//System.out.println(edge[i].src+" "+edge[i].dest);
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
		int count=1;
		Sets=new int[V+1];

		for(Edge x:edge){
			if(Sets[x.src]!=0 && Sets[x.dest]!=0 && Sets[x.src]==Sets[x.dest])continue;
			else if(Sets[x.src]==0 && Sets[x.dest]==0){
				Sets[x.dest]=count;
				Sets[x.src]=count;
				x.tk=true;
				System.out.println("hey "+x.src+" "+x.dest+" count= "+count);
				count++;
			}
			else if(Sets[x.src]==0 && Sets[x.dest]!=0){
				Sets[x.src]=Sets[x.dest];
				x.tk=true;
			}
			else if(Sets[x.src]!=0 && Sets[x.dest]==0){
				Sets[x.dest]=Sets[x.src];
				x.tk=true;
			}
			else{
				int a=Sets[x.src],b=Sets[x.dest],c=-1;
				c=a<b?a:b;
				for(int i=1;i<=V;i++){
					if(Sets[i]==a || Sets[i]==b)Sets[i]=c;
				}
				x.tk=true;
			}
		}

		for(int i=1;i<=V;i++)System.out.println(i+" :"+Sets[i]);
		int ans=0;
		for(Edge x:edge){
			if(x.tk)ans+=x.wt;
		}
		System.out.println("MST Min Weight= "+ans);
	}
}