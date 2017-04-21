public class BitOperationsTwo {
	
	public static void main(String[] args) {
		long a1=System.nanoTime();
		
		//System.out.println(strcmp("pikacHu","Pikack"));
		
		//System.out.println(ToBinary(9));
		
		//int arr[]= {12, 1, 12, 3, 12, 1, 1, 2, 3, 3};
		//System.out.println(ElementAppearOnce(arr));
		
		//System.out.println(CountTotalSetBitsLAME(13));
		//System.out.println(CountTotalSetBits(13));
		
		System.out.println(AddTwoNumbers(15,23));
				
		long a2=System.nanoTime();
		System.out.println("\nTime taken in ms: "+(float)(a2-a1)/1000000);
	}
	
	public static int strcmp(String a,String b){
		int len=Math.min(a.length(),b.length());
		for(int i=0;i<len;i++)
		{
			int t=a.charAt(i)-b.charAt(i);
			if(t>0 && t!=32)return 1;
			else if(t<0 && t!=-32)return -1;
		}
		return 0;
	}
	// Sumilar to Integer.toBinaryString(int n);
	public static String ToBinary(int n){
		String res=new String();
		while(n!=0){
			res=Integer.toString(n&1)+res;
			n>>=1;
		}
		return res;
	}
	
	// Time:O(n)   Space:O(1)
	// every element appears 3 times except one.
	public static int ElementAppearOnce(int arr[]){
		int ones = 0, twos = 0 ;
	    int common_bit_mask;
	    // Let us take the example of {3, 3, 2, 3} to understand this
	    for(int i=0;i<arr.length; i++ )
	    {
	        /* The expression "one & arr[i]" gives the bits that are
	           there in both 'ones' and new element from arr[].  We
	           add these bits to 'twos' using bitwise OR
	 
	           Value of 'twos' will be set as 0, 3, 3 and 1 after 1st,
	           2nd, 3rd and 4th iterations respectively */
	        twos  = twos | (ones & arr[i]);
	 
	 
	        /* XOR the new bits with previous 'ones' to get all bits
	           appearing odd number of times
	 
	           Value of 'ones' will be set as 3, 0, 2 and 3 after 1st,
	           2nd, 3rd and 4th iterations respectively */
	        ones  = ones ^ arr[i];
	 
	 
	        /* The common bits are those bits which appear third time
	           So these bits should not be there in both 'ones' and 'twos'.
	           common_bit_mask contains all these bits as 0, so that the bits can
	           be removed from 'ones' and 'twos'  
	 
	           Value of 'common_bit_mask' will be set as 00, 00, 01 and 10
	           after 1st, 2nd, 3rd and 4th iterations respectively */
	        common_bit_mask = ~(ones & twos);
	 
	 
	        /* Remove common bits (the bits that appear third time) from 'ones'
	             
	           Value of 'ones' will be set as 3, 0, 0 and 2 after 1st,
	           2nd, 3rd and 4th iterations respectively */
	        ones &= common_bit_mask;
	 
	 
	        /* Remove common bits (the bits that appear third time) from 'twos'
	 
	           Value of 'twos' will be set as 0, 3, 1 and 0 after 1st,
	           2nd, 3rd and 4th itearations respectively */
	        twos &= common_bit_mask;
	        System.out.println(i+": "+"Ones:"+Integer.toBinaryString(ones));
	        System.out.println(i+": "+"Twos:"+Integer.toBinaryString(twos));
	    }
		return ones;
	}
	
	public static boolean OppositeSigns(int x,int y){
		//return (x^y)>>31==1;
		return (x^y)<0;
	}
	
	//count total no of set bits from 1 to n
	public static int CountTotalSetBitsLAME(int n){
		int res=0;
		for(int i=1;i<=n;i++){
			int j=i;
			while(j!=0){
				if((j&1)==1)res++;
				j>>=1;
			}
		}
		return res;
	}
	//count total no of set bits from 1 to n
	public static int CountTotalSetBits(int n){
		if(n==0)return 0;
		int temp=n,m=0;
		while(temp>1){
			m++;
			temp>>=1;
		}
		temp=1<<m;
		while(n<temp){
			temp>>=1;
			m--;
		}
		
		if(n==(1<<m)-1)return (m+1)*(1<<m);
		
		n=n-(1<<m);
		return (n+1)+CountTotalSetBits(n)+m*(1<<(m-1));
		// 17=10001	m*1<<(m-1) is for 1111 these terms
		// 10000 for dat its 1+: n+1
		// for nos b/w 10000 to 10001 we call recursively again.
	}
	
	public static int SwapBits(int x,int p1,int p2,int n){
		int xor=((x<<p1) ^ (x<<p2)) & (1<<n-1);
		return ((xor<<p1) | (xor<<p2)) ^ x;
	}
	// No idea how this works....
	public static int AddTwoNumbers(int x,int y){
		while(y!=0){
			int carry=x&y;
			x=x^y;
			System.out.println(x+" "+carry+" "+y);
			y=carry<<1;
		}
		return x;
	}
}
