import java.lang.*;
import java.util.*;

/*
 * long startTime = System.currentTimeMillis();
.....your program....
long endTime   = System.currentTimeMillis();
long totalTime = endTime - startTime;
System.out.println(totalTime);
 */

public class BitOperations {
	
	public static void main(String[] args) {
		long a1=System.nanoTime();
		
		//System.out.println(Integer.toBinaryString(65));
		//System.out.println(CountOnesinBinary(111));
		//System.out.println(Integer.bitCount(-111));
		
		//System.out.println(BinaryOfNumberIsPalindrome(165));
		//BinaryIsPalindromeOrNot(65);
		
		//System.out.println(Integer.toBinaryString(4));
		//System.out.println(Integer.toBinaryString(SwapTwoNibblesInByte((byte)4)));
		
		//if(isDivisible(88))System.out.println("It is divisible by 9");
		//else System.out.println("Not divisible Kakarot");
		
		//System.out.println(OnlySetBitPosition(128));
		
		//System.out.println(Integer.toBinaryString(13));
		//System.out.println(SwapOddEvenPlaces(13));
		
		System.out.println(AddTwoBitStrings("101011110","101011100"));
		
		long a2=System.nanoTime();
		System.out.println("Time taken in ms: "+(float)(a2-a1)/1000000);
	}
	
	public static int CountOnesinBinary(int n){
		if(n==0)return 0;
		else{
			int count=0;
			while(n!=0){
				int temp=n & 1;
				if(temp==1)count++;
				n=n>>1;
				// when it is a -ve number it supplies 1 on every right shift
				// so use >>> that will change the sign bit of -ve number
				// and make it +ve and then get rid of the bits...
				//therefore for signed bits use >>> & not >>
			}
			return count;
		}
	}
	// this is only for +ve numbers		Microsoft Q.==IITBHU
	public static int BinaryOfNumberIsPalindrome(int n){
		int sum=0,count=0,sol=0;
		boolean a=false;
		// we are not to use any sort of data structure not even any array
		while(n!=0){
			int temp=n&1;
			if(temp==1){
				sum+=Math.pow(2,count);
				sol++;
			}
			n=n>>1;
			if(n==sum){
				a=true;
			}
			count++;
		}
		if(a)return sol;
		else return -1;		
	}
	
	public static void BinaryIsPalindromeOrNot(int n){
		/*int a=n;
		int b=0;
		while(a!=0){
			b=b<<1;
			b|=a&1;
			a>>>=1;
		}
		if(b==n)System.out.println("It is a Palindrome");
		else System.out.println("It is NOT a Palindrome");*/
		
		String str=Integer.toBinaryString(n);
		int i=0,j=str.length()-1;
		for(;i<str.length();){
			if(str.charAt(i)==str.charAt(j) && i<=j){
				i++;j--;
				continue;
				}
			else break;
		}
		if(i==j || j<i)System.out.println("It is a Palindrome");
		else System.out.println("It is NOT a Palindrome");
	}
	// to exchange the last 4 bits with first 4 bits
	// n&0x0F<<4 moves this to first 4 position.
	public static byte SwapTwoNibblesInByte(byte n){
		return (byte)(((n&0x0F)<<4)|((n&0xF0)>>4));
	}
	// We have to make the kth bit 0. we do this by making all bits 1 & kth bit 0
	// then we do bitwise with the original number
	public static int TurnOffKthBit(int n,int k){
		if(k<=0)return n;
		else return n&(~(1<<(k-1)));
	}
	
	public static int TurnOnKthBit(int n,int k){
		if(k<=0)return n;
		else return n&(1<<(k-1));
	}
	// Divisibility by 9: sum of all digits divisible by 9
	// n/9=n/8-n/72
	public static boolean isDivisible(int n){
		if(n==0)return true;
		else if(n<9)return false;
		else{
			return isDivisible((int)(n>>3)-(int)(n&7));
		}
	}
	
	public static int OnlySetBitPosition(int n){
		if(n<0)return -1;
		int a=n&(n-1);
		if(a!=0)return -1;
		
		int pos=-1,count=0;
		while(n!=0){
			if((n&1)==1){pos=count;break;}
			n=n>>1;
			count++;
		}
		return pos+1;
	}
	// swap even places with odd places & vice-versa
	// we do bitwise ANDing with all 32 bits...
	public static int SwapOddEvenPlaces(int n){
		int even=n&0xAAAAAAAA;
		int odd=n&0x55555555;
		even>>=1;
		odd<<=1;
		return even|odd;
	}
	// add two bitstrings
	public static String AddTwoBitStrings(String aa,String bb){
		// making both the strings of equal size
		StringBuilder a=new StringBuilder(aa);
		StringBuilder b=new StringBuilder(bb);
		if(a.length()!=b.length()){
			int a_l=a.length();
			int b_l=b.length();
			if(a_l>b_l){
				for(int i=0;i<a_l-b_l;i++)
				b.insert(0, "0");
			}
			else{
				for(int i=0;i<b_l-a_l;i++)
				a.insert(0, "0");
				
			}
		}
		
		StringBuilder res=new StringBuilder();
		int c=0;
		for(int i=a.length()-1;i>=0;i--){
			int a1=a.charAt(i)-'0';
			int b1=b.charAt(i)-'0';
			res.insert(0,Integer.toString(a1^b1^c));
			// or can use String res;
			// res="0"+res; both approx. same because it uses
			// StringBuilder behind the scenes.
			c=(a1&b1)|(b1&c)|(a1&c);
		}
		if(c!=0)res=res.insert(0, "1");
		return res.toString();
	}
	
}
