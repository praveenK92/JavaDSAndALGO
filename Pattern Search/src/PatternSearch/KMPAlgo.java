package PatternSearch;

import java.util.Scanner;
/*
abc
ababcabcdfaabcdababbabc

Solution:
n= 23 m= 3
Pattern found at: 2
Pattern found at: 5
Pattern found at: 11
Pattern found at: 20

ababaca
bacbabababacaca

ababaca
abbbababacacaababaca


AAAAB
AAAAAAAAAAAAAAAAAB
*/

public class KMPAlgo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String pattern = sc.nextLine();
		String str = sc.nextLine();

		sc.close();

		int m = pattern.length();
		int n = str.length();

		int len = 0, lps[] = new int[m+1];
		lps[0] = 0;
		//len=-1;
		//lps[0]=len;
		
		/*for(int i=1;i<m;i++){
			
			while(len>0 && pattern.charAt(i)!=pattern.charAt(len+1)){
				len=lps[len];
			}
			if(pattern.charAt(i)==pattern.charAt(len+1))
				len++;
			//i++;
			//len++;
			lps[i]=len;
		}
		for(int i=0;i<m;i++){
			lps[i]=lps[i+1];
		}*/
		
		int i=1;
		while(i<m) {
			if (pattern.charAt(len) == pattern.charAt(i)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len == 0) {
					lps[i] = 0;
					i++;
				} else
					len = lps[i - 1];
			}
		}
		System.out.println("n= "+n+" m= "+m);
		for(int x:lps)System.out.println(x);
		len = 0;
		for (i = 0; i < n;) {
			if (pattern.charAt(len) == str.charAt(i)) {
				len++;
				i++;
				if (len == m) {
					len = lps[len - 1];
					System.out.println("Pattern found at: " + (i - m));
				}
			}
			else {
				if (len != 0)
					len = lps[len - 1];
				else
					i++;
			}
		}

	}

}
