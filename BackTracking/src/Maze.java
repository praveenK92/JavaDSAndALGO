import java.util.Scanner;

public class Maze {
	private static boolean sol[][];
	private static int arr[][];
	private static int m,n,sx,sy;

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		m=sc.nextInt();
		n=sc.nextInt();
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				arr[i][j]=sc.nextInt();
				if(arr[i][j]==2){
					sx=i;
					sy=j;
				}
			}
		}
		
	}
	
	public static boolean MazeSolve(int i,int j){
		if(arr[i][j]==3){
			sol[i][j]=true;
			return true;
		}
		if(isSafe(i,j)){
			sol[i][j]=true;
			
			if(MazeSolve(i+1,j) || MazeSolve(i-1,j) || MazeSolve(i,j-1) || MazeSolve(i,j+1))
				return true;
			sol[i][j]=true;
		}
		return false;
	}
	public static boolean isSafe(int i,int j){
		if(i>=0 && i<m && j>=0 && j<n && arr[i][j]==1 && !sol[i][j])
			return true;
		return false;
	}
}
/*
4 4
2 0 0 0
1 1 0 1
0 1 0 0
1 1 1 3
 * */