import java.util.Scanner;
import java.lang.*;
class apple {
	public static void main(String args[]){
		/*Scanner bb=new Scanner(System.in);
		System.out.println(bb.nextLine());
		System.out.println("Hello RED JOHN!");
		double it;
		it=8.9;
		System.out.print("i am the KING ");
		System.out.print(it);*/
		
		/*time t1=new time();
		time t2=new time(3);
		time t3=new time(3,7);
		time t=new time(3,7,8);
		System.out.println(t1.getTime());
		System.out.println(t2.getTime());
		System.out.println(t3.getTime());
		System.out.println(t.getTime());*/
		
		/*for(friend a: friend.values()){
			System.out.printf(a);
		}*/
		/*double a=1.2;
		double b=1.20;
		if(a==b)
			System.out.printf("all right");
		else
			System.out.printf("dat");*/
		int a[]={1,2,3,4,5,6,7,8,9,10};
		int b[]=new int[20];
		/*for(int i=5;i<10;i++){
			b[i]=a[i];
		}
		for(int i=0;i<=4;i++){
			b[i+10]=a[i];
		}*/
		
		System.arraycopy(a, 5, b,5, 5);
		/*System.arraycopy(a, 0, b,10, 5);*/
		for(int c:b)
		System.out.println(c);		
	}
}
