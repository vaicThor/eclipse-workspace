package agecapichef;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Registration {
	
	static final String login = "Mich";
	static final String psw   = "spliff" ;
	
	
	public Registration() {
		
	}
	public void connexion()  {
		  Scanner scanner = new Scanner(System.in);
		   	System.out.println("Login");
//			try {		
				String ans= scanner.nextLine();
		  while ( ans != login) { 
		   		System.out.println("Login");
		   		ans= scanner.nextLine();			
		  }		
		   	System.out.println("good!");
	}
}
//		  throw new AgeCapichefException();
//				}else {System.out.println("good");	}
////			}catch (AgeCapichefException | InputMismatchException  e2) {
//				System.out.println(e2.getMessage());
//					getAgeCap();
//					}

