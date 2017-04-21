import java.lang.*;
import java.util.Scanner;
public class curious_array {
	public static int Combination(int x,int y){
		int y1=1,x1=1;
		for(int i=1;i<=y;i++){
			y1*=i;
		}
		for(int i=x-y+1;i<=x;i++){
			x1*=i;
		}
		return x1/y1;
	}
	
	public static void main(String[] args) {
		/*System.out.println("Enter the n & m(queries).");*/
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
		}
		int l[]=new int[m];
		int r[]=new int[m];
		int k[]=new int[m];
		for(int i=0;i<m;i++){
			l[i]=sc.nextInt();
			r[i]=sc.nextInt();
			k[i]=sc.nextInt();
		}
		for(int i=0;i<m;i++){
			for(int j=l[i]-1;j<r[i];j++){
			int x=Combination(j+1-l[i]+k[i],k[i]);
			a[j]+=x;
			}
		}
		for(int i=0;i<n;i++){
			System.out.printf(a[i]+" ");
		}
	}

}
