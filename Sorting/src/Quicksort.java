import java.util.Scanner;

public class Quicksort {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of array");
		int n=sc.nextInt();
		System.out.println("Enter array elements");
		long arr[]=new long[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextLong();
			}
		quicksort(arr,0,arr.length-1);
		for(int i=0;i<n;i++){
			System.out.println(arr[i]);
			}
	}
	public static void quicksort(long[] A,int p1,int r1){
		int q;
		if(p1<r1){
			q=Partition(A,p1,r1);
			quicksort(A,p1,q-1);
			quicksort(A,q+1,r1);
		}
	}
	public static int Partition(long[] A,int p,int r){
		/*long x=A[r];
		int i=p-1;
		for(int j=p;j<r;j++){
			if(A[j]<=x){
				long y=A[i];
				A[i]=A[j];
				A[j]=y;
				i++;
			}
		}
		long y=A[i];
		A[i]=A[r];
		A[r]=y;
		return i;*/
		int pv=(p+r)/2;
		int i=p;
		long x=A[pv];
		swap(A,p,pv);
		p++;
		while(p<=r){
			if(A[p]>x){
				if(A[r]<x){
					swap(A,p,r);
					p++;
					r--;	
				}
				else r--;				
			}
			else p++;
		}
		swap(A,i,p-1);
		return p-1;
	}
	public static void swap(long[] A,int a,int b){
		long c=A[a];
		A[a]=A[b];
		A[b]=c;
	}
}