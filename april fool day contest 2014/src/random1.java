import java.util.Scanner;
/* use public class Solution when submitting on hackerrank. */
public class random1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int a[]=new int[N];
		int b[]=new int[N];
		for(int i=0;i<N;i++){
			a[i]=sc.nextInt();
			b[i]=0;
			if(a[i]%2==1){
				int j=1;
				while(j<= (a[i]+1)/2 ){
				b[i]+=Math.pow(2,j++);
				}
						 }
			else{
				int j=0;
				while(j<=a[i]/2 ){
				b[i]+=Math.pow(2,j++);
				}
			}	
		}
		for(int i=0;i<N;i++)
		{
			System.out.println(b[i]);
		}
	}
}