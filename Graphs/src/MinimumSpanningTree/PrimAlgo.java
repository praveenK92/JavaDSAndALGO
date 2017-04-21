package MinimumSpanningTree;

import java.util.Scanner;
// couldnt do
public class PrimAlgo {
	static int Sets[][],adj[][],wt[][];
	static int V,M;
	//static Edge edge[];

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		V=sc.nextInt();
		M=sc.nextInt();
		adj=new int[V+1][V+1];
		wt=new int[V+1][V+1];;
		
		
		for(int i=0;i<M;i++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			
			adj[a][b]=1;
			wt[a][b]=c;
		}
		int count=1;
		Sets=new int[V+1][2];
		for(int i=1;i<=V;i++){
			Sets[i][0]=i;
			Sets[i][1]=Integer.MAX_VALUE;
		}
		Sets[1][1]=0;
		int s=1;
		for(int i=1;i<=V;i++){
			if(Sets[i][0]==s)continue;
			for(int j=1;j<=V;j++){
				
			}
		}
		

		for(int i=1;i<=V;i++)System.out.println(i+" :"+Sets[i]);
		int ans=0;
		
		System.out.println("MST Min Weight= "+ans);
	}
	
}
