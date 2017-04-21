public class Catalan {
	static int catalan[];
	
	public static void main(String[] args) {
		int n=5;
		int n1=CatalanTopdown(n);
		int n2=CatalanBottomDown(n);
		int n3=CatalanBEST(n);
		System.out.print(n1+"\n"+n2+"\n"+n3+"\n");
		for(int i:catalan)System.out.println("pika: "+i);
	}
	
	public static int CatalanTopdown(int n){
		if(n==0)return 1;
		else if(n==1)return 1;
		catalan=new int[n+2];
		for(int i=0;i<n+1;i++)catalan[i]=0;
		catalan[0]=1;
		catalan[1]=1;
		return Catalan1(catalan,n+1);
	}	
	public static int Catalan1(int catalan[],int n){
		if(n==1)return 1;
		else if(catalan[n]>0)return catalan[n];
		else{
			int q=0;
			for(int i=1;i<n;i++){
				q=q+Catalan1(catalan,i)*Catalan1(catalan,n-i);
			}
			catalan[n]=q;
		}
		return catalan[n];
	}
	
	public static int CatalanBottomDown(int n){
		if(n==0)return 0;
		else if(n==1)return 1;
		int catalan[]=new int[n+1];
		catalan[0]=1;
		for(int i=1;i<=n;i++){
			int temp=0;
			for(int j=0;j<i;j++){
				temp+=catalan[j]*catalan[i-j-1];
			}
			catalan[i]=temp;
		}
		return catalan[n];
	}
	public static int CatalanBEST(int n){
		int p=1,q=1;
		for(int i=2;i<=n;i++){
			p*=i;
			q*=n+i;
		}
		return q/p;
	}
}
