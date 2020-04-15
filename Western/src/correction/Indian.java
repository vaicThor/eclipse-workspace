package correction;

public class Indian extends Human {
	private String totem ;
	private int feather ;
	
	// Constructor
	public Indian(String name) {
		super(name);
		this.totem = "one";
		this.feather=0 ;
		this.favDrink = "roots juice";
	}
	// Methods
	@Override
	public void introduce() {
		super.introduce();
//		this.talk("I look like "+ this.look);
//		this.talk("I already kidnap "+this.kidnappedLady + " bitches");
	}
	@Override
	public void talk(String msg) {
		super.talk(msg + "Ugh!");
	}
	public void scalp(Paleface paleface) {
		this.feather++ ;
		paleface.isScalped() ;
	}
}
