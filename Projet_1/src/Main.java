
public class Main {
	public static void main (String[] args) { // Static veut dire que la classe ne d�pend d'aucune instance (fonction)
	
		Car myCar  = new Car() ; 
		myCar.accelerate() ; 
		
		Car myCar2 = new Car() ;
		System.out.println(myCar2.speed) ;		
	
		myCar2.turn( "left");
	}
	
	
}
