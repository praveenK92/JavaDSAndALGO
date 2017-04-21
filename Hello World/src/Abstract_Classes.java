import java.lang.*;
import java.util.*;

abstract class Calculate{
	double num;
	abstract double Calculateit(double n);
	void show(){
		System.out.println(this.num);
	}
}
class SquareRoot extends Calculate{
	double Calculateit(double n){
		return Math.sqrt(n);
	}
	public void show1(){
		System.out.println(this.num);
	}
}
public class Abstract_Classes {
	public static void main(String[] args) {
		Calculate c;
		c=new SquareRoot();
		System.out.println(c.Calculateit(56));
		c.num=45;
		c.show();
		/*c.show1();  gives error because its not mentioned in Calculate class.*/
	}
}