import java.util.Scanner;
public class Hanoi {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		TowersOfHanoi(4,'A','B','C');
	}
	public static void TowersOfHanoi(int n, char frompeg, char topeg,char auxpeg)
	{
		if(n==1)
		{
			System.out.println("Move disk 1 from peg "+frompeg +" topeg " + topeg);
			return;
			}
		TowersOfHanoi(n-1,frompeg,auxpeg,topeg);
		System.out.println("Move disk "+n+" "+ frompeg +" frompeg "+topeg);
		TowersOfHanoi(n-1,auxpeg,topeg,frompeg);
	}

}
