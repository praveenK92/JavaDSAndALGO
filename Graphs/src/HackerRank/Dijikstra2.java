package HackerRank;
/*
Q. could not do
dunno what problem it is...

1
5 6
1 2 7
1 5 3
2 3 1
5 3 2
5 4 8
3 4 6
1

Soln:
6 5 11 3

1
11 15
1 2 5
1 3 1
2 3 1
2 4 1
3 4 2
3 5 1
3 7 8
4 6 1
5 8 4
7 8 6
6 9 1
9 10 1
8 10 13
8 11 1
10 11 1
1
Soln
2 1 3 2 4 9 6 5 6 7
*/
import java.util.Scanner;
public class Dijikstra2 {
	static int V,M,s;
	static int dist[],wt[][];
	static Queue Q;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=1;t<=T;t++){
			V=sc.nextInt();
			M=sc.nextInt();
			
			Q=new Queue(V);
			//adj=new boolean[V+1][V+1];
			wt=new int[V+1][V+1];
			dist=new int[V+1];
			
			for(int i=0;i<M;i++){
				int a=sc.nextInt();
				int b=sc.nextInt();
				int c=sc.nextInt();
				if(wt[a][b]!=0 && wt[a][b]>c){
					wt[a][b]=c;
					wt[b][a]=c;
				}
				else{
				wt[a][b]=c;
				wt[b][a]=c;
				}
			}
			s=sc.nextInt();
			
			for(int i=1;i<=V;i++)dist[i]=-1;
			
			dist[s]=0;
			Q.add(s);
			
			while(!Q.isEmpty()){
				int v=Q.remove();
				for(int i=1;i<=V;i++){
					if(wt[v][i]==0)continue;
					else{
						int tt=dist[v]+wt[v][i];
						if(dist[i]==-1){
							dist[i]=tt;
							Q.add(i);
						}
						else if(dist[i]>tt){
							dist[i]=tt;
							if(!Q.check(i))
								Q.add(i);
						}
					}
				}
			}
			
			
			if(s!=V){
			for(int i=1;i<V;i++)if(i!=s)System.out.print(dist[i]+" ");
			System.out.println(dist[V]);
			}
			else{
				for(int i=1;i<V-1;i++)if(i!=s)System.out.print(dist[i]+" ");
				System.out.println(dist[V-1]);
			}
			
			
		}
		sc.close();
	}

}
class Queue{
	int f,r,s;
	int arr[];
	
	Queue(int s1){
		f=-1;r=-1;s=s1;
		arr=new int[s];
	}
	boolean isEmpty(){
		return f==-1;
	}
	void add(int x){
		r=(r+1)%s;
		arr[r]=x;
		if(f==-1)f=0;
	}
	int remove(){
		if(f!=-1){
			int t=arr[f];
			if(f==r){
				f=-1;r=-1;
			}
			else f=(f+1)%s;
				return t;
		}
		else return -1;
	}
	boolean check(int x){
		for(int i=f;i<=r;){
			if(arr[i]==x)return true;
			i=(i+1)%s;
		}
		return false;
	}
}