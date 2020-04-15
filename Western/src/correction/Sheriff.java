package correction;

public class Sheriff extends Cowboy{
	
	private int nbThugsInJail;
	
	public Sheriff(String name) {
	super(name);
	this.description = "Honest" ;
	}
	
	public void arrest(Thug thug) {
		this.talk("I'm the law, you're under arrest!");
		thug.isImprison(this);
		this.nbThugsInJail++ ;
	}
	public void reSearch(Thug thug) {
		this.talk("Listen up dumb ass!"+thug.getBounty()+"$ to whoever arrestes "+ thug.whatIsYrName());
	}

}
