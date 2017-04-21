import java.util.*;

/* Add and multiply numbers find them */
public class numberAddMul {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the expression: ");
		String str=sc.nextLine();
		sc.close();
		int res=Calculate(str);
		System.out.println("The result of expression "+str+" is :"+res);
	}
	private static int Calculate(String str){
		int len=str.length(),j=0,i=0;
		int op1=-1,op2=-1,op3=-1,opn1=0,opn2=0;
		for(;i<len;i++){
			j=i;
			char ch=str.charAt(i);
			
			while(ch!='*' && ch!='+'){
				if(i==len-1)break;
				i++;
				ch=str.charAt(i);
			}
			if(opn1==0){
				if(ch=='*')
				opn1=1;
				else opn1=2;
			}
			else if(opn2==0){
				if(ch=='*')
				opn2=1;
				else opn2=2;
			}
			if(op1==-1)op1=Integer.parseInt(str.substring(j,i));
			else if(op2==-1)op2=Integer.parseInt(str.substring(j,i));
			else op3=Integer.parseInt(str.substring(j));		
		}
		int res;
		System.out.println("Op1="+op1+" Op2="+op2+" Op3= "+op3);
		System.out.println(opn1+" 1 for * 2 for + "+opn2);
		if(opn1==1){
			res=op1*op2;
			if(opn2==1)res=res*op3;
			else res+=op3;
		}
		else if(opn2==1){
			res=op1+op2*op3;
		}
		else res=op1+op2+op3;
		return res;
	}
}