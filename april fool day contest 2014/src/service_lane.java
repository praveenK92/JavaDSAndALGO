import java.util.Scanner;
public class service_lane {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N=sc.nextInt();
		int T=sc.nextInt();
		int width[]=new int[N];
		for(int k=0;k<N;k++)
		{
			width[k]=sc.nextInt();
		}
		int test[][]=new int[T][2];
		/*int ans[]=new int[T];*/
		for(int k=0;k<T;k++)
		{
			test[k][0]=sc.nextInt();
			test[k][1]=sc.nextInt();
		}
		for(int k=0;k<T;k++)
		{
			int i=test[k][0];
			int j=test[k][1];
			int min=width[i];
			while(i<=j)
			{
				if(min>width[i])
					min=width[i];
				i++;
			}
			System.out.println(min);
		}
	}

}
