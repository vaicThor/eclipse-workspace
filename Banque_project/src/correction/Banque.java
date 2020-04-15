package correction;  

public class Banque {
	private Client[] clients ;
	private int nbClients ;
	
	public Banque() {
		this.clients = new Client[100];
	}
	
	public void bilanClient(int idClient) {
		Client client = this.clients[idClient] ;
		System.out.println("### Client " + idClient+"###");
		System.out.println("### Nombre de comptes : " + client.getNbComptes());
		
		client.displaySoldeTotal();
		System.out.println("###");
	}
	public void addClient (String nomDuClient) {
		System.out.println("Le client "+ nomDuClient+ " a été créé");
		Client nouveauClient = new Client(nomDuClient) ;
		this.clients[nbClients] = nouveauClient ;
		nbClients++;
	}
	public int getNbClients() {
		return nbClients;
	}
	public void dispNbClient() {
		System.out.println("Le nombre de clients est de "+ getNbClients());
	}
	public void displayBilan() {
		System.out.println("## BILAN GENERAL ##");
		for (int index =0; index< this.nbClients ; index++) {
			this.bilanClient(index);
		}
		System.out.println("#######");
	}
	public Client[] getClients() {
		return clients;
	}

}
