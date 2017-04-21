import java.util.Scanner;

public class Bubble{
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of array");
		int n=sc.nextInt();
		System.out.println("Enter array elements");
		long arr[]=new long[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextLong();
		}
		int sw=0;
		for(int i=0;i<n;i++){
			boolean swap=false;
			
			for(int j=0;j<n-i-1;j++){
				if(arr[j]>arr[j+1]){
					long t=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=t;
					swap=true;
					sw++;
				}
			}
			for(long z:arr)System.out.print(" "+z);
			System.out.println(swap);
			
			if(swap)continue;
			else break;
		}
		for(long i:arr)System.out.print(" "+i);
		//System.out.println(" swaps "+sw);
		
		
	}

}
