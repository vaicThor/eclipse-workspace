
public class Main {
	public static void main (String[] args) {
		System.out.println("Hola! Welcome to the bank-");
		
			BanqueInteractive banque = new BanqueInteractive() ;
			banque.addClient("Marie", 1);
			Compte compteDTC = new Compte("Mat",7);
			compteDTC.depot(200);
			banque.addClient("Julien",3) ;

			Client client = new Client("Jeanne",2);
			client.addCompte(1);  
			client.addCompte(1);  
 
			Compte compte = new Compte("Paluche",5) ;
			compte.depot(200);
			banque.bilanClient(2);	
	
	}		
	

}
