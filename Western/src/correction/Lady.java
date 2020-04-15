package correction;

public class Lady extends Human {
	// Attributes
	private String dressColor ;
	private boolean isCaptive;
	// Methods
	public Lady(String name) {
		super(name);
		this.favDrink = "milk" ;
	}
	public void isKidnap() {
		this.isCaptive =true ;
		this.talk("Aahhh!! Help!!");
	}
	public void isRelease(Cowboy cowboy) {
		this.isCaptive = false ;
		this.talk("Thank you " + cowboy.whatIsYrName());
	}
	public void changeDress (String color) {
		this.dressColor = color ;
		this.talk("Look at my new "+ this.dressColor+" Dress");
	}
	@Override
	public String whatIsYrName() {
		return "Miss " + super.whatIsYrName();
	}
	@Override
	public void introduce() {
		super.introduce();
		this.talk("My dress is" + dressColor);
	}
	
	
}
