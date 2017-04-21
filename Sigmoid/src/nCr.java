import java.io.*;
import java.math.BigInteger;
/* to find combinations nCr   */
class nCr {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        int num[][]=new int[N][2];
        for (int i = 0; i < N; i++) {
            num[i][0]=Integer.parseInt(br.readLine());
        }
        br.close();
        for (int i = 0; i < N; i++) {
        	BigInteger res=new BigInteger("1");
            for(int j=1;j<=num[i][0];j++){
            	res=res.multiply(BigInteger.valueOf(j));
            }
            System.out.println(res);
        }
    }
}
