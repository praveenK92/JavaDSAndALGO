package PatternSearch;

import java.util.Scanner;

public class NaiveAlgo {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		String pattern=sc.nextLine();
		String str=sc.nextLine();
		
		sc.close();
		
		int m=pattern.length();
		int n=str.length();
		
		for(int i=0;i<=n-m;i++){
			int j=0;
			for(;j<m;j++){
				if(str.charAt(i+j)!=pattern.charAt(j))
						break;
				//System.out.println("Match at "+(i+j)+" "+pattern.charAt(j));
			}
			if(j==m)System.out.println("Pattern found at "+i);
		}
		
		
	}
}