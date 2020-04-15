
public class Humans {
	
	// Attributes
	private String name ;
	protected String favDrink = "l'eau" ;
	
	
	// Methods - Getter/Setter
	public String getName() {
		return name;
	}
	public String getFavDrink() {
		return favDrink;
	}
	public void setFavDrink(String favDrink) {
		this.favDrink = favDrink;
		System.out.println("wooow this fucking " +favDrink+" is my new boisson préféré");
	}
	public void modifyDrink(String Drink) {
		setFavDrink(Drink);
	}
					/// Fait parler le bonhomme!
	public void speak(String sentenceSpeakin) {		
		System.out.println(this.name + ":"+ sentenceSpeakin) ;
	}
					/// = à quel_est_ton_nom()
	public void introduceYrslf() {
		System.out.println(name + ": Salut, moi c'est "+ name+" and I love beaucoup " + this.favDrink);		
	}
	
	// Constructor
	public Humans(String name) {
		this.name = name ; 
	}
//	public Humans () {
//		introduceYrslf();
//	}
}
	
