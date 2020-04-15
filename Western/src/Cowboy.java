import java.util.Random;

public class Cowboy extends Humans {

	private int popularity ;
	private String looks = "Vaillant";
	private boolean isShot ;
	
	
	
	
	
	// Methods
			// Savoir si le brigand est touché
	public boolean hitBrigand(Brigands brigandName) {
	    Random randomHit = new Random();
		this.isShot = randomHit.nextBoolean();
		if (this.isShot == true) { 
				System.out.println(brigandName.getName()+" is captured") ;
		}else {
			System.out.println("raté boloss!"+brigandName.getName()+" is parti far away");
		}
				return this.isShot ;	
	}
	

	public boolean getIsShot() {
		return this.isShot;
	}
	@Override
	public void introduceYrslf() {
		System.out.println("Salut, moi c'est "+ super.getName()+ " le"+ this.looks+
				" et le" + super.getFavDrink()+" C'est ma tasse de thé!");	
	}
	
	//Constructor
	public Cowboy (String name) {
		super(name) ;
		super.favDrink = "Jack D";
		this.introduceYrslf();
	}
}
