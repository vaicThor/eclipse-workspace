
public class Car {

	// Caractéristiques
	public  String color ;
	public  String brand ;
	public  float  speed ; 
	
	// Comportements
	public void accelerate () {
		System.out.println("accelerate");
			this.speed = speed +10 ;
		System.out.println("La vitesse est maitenant de "+ speed);
	}
	public void turn(String direction) {
		System.out.println("turn "+direction);
	}
}
