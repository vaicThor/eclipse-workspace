
public class BanqueInteractive {
	// Attributes
	private String clientName ;
	private Client[] clients = new Client [100] ;
	public int nbClients ; 
	public float bilan ;
	public float bilanTotal ;
	
	// Methods
	public void addClient(String clientName,  int idClient) {
		this.clientName = clientName ;
			Client client = new Client(clientName, idClient) ;
		
	}
	public void bilanClient(int idClient) {
		for(int k = 0; k<= this.nbClients; k++) {
			for(int i=0; i <= clients[k].getNbCompte(); i++) {
				System.out.println("Le solde du compte n°"+i+"du client n°"+ idClient +" est de : " + clients[k].tableCompte[i].getSolde()) ;
			}
		}
	}
}
//	}
//	public float afficherBilan() {
//		for(int i=0; i == this.nbClients; i++) {
//			this.bilanTotal = this.bilanTotal + bilanClient(clients[i].idClient) ;
//		}
//		System.out.println("Le bilan total de la banque est de : " + this.bilanTotal) ;		
//		return this.bilanTotal ;
//	}
//	// Constructor
//	// Default!
//}
