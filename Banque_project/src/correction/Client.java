package correction;

public class Client {
	private String nom ;
	private Compte[] comptes ;
	private int nbComptes ; 
	
	// Constructor
	public Client (String nomDuClient) {
		this.nom = nomDuClient ;
		this.comptes = new Compte[100] ;
		this.nbComptes = 0 ;
		addCompte();
	}
	// Methods
	public int getNbComptes() {
		return nbComptes;
	}
	public void addCompte() {
		this.comptes[this.nbComptes] = new Compte(nbComptes) ;
		this.nbComptes++ ;
		System.out.println(this.nom+" a un compte créé à son nom et son 1er compte à l'iD :"+ this.comptes[0].getIdCompte());
	}
	// retourne le solde total de tous les comptes du client
	public float getSoldeTotal() {
		float soldeTotal=0 ;
		
		for (int index=0 ; index <this.nbComptes ; index++){
			Compte compte = this.comptes[index] ;
			soldeTotal += compte.getSolde();
			System.out.println("Le compte"+ compte.getIdCompte() +" a un solde de "+ compte.getSolde()) ;	
		}
		return soldeTotal ;
	}

	public void displaySoldeTotal() {
		System.out.println("Le solde de tous les comptes du client "+ this.nom+"est de : " + this.getSoldeTotal());
	}
	public String getNom() { /* pour obtenir la valeur du solde */
		return nom;
	}
	@Override
	public String toString() {
		return "le client pigeon :"+this.nom +" a "+this.nbComptes+ "compte" ;
	}
}

