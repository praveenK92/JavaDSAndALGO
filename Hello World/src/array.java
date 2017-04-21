import java.util.Random;
public class array {

	/**
	 * @param args
	 */
	public static void main(String args[]) {
		Random r1=new Random();
		int freq[]=new int[7];
		for(int j=0;j<1000;j++){
			++freq[1+r1.nextInt(6)];
		}
		System.out.println("Face\tFrequency");
		for(int i=1;i<freq.length;i++){
			System.out.println(i+"\t"+freq[i]);
			}
	}
}