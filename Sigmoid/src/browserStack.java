import java.io.*;
import java.util.Arrays;
import java.util.Vector;
/*     read an html file & print as given:     */
public class browserStack{
    public static void main(String args[])throws IOException{
        BufferedReader Br=new BufferedReader(new InputStreamReader(System.in));
        Vector<String> tab=new Vector<String>();
        String str=Br.readLine()+" ";
        char [] arr=new char[str.length()];
        int k=0;
        for(int i=0;i<str.length()-1;i++)
        {
            arr[k]=str.charAt(i);
            k++;
            if(str.charAt(i+1)=='<' || i==str.length()-2)
            {
            char [] cpy=Arrays.copyOfRange(arr, 0, k);
            System.out.println(cpy);
                tab.add(String.valueOf(cpy));
                k=0;
            }
        }
        /*for(int i=0;i<tab.size();i++)
        System.out.println(tab.get(i));
        System.out.println("pikachu");*/
        for(int i=0;i<tab.size()-1;i++)
        {     String str1=tab.get(3);
        /*System.out.println(str1);*/
            if(tab.get(i+1)==str1)
                System.out.print(tab.get(i));
               else
                   System.out.println(tab.get(i));
        k=i;
        }
        System.out.print(tab.get(k+1));
    }
}