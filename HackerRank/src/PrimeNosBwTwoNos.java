public class PrimeNosBwTwoNos {
	
	public static void main(String[] args) {
		int n=100;
		SieveOfEratosthenes(n);
		//MyMethod(1,n);		
		//primeFactors(n);
	}
	
	public static void MyMethod(int a,int b){
		for(int i=a;i<=b;i++){
			if(i>6){
			if(i%6==1 || i%6==5){
				boolean f=true;
				for(int j=2;j*j<=i;j++){
					if(i%j==0){f=false;break;}
				}
				if(f)System.out.println(i);				
			}
			else continue;
		}
			else switch(i){
				case 2:{System.out.println(i);break;}
				case 3:{System.out.println(i);break;}
				case 5:{System.out.println(i);break;}
				default:continue;
				}
		}
	}
	
	
	/*	To get prime numbers from 2 to n 
	 Complexity:	O(nlog(log(n)))			*/
	public static void SieveOfEratosthenes(int n){
		boolean arr[]=new boolean[n+1];
		//for(boolean i:arr)System.out.println(i);
		for(int i=2;i*i<=n;i++){
			if(!arr[i]){
				for(int j=2;i*j<=n;j++){
					arr[i*j]=true;
				}
			}
		}
		int c=0;
		for(int i=2;i<=n;i++){
			if(arr[i]!=true){c++;System.out.printf(i+" ");}
			else continue;
		}
		System.out.println("No. of primes="+c);
	}
	
	
	// this method is very very efficient
	public static void primeFactors(int n)
	{
	    // Print the number of 2s that divide n
	    while (n%2 == 0)
	    {
	        System.out.printf("%d ", 2);
	        n = n/2;
	    }
	 
	    // n must be odd at this point.  So we can skip one element (Note i = i +2)
	    for (int i = 3; i <= Math.sqrt(n); i = i+2)
	    {
	        // While i divides n, print i and divide n
	        while (n%i == 0)
	        {
	        	System.out.printf("%d ", i);
	            n = n/i;
	        }
	    }
	 
	    // This condition is to handle the case whien n is a prime number
	    // greater than 2
	    if (n > 2)
	    	System.out.printf ("%d ", n);
	}

}
