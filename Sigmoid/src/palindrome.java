import java.util.Scanner;

public class palindrome {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s1;
		System.out.println("Enter the string");
		int n=0;
		s1=sc.nextLine();
		sc.close();
		n=palindrome_count(s1);
		System.out.println("The required no. of words:  "+n);
	}
	private static int palindrome_count(String str){
		int len=str.length(),count=0;
		System.out.println(str);
		for(int i=len-1,j=0;i>=0 && j!=len-1;){
			if(str.charAt(i)==str.charAt(j)){
				j++;
				i--;
				System.out.println("inside "+j);
				continue;
			}
			else
			{
				count+=1;
				System.out.println("yenra count= "+count);
				j++;
			}
		}
		return count;
	}

}
