package GeeksforGeeks;
import java.util.Scanner;

/*
9
10 22 9 33 21 50 41 60 80
Soln
1 2 1 3 2 4 4 5 6 
The Max LIS for arr is: 6


*/
public class LongestIncreasingSubsequence {
	static int arr[],LIS[];
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		arr=new int[N];
		LIS=new int[N];
		
		for(int i=0;i<N;i++){
			arr[i]=sc.nextInt();
			LIS[i]=1;
		}
		sc.close();
		for(int i=1;i<N;i++){
			for(int j=0;j<i;j++){
				if(arr[j]<arr[i] && LIS[i]<LIS[j]+1){
					LIS[i]=LIS[j]+1;
				}
			}
		}
		int ans=-1;
		for(int i=0;i<N;i++){
			System.out.print(LIS[i]+" ");
			ans=ans>LIS[i]?ans:LIS[i];
		}
		System.out.print("\nThe Max LIS for arr is: "+ans);
	}

}
