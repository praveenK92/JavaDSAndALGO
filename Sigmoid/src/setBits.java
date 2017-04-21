import java.util.*;

public class setBits {
	
	public static void main(String args[]){
		long startTime = System.nanoTime();
		
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		int ans[][]=new int[T][16];

		for(int i=0;i<T;i++){
			int opr=sc.nextInt();
			int index[][]=new int[opr][2];
			for(int j=0;j<opr;j++){
				index[j][0]=sc.nextInt();
				index[j][1]=sc.nextInt();
			}
			ans[i]=work(index,opr);
		}
		for(int i=0;i<T;i++){
			for(int j=0;j<16;j++)
			System.out.print(ans[i][j]+" ");
			System.out.print("\n");
		}
		
		sc.close();
		
		long endTime = System.nanoTime();
		System.out.println("Took "+(double)(endTime - startTime)/1000000000 + " ns"); 
	}
	
	public static int[] work(int index[][],int op){
		int arr[]=new int[10000000];
		for(int i=0;i<op;i++){
			for(int j=index[i][0]-1;j<=index[i][1]-1;j++){
				arr[j]^=1;
			}
		}
		int ans[]=new int[16];
		for(int i=0;i<10000000;i=i+4){
			int temp=8*arr[i]+4*arr[i+1]+2*arr[i+2]+arr[i+3];
			ans[temp]++;
		}
		return ans;
	}
}