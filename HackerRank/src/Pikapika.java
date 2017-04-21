import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Pikapika {

    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        double sol[]=new double[T];
        for(int i=0;i<T;i++){
        	String s1[]=br.readLine().split(" ");
            int a=Integer.parseInt(s1[0]);
            int b=Integer.parseInt(s1[1]);
            int c=Integer.parseInt(s1[2]);
            sol[i]=Probability(a,b,c);
        }
        for(double i:sol)System.out.println(i);
    }
    public static double Probability(int a,int b,int c){
    	double a1=(double)a;
    	double b1=(double)b;
    	double c1=(double)c;
    	
        double s=(a1+b1+c1)/2;
        double z=s*(s-a1)*(s-b1)*(s-c1);
        double z1=Math.sqrt(z);
        double r=z1/s;
        double z2=Math.PI*r*r;
        return z2/z1;
    }
}