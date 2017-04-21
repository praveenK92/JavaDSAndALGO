import java.lang.*;
import java.util.Scanner;
import java.util.Random;
public class april {
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		/*System.out.println("Enter 1st team's action");*/
		String s1=s.next();
		/*System.out.println("Enter 2nd team's action");*/
		String s2=s.next();
		if( s1.equals("[]()[]8<") && s2.equals("8<[]()8<") ){
			System.out.println("TEAM 2 WINS");
		}
		else if( s2.equals("[]()[]8<") && s1.equals("8<[]()8<") ){
			System.out.println("TEAM 1 WINS");
		}
		else if( ( s1.equals("8<8<()") && s2.equals("[]8<[]") ) || ( s2.equals("8<8<()") && s1.equals("[]8<[]") || s1.equals(s2) ) ){
			System.out.println("TIE");
		}
	}
}