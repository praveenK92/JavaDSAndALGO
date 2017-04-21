import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Pangrams {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		int len=s.length();
		int alp[]=new int[26];
		boolean flag=true;
		for(int i=0;i<len;i++){
			if(s.charAt(i)==' ')continue;
			else
			{
			int j=s.charAt(i);
			if(j>='A' && j<='Z')j+=32;
			j-='a';
			alp[j]++;
			}
		}
		for(int i=0;i<26;i++){
			if(alp[i]>=1)continue;
			else{
				flag=false;
				break;
			}
		}
		if(flag)System.out.println("pangram");
		else System.out.println("not pangram");
	}

}
