import java.util.Random;

public class Sheriff extends Cowboy {
	// Attributes
	private String looks = "honn�te";
	
	// Constructor
	public Sheriff(String name) {
		super(name);
		this.introduceYrslf();
	}
	// Methods
	@Override
	public boolean hitBrigand(Brigands brigandName){
		    System.out.println("wooh j'vais me faire cette raclure de "+ brigandName.getName()+"le"+ brigandName.getLooks());
			Random randomHit = new Random();
			boolean isCaptured = randomHit.nextBoolean();
			if (isCaptured == true) { 
					System.out.println("Moi le Sh�rif "+this.getName()+"l'"+this.looks+" je me suis fait "+brigandName.getName()+" le "+ brigandName.getLooks()) ;
			}else {
				System.out.println(brigandName.getName()+": rat� boloss! I runaway");
			}
					return isCaptured ;
		
	}
	@Override
	public void introduceYrslf() {
		System.out.println("Wep, wep, wep! C'est bien le Sh�rif "+this.getName()+" L'"+this.looks+
									". Ce qui me ravigore l'Gosier c'est bien le "+ getFavDrink());
		
	}
	public void wantedBrigand(Brigands brigandName, float newReward){
		brigandName.setReward(newReward);
		System.out.println("COME ON!! People! I fucking give "+newReward+"$ au batard qui me ramenera la t�te de "+
									brigandName.getName()+" le "+brigandName.getLooks()+"\n avec ou sans le corps!");
	}
	
	
}
