
public class Brigands extends Humans {
	
	// Attributes
	private String looks = "Mauvais";
	private int rapeLady ;
	private float reward = 100f ;
	private boolean isInJail ;
	//Methods
	public void dispReward() {
		System.out.println("Bien ouéj! you win "+ this.reward+"$");
	}
	public void dispReward(float reward) {
		System.out.println("Bien ouéj! you win "+ reward+"$");
	}
	@Override
	public void introduceYrslf() {
		System.out.println("Salut, moi c'est "+ super.getName()+ " le "+ 
				this.looks +  " et la " + super.getFavDrink()+ " me parfume l'oignon!");	
		System.out.println(super.getName()+": Yeah dude! I looks "+this.looks +  " and I kidnap " + this.rapeLady+" petite Lady");
		System.out.println(super.getName()+": My head's reward is " + this.reward);
		
	}
	public String getLooks() {
		return looks ;
	}
	//Constructor
	public Brigands (String name) {
		super(name) ;
		super.favDrink = "liqueur d'échalotte";
		this.introduceYrslf();
	}
//	public boolean isInJail() {
//		if (boolean Cowboy.getIsShot() == true) {
//			
//		}
//			
//	}
	public float getReward() {
		return reward;
	}
	public void setReward(float reward) {
		this.reward = reward;
	}
	

}
