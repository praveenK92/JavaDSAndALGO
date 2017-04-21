public class ArrayLeftSumEqualsRightSum {
	
	public static void main(String[] args) {
		int a[]={12,13,2,18,1,6};
		System.out.println(ArrayLeftSumEqualRightSum(a));
	}
	
	//Microsoft IIT Delhi Q.
	public static int ArrayLeftSumEqualRightSum(int arr[]){
		if(arr.length==0)return -1;
		else if(arr.length==1)return 0;
		else if(arr.length==2)return -1;
		
		int leftsum=arr[0],rightsum=0;
		for(int i=2;i<arr.length;i++)rightsum+=arr[i];
		if(leftsum==rightsum)return 1;
		
		for(int i=2;i<arr.length;i++){
			leftsum+=arr[i-1];
			rightsum-=arr[i];
			System.out.println("i="+(i-1)+"\tleftsum="+leftsum+"\trightsum= "+rightsum);
			if(leftsum==rightsum){return i;}
		}
		return -1;
	}

}
