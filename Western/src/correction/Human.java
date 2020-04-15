package correction;

public abstract class Human {
// abstract   : evite d'instancier un objet dans la clase=se human	
	
	// Attributes
	protected String name ;
	protected String favDrink = "water";
	
	
	//Methods
	public void talk(String msg){
		System.out.println("("+this.name+")-"+ msg);
	}

	public void introduce() {
		this.talk("hey!I'm"+this.name+"! Ma fav drink is " +this.favDrink);
	}
	
	public void drink() {
		this.talk("Ah! a good drink of "+ this.favDrink + " Gloups! AAHH");
	}
	
	public String whatIsYrName() {
		return this.name ;
	}
	// Constructor
	public Human(String name) {
		name = this.name ;
	}





}
