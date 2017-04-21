import java.lang.*;
import java.util.*;

interface Konohoa{
	void getname();
	void getclan();
	int kills();
	void special_power();
}

class sasuke implements Konohoa{
	public void getname(){
		System.out.println("Sasuke Uchiha");
	}
	public void getclan(){
		System.out.println("The Uchiha");
	}
	public int kills(){
		System.out.println("100");
		return 100;
	}
	public void special_power(){
		System.out.println("Magneyko Sharingan");
	}
}
class naruto implements Konohoa{
	public void getname(){
		System.out.println("Naruto Uzumaki");
	}
	public void getclan(){
		System.out.println("The Uzumaki");
	}
	public int kills(){
		System.out.println("0");
		return 100;
	}
	public void special_power(){
		System.out.println("Kyubi");
	}
}


public class Interfaces_Practice {
	
	public static void main(String[] args) {
		Konohoa na;
		na=(Konohoa)new naruto();
		na.getclan();
		na.getname();
	}

}
