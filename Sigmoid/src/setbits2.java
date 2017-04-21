import java.util.*;
import java.io.*;


public class setbits2 {
    

    public static void main(String args[])throws IOException{
             Scanner in=new Scanner(System.in);
             int T=in.nextInt();
             
             for(int num=0;num<T;num++)
             {  Hashtable<String,Integer> tab=new Hashtable<String,Integer>();
             tab.put("0",0);
             tab.put("1",0);
             tab.put("2",0);
             tab.put("3",0);
             tab.put("4",0);
             tab.put("5",0);
             tab.put("6",0);
             tab.put("7",0);
             tab.put("8",0);
             tab.put("9",0);
             tab.put("A",0);
             tab.put("B",0);
             tab.put("C",0);
             tab.put("D",0);
             tab.put("E",0);
             tab.put("F",0);
                 int [] arr=new int[10000000];
                int op=in.nextInt();
                for(int i=0;i<op;i++)
                {
                int s_ind=in.nextInt();
                int e_ind=in.nextInt();
                for(int j=s_ind-1;j<=e_ind-1;j++)
                {
                  arr[j]=arr[j]^1;
                }
                }
                for(int index=0;index<10000000;index=index+4)
                {
                    String bin="";
                    for(int vl=index;vl<index+4;vl++)
                    {
                        bin=bin+arr[vl];
                    }
                                    String str=String.format("%X", Long.parseLong(bin,2));
                                  
                    tab.put(str,tab.put(str,1)+1);
                }
                String prnt="0123456789ABCDEF";
                for(int k=0;k<16;k++)
                {
                   System.out.print(tab.get(String.valueOf(prnt.charAt(k)))+" ");
                }
                System.out.println("");
             }
    }
     }