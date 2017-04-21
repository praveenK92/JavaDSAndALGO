public class EggProblem {
	
	public static void main(String[] args) {
		System.out.println("The No of Trials for Egg Problem: "+EggDrop(2,100));
				
	}
	
	//  n eggs & k floors
	public static int EggDrop(int n,int k){
		int EggFloor[][]=new int[n+1][k+1];
		for(int i=0;i<=n;i++){
			EggFloor[i][1]=1;
			// for one floor only 1 try is required.
		}
		for(int i=1;i<=k;i++){
			EggFloor[1][i]=i;
			// for 1 egg tries=no of floors
		}
		
		for(int i=2;i<=n;i++){
			// i is for no of eggs
			// for i eggs & k floors we need to find all possible no of tries. 
			for(int j=2;j<=k;j++){
				// j is for floors k is the limit
				// we need to fill the matrix
				EggFloor[i][j]=Integer.MAX_VALUE;
				// we dont know so we put it maximum.
				for(int x=1;x<j;x++){
					// now for 
					int temp=1+Math.max(EggFloor[i-1][x-1], EggFloor[i][j-x]);
					// EggFloor[i-1][x-1] if egg cracks when dropped
					// EggFloor[i][j-x] if egg does not crack.
					if(temp<EggFloor[i][j])EggFloor[i][j]=temp;
				}
			}
		}
		
		return EggFloor[n][k];
	}

}
