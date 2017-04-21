import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.*;

public class FlashAndCoins{

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        boolean sol[]=new boolean[T];
        for(int i=0;i<T;i++){
            float t=Float.parseFloat(br.readLine());
            sol[i]=Countable(t);
        }
        for(boolean i:sol){
        	if(i)System.out.println("YES");
        	else System.out.println("NO");
        }
    }
    public static boolean Countable(float n){
        int a=(int)n;
        float b=n-a;
        if(b==0.0)return true;
        else return false;
    }
}