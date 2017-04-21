import java.util.Scanner;
public class make_palindrome {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		String s[]=new String[T];
		for(int i=0;i<T;i++)
		{
			s[i]=sc.next();
		}
		for(String k : s)
		{
			int j=k.length()-1;
			int i=0;
			int count=0;
			while(i<=j)
			{
				int a=k.charAt(i)-k.charAt(j);
				if(a<0)a*=-1;
				i++;
				j--;
				count+=a;
			}
			System.out.println(count);
		}
	}
}