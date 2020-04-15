package correction;

public class Main {
	
	public static void main (String [] args) {
		Banque bank = new Banque() ;
		BanqueInteractive bi = new BanqueInteractive () ;
		bank.addClient("Kadere");
		bank.addClient("Sylvie");
		bank.addClient("Marjolaine");
		bank.addClient("Tartempion");
		bank.addClient("MrLapine");
		
//		bank.getClients()[0] ;
		bank.bilanClient(2);
		bank.displayBilan();
		bank.dispNbClient();
		bi.interaction() ;
		

	

	}
}
