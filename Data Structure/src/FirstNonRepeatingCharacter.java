import java.util.*;
/*  First Occurrence of a non repeating chararcter  */
public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the string");
		String str=sc.next();
		String a=NonRepeat(str);
		System.out.println(a);
		sc.close();
	}
	public static String NonRepeat(String mainStr){
		int len=0,index=-1;
		len=mainStr.length();
		for(int i=0;i<len;i++){
			char s1=mainStr.charAt(i);
			int j=0;
			for(;j<len;j++){
				if(s1==mainStr.charAt(j))break;
			}
			if(j==len){index=i;
			System.out.println(i);}
		}
		System.out.println(len);
		if(index==-1){
		return "Nopes";}
		else		
			return Character.toString(mainStr.charAt(index));
	}
}
