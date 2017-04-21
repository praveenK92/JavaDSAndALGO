import java.util.Scanner;

public class InsertInSortedArray {

	public static void main(String[] args) {
		int a[]={3,6,12};
		int b[]=new int[6];
		for(int i=0;i<a.length;i++)
			b[i]=a[i];
		int co=2;
		Scanner sc=new Scanner(System.in);
		for(int z=0;z<3;z++){
			int t=sc.nextInt();
			
			int l=0,h=co,m;
			boolean fl=false;
			m=(l+h)/2;
			
			while(l<=h){
				if(t<b[m]){
					h=m-1;
					m=(l+h)/2;
					continue;
				}
				else if(t>b[m]){
					l=m+1;
					m=(l+h)/2;
					continue;
				}
				else{
					fl=true;
					break;
				}
			}
			if(fl)continue;
			else{
				if(t>b[m])m++;
				
				int prev=b[m],next;
				b[m]=t;
				for(int j=m+1;j<=co+1;j++){
					next=b[j];
					b[j]=prev;
					prev=next;
				}
				co++;
			}
			System.out.print(z+1+" : ");
			for(int i:b)System.out.print(" "+i);
		}
	
	}
	

}
