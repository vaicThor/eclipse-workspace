package correction;

public class Cowboy extends Human implements Paleface{
	// Attribute
	private int popularity ; 
	protected String description ; 
	
	// Methods
	public void shoot(Thug thug) {
		System.out.println("The "+this.description+" "+this.whatIsYrName()+" Cowboy shots" +thug.whatIsYrName() + "Bang!" );
	}
	public void release (Lady lady) {
		lady.isRelease(this) ;
		this.popularity ++ ;
		this.talk(lady.whatIsYrName()+", you are free now!");
	}
	@Override
	public void introduce() {
		super.introduce();
		this.talk("Peaople call me the "+ this.description);
		if (popularity>0) {
			this.talk("beacause I already released"+ this.popularity+"ladies");
		}
	}
	public void isScalped() {
		this.talk("AHHH fucking sauvage à la bite en plume!");
	}
	
	
	// Constructor
	
	public Cowboy(String name) {
		super(name) ;
		this.description = "vailiant";
		this.favDrink = "Wiskey";
	}
	
}
