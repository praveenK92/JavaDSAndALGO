import java.util.Scanner;
class Calci {
	public static void main(String args[]){
		Scanner op=new Scanner(System.in);
		double op1,op2,ans;
		System.out.println("Enter 1st num");
		op1=op.nextDouble();
		System.out.println("Enter 2nd num");
		op2=op.nextDouble();
		ans=op1+op2;
		System.out.println(ans);
}
}