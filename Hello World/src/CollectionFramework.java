import java.lang.*;
import java.util.*;

public class CollectionFramework {
	
	public static void main(String[] args) {
		/* Implementing HashSet in java */
		HashSet<String> hs=new HashSet<String>();
		
		hs.add("naruto");
		hs.add("sasuke");
		hs.add("itachi");
		hs.add("madara");
		hs.add("minato");
		hs.add("sakura");
		
		System.out.println(hs);
		Iterator it=hs.iterator();
		while(it.hasNext()){
			String s=(String)it.next();
			System.out.println(s);
		}
		
	}

}
