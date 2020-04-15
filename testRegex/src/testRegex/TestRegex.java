package testRegex;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String tag;
		Map<Integer,String> tags= new HashMap<Integer,String>();
		Integer k = 0;
	    String gabText ="Bonjour, ça va bien? je vais au ski et à la mer. un jour j'irai pas à NewYork #coincoin #lolo";

	    List tagList=new ArrayList();
		
		Pattern p = Pattern.compile("\\s");
		String[] items = p.split(gabText, 100);

		for(int i=0; i<items.length; i++) {
		System.out.println(items[i]);
		}
		
		Pattern p2 = Pattern.compile("#");
		Matcher m =p.matcher(gabText) ;

	for (int j=0; j<items.length;j++) {
		Matcher m2 =p2.matcher(items[j]);
		if (m2.find()==true) {
			tag = items[j].substring(1);
			tags.put(k,tag);
			k++;
			System.out.println("done "+ items[j]);
		}
	}
	for(String urlTag : tags.values()) {
	String urlTwit="<a href='https://www.twitter.com/hashtag/"+urlTag+">#"+urlTag+"</a>";
	tagList.add(urlTwit);
	}	
	 k=0;
    for (String item : items) {
       
    	Matcher m2 = p2.matcher(item);
        if (m2.find()) {
        	gabText=gabText.replace(item, (String)tagList.get(k));
        	k++;
        }
    }
			
System.out.println(gabText);
}
	
	
}
// CASE_INSENSITIVE
// Pattern
// Matcher
//compilation de la regex
//l'expression rationnelle à deux caractères ^T correspondrait au début de la ligne