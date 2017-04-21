import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LonelyInteger {
static int lonelyinteger(int[] a) {
	ArrayList<Integer> b=new ArrayList<Integer>();
	for(int i=0;i<a.length;i++){
		if(b.size()==0){
			b.add(a[i]);
			continue;
		}
		else
		{
			if(b.contains(a[i]))b.remove(Integer.valueOf(a[i]));
		else
			b.add(a[i]);
		}
	}
	int c=b.get(0);
	return c;
    }
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        
        int _a_size = Integer.parseInt(in.nextLine());
        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");
        
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }
        
        
        
        res = lonelyinteger(_a);
        System.out.println(res);
        
    }
}
