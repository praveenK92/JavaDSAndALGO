public class ProblemsOnArrays {
	
	public static void main(String[] args) {
		long a1=System.nanoTime();
		
		/*int a[]={10, 22, 28, 29, 30, 40};
		int x[]=PairSumClosesttoX(a,54);
		System.out.println(""+a[x[0]]+" "+a[x[1]]);*/
		
		/*int arr1[]={1, 4, 5, 7};
		int arr2[]={10, 20, 30, 40};
		int y[]=ClosestPairFromTwoSortedArrays(arr1,arr2,32);
		System.out.println(""+arr1[y[0]]+" "+arr2[y[1]]);*/
		
		
		
		long a2=System.nanoTime();
		System.out.println("\nTime taken in ms: "+(float)(a2-a1)/1000000);
	}
	
	/*We are given two arrays ar1[0...m-1] and ar2[0..n-1] and a number x
	we need to find the pair ar1[i] + ar2[j]
	such that absolute value of (ar1[i] + ar2[j] – x) is minimum. */
	public static int[] ClosestPairFromTwoSortedArrays(int a[],int b[],int x){
		int res[]=new int[2];
		int l=0,r=b.length-1;
		
		int diff=Integer.MAX_VALUE;
		res[0]=l;
		res[1]=r;
		while(l<a.length && r>=0){
			 int temp=Math.abs(a[l]+b[r]-x);
			 if(diff>temp){
				 diff=temp;
				 res[0]=l;
				 res[1]=r;
			 }
			 
			 if(a[l]+b[r]>x)r--;
			 else l++;
		}
		return res;
	}
	
	//Sorted array find pair whose sum is closest to x
	public static int[] PairSumClosesttoX(int arr[],int x){
		int r=arr.length-1,l=0;
		int res[]=new int[2];
		
		if(r+1<2){
			res[0]=res[1]=-1;
			return res;
		}
		int diff=Integer.MAX_VALUE;
		res[0]=arr[l];
		res[1]=arr[r];
		while(l<r){
			int temp=Math.abs(arr[l]+arr[r]-x);
			if(diff>temp)
			{
				diff=temp;
				res[0]=l;
				res[1]=r;
			}
			
			if(arr[l]+arr[r]>x)r--;
			else l++;
		}
		return res;
	}
	
	public static void TwoDArraySortedTraverse(int arr[][]){
		int n=arr.length;
		
	}
}
