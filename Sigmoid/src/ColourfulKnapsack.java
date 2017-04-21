import java.util.Scanner;

public class ColourfulKnapsack {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		int sol[]=new int[T];
		
		for(int i=0;i<T;i++){
			int N=sc.nextInt();
			int m=sc.nextInt();
			int X=sc.nextInt();
			
			int w[]=new int[N];
			int c[]=new int[N];
			for(int j=0;j<N;j++){
				w[i]=sc.nextInt();
			}
			for(int j=0;j<N;j++){
				c[i]=sc.nextInt();
			}
			
			sol[i]=work(w,c,m,X);
			
		}
		sc.close();
	}
	
	public static int work(int w[],int c[],int m,int X){
		int arr[]=new int[m];
		for(int i=0;i<w.length;i++){
			int t=c[i]-1;
			arr[t]=arr[t]<w[i]?arr[t]:w[i];
		}
		for(int i:arr)X=X-i;
		for(int i=0;i<w.length;i++){
			w[i]-=arr[c[i]-1];
		}
		
		
		return 1;
	}

}
