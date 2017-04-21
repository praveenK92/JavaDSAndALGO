import java.io.*;
import java.math.BigInteger;
/* we need to find factorials upto 1000   */
class smallFactorial {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        int num[]=new int[N];
        for (int i = 0; i < N; i++) {
            num[i]=Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < N; i++) {
        	BigInteger res=new BigInteger("1");
            for(int j=1;j<=num[i];j++){
            	res=res.multiply(BigInteger.valueOf(j));
            }
            System.out.println(res);
        }
    }
}
