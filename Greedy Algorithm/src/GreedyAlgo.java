import java.util.Scanner;
public class GreedyAlgo {

	public static void main(String[] args) {
		
		
		int s[] =  {1, 3, 0, 5, 8, 5};
	    int f[] =  {2, 4, 6, 7, 9, 9};
	    ActivitySelectionProblem(s,f);
	}
	
	public static void ActivitySelectionProblem(int f[],int s[]){
		int i=0;
		System.out.print("The Required Activities are: "+i);
		for(int j=0;j<s.length;j++){
			if(f[j]>s[i]){
				i=j;
				System.out.print(" "+j);
			}
		}
	}

}
