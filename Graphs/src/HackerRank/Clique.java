package HackerRank;
import java.util.*;
// could not do
public class Clique {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=1;t<=T;t++){
			int n=sc.nextInt();
			int e=sc.nextInt();
			float a=(float)(n*n)/(n*n-2*e);
			int ans=0;
			if(a-Math.abs(a)<0.5)
				ans=(int)Math.abs(a);
			else
				ans=(int)Math.abs(a)+1;
			System.out.println(ans);
		}
	}

}
