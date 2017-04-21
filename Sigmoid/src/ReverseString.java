public class ReverseString {
		
	public static void main(String[] args) {
		/*Scanner sc=new Scanner(System.in);
		System.out.println("Enter the string");
		String str=sc.nextLine();*/
		String str1="I am Uchiha Itachi";
		String rev1=Reverse(str1);
		System.out.println(rev1);
		
	}
	private static String Reverse(String str){
		String rev="";
		int len=str.length(),j;
		System.out.println(len);
		for(int i=len-1;i>=0;i--){
			j=i;
			
			while(str.charAt(i)!=' ' && i>0){
				System.out.println(i);
				i--;
				}
			rev+=str.substring(i,j+1)+' ';
			System.out.println(rev+" val of: "+i);
		}
		rev=rev.trim();
		return rev;
	}
}