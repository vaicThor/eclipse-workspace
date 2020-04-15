package agecapichef;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Capitaine {
	private int age ;

	
	public Capitaine() {
}
	
	public int howOldIsHe() {
	
		int nombreAleatoire = 1 + (int)(Math.random() * ((72-1) + 1));
		this.age = nombreAleatoire;
		return age;
	}
	
	public void getAgeCap()  {
	   Scanner scanner = new Scanner(System.in);
	   System.out.println("age capi?");
		try {		
			int age= scanner.nextInt();
			if ( age<18 || age>65) {
			throw new AgeCapichefException();
			}else {System.out.println("good");	}
		}catch (AgeCapichefException | InputMismatchException  e2) {
			System.out.println(e2.getMessage());
				getAgeCap();
				}
			
	}
	
	public int getAge() {
		return this.age;
	}
}
