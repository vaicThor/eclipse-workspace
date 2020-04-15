package test_collections;


import java.util.*;
import java.io.*;

public class TestCollectionCountWords {
	public static void main (String [] args) {
  	  	Map<String, Integer> allWords = new HashMap<String, Integer>();
//		List<String> allWords = new ArrayList<String>();
		
		File file = new File("C:\\Users\\Vic\\Desktop\\rfc1206.txt");

	      Scanner sc = null;
	      try {
	          sc = new Scanner(file);
	      } catch (FileNotFoundException e) {
	          e.printStackTrace();  
	      }
	      
	      
	      while (sc.hasNextLine()) {
	              Scanner s2 = new Scanner(sc.nextLine());
	          while (s2.hasNext()) {
	        	  String s = s2.next();
	        	  
	        	  allWords.put(s,0);
//	              System.out.println(s);
	          }
	      }
	      System.out.println(allWords);
	}
}
// TODO : utiliser iterator juste avant allword et sortedmap



//		String pathFichier="C:\\Users\\Vic\\Desktop\\rfc1206.txt";
//
//		BufferedReader fluxEntree=null;
//		try {
//			/* Création du flux vers le fichier texte */
//			fluxEntree = new BufferedReader(new FileReader(pathFichier));
//
//			/* Lecture d'une ligne */
//			String ligneLue = fluxEntree.readLine();
//
//			while(ligneLue!=null){
//				System.out.println(ligneLue);
//				ligneLue = fluxEntree.readLine();
//			}
//		}
//		catch(IOException exc){
//			exc.printStackTrace();
//		}
//		finally{
//			try{
//				if(fluxEntree!=null){
//					/* Fermeture du flux vers le fichier */
//					fluxEntree.close();
//				}
//			}
//			catch(IOException e){
//				e.printStackTrace();
//			}
//		}
		
