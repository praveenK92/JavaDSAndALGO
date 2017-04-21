import java.util.Scanner;
public class Heap_sort {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of array");
		int n=sc.nextInt();
		System.out.println("Enter array elements");
		int A[]=new int[n];
		for(int j=0;j<n;j++){
			A[j]=sc.nextInt();
		}
	}
	public static void BuildMaxHeap(int A[]){
		for(int i=A.length/2;i<=1;i--)
			MaxHeapify(A,i);		
	}
	private static int heapsize(int B[]){
		int c=B.length;
		int b=1;
		int co=0;
		if(c==1){
			return 1;
		}
		while(b<c){
			co++;
			b*=2;
		}
		return co;
	}
	private static int Parent(int k){
		return k/2;
	}
	private static int Left(int k){
		return 2*k;
	}
	private static int Right(int k){
		return 2*k+1;
	}
	public static void MaxHeapify(int A[],int i){
		int l=Left(i);
		int r=Right(i);
		int a=heapsize(A);
		int largest;
		if(l<=a && A[l]>A[i])
			largest=l;
		else largest=i;
		if(r<=a && A[r]>A[largest])
			largest =r;
		if(largest!=i){
			int b=A[largest];
			A[largest]=A[i];
			A[i]=b;		
		}
		MaxHeapify(A,largest);
	}
}