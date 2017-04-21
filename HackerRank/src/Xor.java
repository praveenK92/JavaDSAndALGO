import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Xor {
/*
 * Complete the function below.
 * maximizing XOR
 */
    static int maxXor(int l, int r) {
    	int a=l^r,c=0,temp;
    	temp=a;
    	while(temp!=0){
    		c++;
    		temp/=2;
    	}
    	a=(int)Math.pow(2,c)-1;
    	return a;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _l;
        _l = Integer.parseInt(in.nextLine());
        
        int _r;
        _r = Integer.parseInt(in.nextLine());
        
        res = maxXor(_l, _r);
        System.out.println(res);
        
    }
}