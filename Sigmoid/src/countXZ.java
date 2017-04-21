import java.util.*;
/* Count number of x or z followed by a space in the string  */
public class countXZ {
		
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the godamn string bro!");
		String str1=sc.nextLine();
		sc.close();
		String s2=Count(str1);
		System.out.println(s2);
	}
	private static String Count(String str){
		int x=0,z=0,len=str.length();
		System.out.println("Length of string: "+len);
		for(int i=0;i<len;i++){
			if(str.charAt(i)=='x' && i+1<len && str.charAt(i+1)==' ' ){
				x++;
				continue;
			}
			else if(str.charAt(i)=='z' && i+1<len && str.charAt(i+1)==' ' ){
				z++;
			}
		}
		if(str.charAt(len-1)=='x')x++;
		else if(str.charAt(len-1)=='z')z++;
		
		String s1=Integer.toString(x)+Integer.toString(z);
		/*  or String s1=String.valueOf(x);  */
		System.out.println(s1);
		return s1;
	}
}
