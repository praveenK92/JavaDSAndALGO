import java.lang.*;
import java.util.*;

public class PalindromeCheck {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		boolean b=Palindrome(str);
		if(b)System.out.println("It is a palindrome");
		else
			System.out.println("It is not a palindrome");
	}
	private static boolean Palindrome(String str){
		int l=str.length(),j,i=0;
		boolean flag=false;
		j=l-1;
		while(str.charAt(i)==str.charAt(j)){
			if(i==j){
				flag=true;
				break;
			}
			i++;
			j--;
			if(j<i){
				flag=true;
				break;
			}
		}
		if(flag)return true;
		else return false;
	}
}