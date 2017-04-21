package InterestingProblems;
import java.util.Scanner;

/*
1
5 4
2
1 0 1 1
0 1 0 1
1 0 1 1
0 1 0 1
1 1 0 0

Ans
2
 */
public class FlippingColumns {
	static int arr[][];
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=1;t<=T;t++){
			int m=sc.nextInt();
			int n=sc.nextInt();
			arr=new int[m][n];
			int k=sc.nextInt();
			
			// for counting no of zeros in zeros[i][0]
			int zeros[][]=new int[m][3];
			
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					arr[i][j]=sc.nextInt();
					
					if(arr[i][j]==0)
						zeros[i][0]++;
				}
				// now we need to find rows with no of zeros
				// of form k-2*n where n=0,1,2,3,...k/2
				if(zeros[i][0]<=k && (k-zeros[i][0])%2==0)
					zeros[i][1]=1;
			}
			// to see which rows identical to whom
			// initially all initialized to false
			// boolean is taken to save space
			boolean Sets[][]=new boolean[m][m];
			
			for(int i=0;i<m;i++){
				if(zeros[i][1]==0)
					continue;
				// now this ith row is an eligible row Next up check with all
				for(int j=0;j<m;j++){
					if(Sets[i][j])continue;
					
					if(j!=i && zeros[j][1]==1 && zeros[i][0]==zeros[j][0]){
						if(same(arr[i],arr[j],n)){
							Sets[i][j]=true;
							zeros[i][2]++;
							zeros[j][2]++;
						}
					}
					else
						continue;
				}
			}
			int max=-1,x=-1;
			for(int i=0;i<m;i++){
				if(zeros[i][2]>max){
					max=zeros[i][2];
					x=i;
				}
			}
			// now if we are to find rows with all 1s then just do this
			int ans=0;
			for(int i=0;i<n;i++){
				if(Sets[x][i])ans++;
			}
			System.out.println("Case #"+t+" "+ans+1);
			arr=null;
		}
		sc.close();
	}
	
	static boolean same(int a[],int b[],int n){
		for(int i=0;i<n;i++){
			if(a[i]!=b[i])return false;
		}
		return true;
	}

}