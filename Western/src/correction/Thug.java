package correction;

public class Thug extends Human implements Outlaw{
	// attributes
	private String look ;
	private int kidnappedLady ;
	private float bounty = 100f;
	private boolean isInJail ;
			
	public Thug(String name) {
		super(name);
		this.look = "mean";
	}
	public void kidnap(Lady lady) {
		this.talk("AhAh! you're my bitch!");
		this.kidnappedLady++ ;
		lady.isKidnap();	
	}
	public void isImprison(Cowboy cowboy) {
		this.talk("Damned! I'm Over..."+ cowboy.whatIsYrName()+", you caught me!");
	}
	public float getBounty() {
		return bounty ;
	}
	@Override
	public String whatIsYrName() {
		return super.whatIsYrName() + " the "+this.look ;
	}
	@Override
	public void introduce() {
		super.introduce();
		this.talk("I look like "+ this.look);
		this.talk("I already kidnap "+this.kidnappedLady + " bitches");
		this.talk("My reward is"+this.bounty+ "$");
		
	}

	
}