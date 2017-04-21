import java.util.*;
/*  First Occurrence of a non repeating chararcter  */
public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the string");
		String str=sc.nextLine();
		/*str="me awesome";*/
		sc.close();
		String a=NonRepeat(str);
		System.out.println("dfgf "+a);
	}
	public static String NonRepeat(String mainStr){
		int len=0,index=-1;
		len=mainStr.length();
		for(int i=0;i<len;i++){
			char s1=mainStr.charAt(i);
			if(s1==' ')continue;
			int j=i+1,flag=0;
			for(;j<len;j++){
				if(s1==mainStr.charAt(j)){
					flag=1;
					break;
				}
			}
			if(j==len && flag==0){
				index=i;
				System.out.println(i);
				System.out.println(mainStr.charAt(index));
				break;
			}
		}
		
		if(index==-1){
		return "Nopes";}
		else		
			return Character.toString(mainStr.charAt(index));
	}
}
