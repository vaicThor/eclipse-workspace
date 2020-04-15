package correction;

public class Barman extends Human{
	// Zttributes
	private String barName ;
	
	// Constructor
	public Barman(String name) {
		super(name);
		this.favDrink = "wine" ;
		this.barName= "At" + name ;
	}
	public Barman(String name, String barName) {
		super(name);
		this.favDrink = "wine" ;
		this.barName= barName ;
	}
	public void serve (Human h) {
		this.talk("here, is your "+h.favDrink);
	}



}
