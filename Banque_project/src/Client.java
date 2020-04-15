
public class Client {

	// Attributes
	private String clientName ;
	private int idCompte ;
	private int nbCompte ;
	public int idClient ;
	public Compte[] tableCompte = new Compte [100] ;
	
	// Methods
	public int getIdClient() {
		return idClient;
	}
	public int getNbCompte() {
		return nbCompte;
	}
	public String getNom() { /* pour obtenir la valeur du solde */
		return clientName;
	}
	public float afficherSolde(int i) {
		return tableCompte[i].getSolde() ;
	}
	public void addCompte() {
			this.tableCompte[nbCompte]= new Compte(this.clientName, this.idCompte);
			nbCompte++ ;		
		
		System.out.println(this.clientName+" détient : "+ nbCompte+" compte(s)") ;
	}
	float soldeTotal = 0.0f ;
	public  float getSoldeTotal() { /* pour obtenir la valeur du solde */
		for (int i =0 ; i == nbCompte ; i++) {
				this.soldeTotal = this.soldeTotal + tableCompte[i].getSolde() ;
		}
		return this.soldeTotal ;
	}

	// Constructor
	
	public Client ( String clientName,  int idClient) {
		this.clientName = clientName ;
		this.idClient = idClient ;
		System.out.println("le client : "+clientName+" a été créé avec l'ID : "+idClient) ;
	}

}