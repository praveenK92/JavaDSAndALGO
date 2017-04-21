package GeeksforGeeks;


import java.util.Scanner;

public class BinomialCoefficient {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		
		sc.close();
		
		int sol[][]=new int[n+1][k+1];
		for(int i=1;i<=n;i++)
			sol[i][0]=1;
		for(int i=1;i<=k;i++)
			sol[i][i]=1;
		
		for(int i=1;i<=n;i++){
			for(int j=1;j<i && j<=k;j++){
				sol[i][j]=sol[i-1][j-1]+sol[i-1][j];
			}
		}
		
		
		// space efficient way
		int c[]=new int[k+1];
		c[0]=1;
		for(int i=1;i<=n;i++){
			for(int j=i<=k?i:k;j>0;j--){
				c[j]+=c[j-1];
			}
		}
		System.out.println("Binomial Coefficient for n= "+n+" & k= "+k+
				" is: "+sol[n][k]+"  other soln is: "+c[k]);
		
	}

}
