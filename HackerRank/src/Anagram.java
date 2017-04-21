import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Anagram {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		String str[]=new String[T];
		sc.nextLine();/* This is done because sc.nextInt() reads only till whitespace then
		it stops. So that sc.nextLine() reads a null character after hitting enter.  */
		for(int i=0;i<T;i++){
			str[i]=sc.nextLine();
		}
		
		int sol[]=new int[T];
		for(int i=0;i<T;i++){
			String s=str[i];
			int len=s.length();
			
			if(len%2!=0){
				sol[i]=-1;
				continue;
			}
			else{
				int alp[]=new int[26];
				String s1=s.substring(0,len/2);
				String s2=s.substring(len/2);
				for(int j=0;j<len/2;j++){
					int k=s1.charAt(j)-'a';
					alp[k]++;
					k=s2.charAt(j)-'a';
					alp[k]--;
				}
				for(int j:alp){
					if(j<=0)continue;
					else if(j>0)sol[i]+=j;
				}
			}
		}
		for(int i:sol){
			System.out.println(i);
		}
		
	}

}
