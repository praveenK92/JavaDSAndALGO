import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PalindromeAnagram {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        String inputString = myScan.nextLine();
       
        String ans;
        // Assign ans a value of YES or NO, depending on whether or not inputString satisfies the required condition
        int al[]=new int[26],odd=0;
        int len=inputString.length();
        /*for(int i=0;i<len;i++){
            switch(inputString.charAt(i)){
            case 'a':al[0]++;break;
            case 'b':al[1]++;break;
            case 'c':al[2]++;break;
            case 'd':al[3]++;break;
            case 'e':al[4]++;break;
            case 'f':al[5]++;break;
            case 'g':al[6]++;break;
            case 'h':al[7]++;break;
            case 'i':al[8]++;break;
            case 'j':al[9]++;break;
            case 'k':al[10]++;break;
            case 'l':al[11]++;break;
            case 'm':al[12]++;break;
            case 'n':al[13]++;break;
            case 'o':al[14]++;break;
            case 'p':al[15]++;break;
            case 'q':al[16]++;break;
            case 'r':al[17]++;break;
            case 's':al[18]++;break;
            case 't':al[19]++;break;
            case 'u':al[20]++;break;
            case 'v':al[21]++;break;
            case 'w':al[22]++;break;
            case 'x':al[23]++;break;
            case 'y':al[24]++;break;
            case 'z':al[25]++;break;        
            
            }
        }*/
        for(int i=0;i<len;i++){
        	int a=inputString.charAt(i)-'a';
        	al[a]++;
        }
        
        
        for(int i=0;i<26;i++){
        	if(al[i]%2==1)odd++;
        }
        if(odd==1 || odd==0)ans="YES";
        else ans="NO";
        
        System.out.println(ans);
        myScan.close();
    }
}
