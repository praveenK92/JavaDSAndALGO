import java.util.Scanner;
import java.lang.*;

public class Mergesort {
		public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the size of array");
			int n=sc.nextInt();
			System.out.println("Enter array elements");
			long arr[]=new long[n];
			for(int i=0;i<n;i++){
				arr[i]=sc.nextLong();
				}
			MergeSort(arr);
			for(int i=0;i<n;i++){
				System.out.println(arr[i]);
				}
		}
		public static void MergeSort(long[] list){
			if(list.length>1){
				long left[]=Leftsort(list);
				long right[]=Rightsort(list);
				
				MergeSort(left);
				MergeSort(right);
				
				Merge(list,left,right);
			}
		}
		public static long[] Leftsort(long[] l1){
			int s=l1.length/2;
			long left1[]=new long[s];
			for(int i=0;i<s;i++){
				left1[i]=l1[i];
			}
			return left1;
		}
		public static long[] Rightsort(long[] r1){
			int s1=r1.length/2;
			int s2=r1.length;
			long right1[]=new long[s2-s1];
			for(int i=0;i<s2-s1;i++){
				right1[i]=r1[i+s1];
			}
			return right1;
		}
		public static void Merge(long[] result,long[] left,long[] right){
			int i1=0,i2=0,i=0;
			int l=left.length;
			int r=right.length;
			for(i=0;i<l+r;i++){
				if(i2>=r || (i1<l && left[i1]<=right[i2]) ){
					result[i]=left[i1];
					i1++;
				}
				else{
					result[i]=right[i2];
					i2++;
				}
			}
		}
}