import java.util.*;

public class BracketsBalance {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		sc.close();
		Stack<Character> s=new Stack<Character>();
		boolean flag=true;
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(ch=='('||ch=='{'||ch=='['){
				//String s=Character.toString(ch);
				s.push(ch);
				continue;
			}
			else{
				//System.out.println(ch+":"+s.peek());
				if((ch==')'&& s.peek()=='(')||(ch=='}'&& s.peek()=='{')||(ch==']'&& s.peek()=='['))
					s.pop();
				else{
					flag=false;
					break;
				}
			}
		}
		if(flag)System.out.println("True");
		else System.out.println("False");
	}
}