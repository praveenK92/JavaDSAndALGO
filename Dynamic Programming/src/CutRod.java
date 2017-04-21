import java.lang.*;
public class CutRod {
	static int res[];
	
	public static void main(String[] args) {
		int p[]={1,5,8,9,10,17,17,20,24,30};
		int n=p.length;
		/*int max,max1,max2;
		max=cutrodBad(p,n-1);
		max1=cutRodTopDown(p,n-1);
		max2=cutRodBottomUp(p,n-1);
		System.out.println("from bad method : "+max);
		System.out.println("from TopDown method : "+max1);
		System.out.println("from Bottom Up method : "+max2);*/
		int max1=cutRodBottomUpModify(p,7);
		cutRodNEW(p,7,1);
		
	}
	
	public static int cutrodBad(int[] price,int len){
		/* len=price.length;  max size of price & length has to be same....  */
		if(len==0)return 0;
		int q=Integer.MIN_VALUE;
		for(int i=1;i<=len;i++){
			int temp;
			temp=price[i-1]+cutrodBad(price,len-i);
			q=Math.max(q, temp);
		}
		return q;
	}
	/*  This is TOP DOWN method.			*/
	public static int cutRodTopDown(int[] price,int len){
	 	res=new int[len+1];
	 	for(int i=0;i<=len;i++)res[i]=Integer.MIN_VALUE;
	 	return TopDown(res,price,len);
	}
	public static int TopDown(int res[],int p[],int len){
		if(res[len]!=Integer.MIN_VALUE)return res[len];
		int q;
		if(len==0){q=0;}
		else q=Integer.MIN_VALUE;
		for(int i=1;i<=len;i++){
			int temp=p[i-1]+TopDown(res,p,len-i);
			q=Math.max(q, temp);
		}
		res[len]=q;
		return q;
	}
	
	/* This is BOTTOM UP METHOD  */
	public static int cutRodBottomUp(int p[],int len){
		int res1[]=new int[len+1];
		res1[0]=0;
		for(int j=1;j<=len;j++){
			int q=Integer.MIN_VALUE;
			for(int i=1;i<=j;i++){
				int temp=p[i-1]+res1[j-i];
				q=Math.max(q, temp);
			}
			res1[j]=q;
		}
		return res1[len];
	}
	
	public static int cutRodBottomUpModify(int p[],int n){
		int res1[]=new int[n+1];
		int s[]=new int[n+1];
		res1[0]=0;
		for(int j=1;j<=n;j++){
			int q=Integer.MIN_VALUE;
			for(int i=1;i<=j;i++){
				int temp=p[i-1]+res1[j-i];
				if(q<temp){
					q=temp;
					s[j]=i;
				}
			}
			res1[j]=q;
		}
		printpath(s,res1[n],n);
		return res1[n];
	}
	public static void printpath(int s[],int r,int n){
		while(n!=0){
			System.out.print(s[n]+" ");
			n=n-s[n];
		}
		System.out.println("\nCost is: "+r);
	}
	// c is cost of cut
	public static void cutRodNEW(int p[],int n,int c){
		int res1[]=new int[n+1];
		int s[]=new int[n+1];
		res1[0]=0;
		for(int j=1;j<=n;j++){
			int q=Integer.MIN_VALUE;
			for(int i=1;i<=j;i++){
				int temp=p[i-1]+res1[j-i]-c;
				if(q<temp){
					q=temp;
					s[j]=i;
				}
			}
			res1[j]=q;
		}
		printpath(s,res1[n],n);
	}
	
}
