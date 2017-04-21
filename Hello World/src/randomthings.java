import java.lang.*;
import java.util.*;

class my{
	int y;
	my(int y){
		this.y=y;
	}
	void getdata(){
		System.out.println("y= "+this.y);
	}
	void show1(){
		System.out.println("in my ");
	}
}

class Myclass extends my implements Cloneable{
	int x;
	Myclass(int y,int x){
		super(y);
		this.x=x;
	}
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	void getdata(){
		super.getdata();
		System.out.println("x= "+this.x);
	}
}
class know{
	static void print(Object obj){
		Class c=obj.getClass();
		String name=c.getName();
		System.out.println(name);
	}
}
public class randomthings {
	public static void main(String[] args) throws CloneNotSupportedException {
		/*int a=256;
		int b=5;
		long c=Integer.longValue(a);
		/*int b=Integer.parseInt(Integer.toBinaryString(a));
		System.out.println(a+" sh\n"+c);*/
		
		/*int inarr1[] = {1, 2, 3};
	      int inarr2[] = {1, 2, 3}; 
	      Object[] arr1 = {inarr1};  // arr1 contains only one element
	      Object[] arr2 = {inarr2};  // arr2 also contains only one element
	      Object[] outarr1 = {arr1}; // outarr1 contains only one element
	      Object[] outarr2 = {arr2}; // outarr2 also contains only one element        
	      if (Arrays.deepEquals(outarr1, outarr2))
	          System.out.println("Same");
	      else
	          System.out.println("Not same");*/
		
		/*Myclass o=new Myclass(45,50);
		Myclass o1=(Myclass)o.clone();
		
		o.x=56;
		o.y=67;
		o.getdata();
		o1.getdata();*/
		
		/* widening
		my o1;
		o1=(my)new Myclass(34,45);
		o1.getdata();
		o1.show1();*/
		
		/*my o2;
		o2=new Myclass(34,46);
		Myclass o1=(Myclass)o2;
		
		o1.getdata();
		o1.show1();*/
		
		/*boolean a=true,b=true;
		Boolean a1=new Boolean("false");
		Boolean a2=new Boolean(b);
		System.out.println(100*Math.random());*/
		
	}

}
