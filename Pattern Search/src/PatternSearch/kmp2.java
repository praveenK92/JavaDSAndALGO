package PatternSearch;

public class kmp2 {

	public static void main(String[] args) {
		//char[] ptrn=new char[4];
		char[] ptrn = "aaab".toCharArray();
		int i = 0, j = -1;
        int ptrnLen = ptrn.length;
        int[] b = new int[ptrnLen + 1];
 
        b[i] = j;
        while (i < ptrnLen) {
            while (j >= 0 && ptrn[i] != ptrn[j]) {
                // if there is mismatch consider next widest border
                j = b[j];
            }
            i++;
            j++;
            b[i] = j;
        }
        for(int x=0;x<=ptrnLen;x++)System.out.print(b[x]+" ");
        
        
        i=0;j=0;
        
        char[] text = "aaacaaaabbaabaaab".toCharArray();
        int txtLen = text.length;
        while (i < txtLen) {
            while (j >= 0 && text[i] != ptrn[j]) {
                j = b[j];
            }
            i++;
            j++;
 
            // a match is found
            if (j == ptrnLen) {
                System.out.println("FOUND SUBSTRING AT i " + i + " and index:"
                        + (i - ptrnLen));
                j = b[j];
            }
        }
        
	}

}
