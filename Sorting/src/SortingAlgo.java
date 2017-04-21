public class SortingAlgo {
	int arr[];
	
	public int[] BubbleSort(int[] arr){
		if(arr.length==0 || arr.length==1)return arr;
		for(int i=0;i<arr.length;i++){
			boolean swap=false;
			for(int j=0;j<arr.length-i-1;j++)
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					swap=true;
				}
			if(!swap)break;
			}
		return arr;
	}
	
	public int[] SelectionSort(int[] arr){
		if(arr.length==0 || arr.length==1)return arr;
		for(int i=0;i<arr.length;i++){
			int min=i;
			for(int j=i;j<arr.length;j++)
				if(arr[j]<arr[min])min=j;
			int temp=arr[min];
			arr[min]=arr[i];
			arr[i]=temp;
		}
		return arr;
	}
	public int[] MergeSort(int[] arr,int l,int r){
		
		int mid=arr.length/2;
		MergeSort(arr,l,mid);
		MergeSort(arr,mid+1,r);
		
		Merge(arr,l,mid,r);
		return arr;
	}
	// Merger Function for MergeSort
	public void Merge(int[] arr,int l,int mid,int r){
		int n1=mid-l+1;
		int n2=r-mid;
		
		int[] L=new int[n1];
		int[] R=new int[n2];
		
		for(int i=0;i<n1;i++)
			L[i]=arr[i+l];
		for(int i=0;i<n2;i++)
			R[i]=arr[i+mid+1];
		
		int i=0,j=0,k=l;
		while(i<n1 && j<n2){
			if(L[i]<R[j]){
				arr[k]=L[i];
				k++;i++;
			}
			else{
				arr[k]=R[j];
				j++;
				k++;
			}
		}
		while(i<n1){
			arr[k]=L[i];
			k++;i++;
		}
		while(j<n2){
			arr[k]=R[j];
			k++;j++;
		}
		
	}
}
