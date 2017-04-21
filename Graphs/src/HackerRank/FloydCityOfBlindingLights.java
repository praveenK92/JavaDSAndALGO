package HackerRank;

import java.util.Scanner;

public class FloydCityOfBlindingLights {
	static int dist[][],wt[][],Q[][];
	static int V,M;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		V=sc.nextInt();
		M=sc.nextInt();
		
		wt=new int[V+1][V+1];
		dist=new int[V+1][V+1];
		
		
		for(int i=0;i<M;i++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			int w=sc.nextInt();
			wt[a][b]=w;
			//wt[b][a]=w;
		}
		int q=sc.nextInt();
		Q=new int[q][2];
		for(int i=0;i<q;i++){
			Q[i][0]=sc.nextInt();
			Q[i][1]=sc.nextInt();
		}
		
		
		for(int i=1;i<=V;i++){
			for(int j=1;j<=V;j++){
				if(wt[i][j]!=0)
					dist[i][j]=wt[i][j];
				else
					dist[i][j]=Integer.MAX_VALUE;
			}
		}
		for(int i=1;i<=V;i++)
			dist[i][i]=0;
		
		for(int k=1;k<=V;k++){
			for(int i=1;i<=V;i++){
				for(int j=1;j<=V;j++){
					
					if(dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE &&
							dist[i][j]>dist[i][k]+dist[k][j]){
						dist[i][j]=dist[i][k]+dist[k][j];
					}
					
				}
			}
		}
		
		for(int i=0;i<q;i++){
			int x=dist[Q[i][0]][Q[i][1]];
			if(x!=Integer.MAX_VALUE)
				System.out.println(x);
			else
				System.out.println(-1);
		}
		sc.close();
	}

}