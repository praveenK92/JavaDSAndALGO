import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SlashTheString {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine().trim());
        
        String s[]=new String[T];
        int sol[]=new int[T];
        for(int i=0;i<T;i++){
        	s[i]=br.readLine().trim();
        	sol[i]=SlashString(s[i]);
        }
        for(int i:sol)System.out.println(i);        
	}
	
	public static int SlashString(String s){
		int slash=0;
		while(s.length()!=0){
			if(s.length()==1){
				slash++;
				break;
			}
			
			int i=0;
			while(s.substring(i+1).contains(s.substring(0,i+1))){
				i++;
			}
			if(i==0){
				int j=s.length();
				int k=j;
				while(s.substring(0,j-1).contains(s.substring(j-1))){
					j--;
				}
				if(j!=k){
					s=s.substring(0,j);
					slash++;
				}else{
					s=s.substring(1);
					slash++;
				}
			}
			else{
				s=s.substring(i);
				slash++;
			}
			//System.out.println(s);
		}
		return slash;
	}

}
