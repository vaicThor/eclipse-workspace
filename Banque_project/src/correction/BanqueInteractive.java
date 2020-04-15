package correction;

import java.util.Scanner;

public class BanqueInteractive {

	private Banque  banque  ;
	private Scanner scanner ; 
	
	public BanqueInteractive () {
		this.banque = new Banque();
		this.scanner = new Scanner(System.in) ;
	}
	public void interaction() {
		
		System.out.println("Bienvenue dans");
		System.out.println("Quelle operation voulez-vous effectuer?\r\n" + 
				"1) Ajouter un client\r\n" + 
				"2) Effectuer une operation sur un client\r\n" + 
				"3) Afficher un bilan general");
		int ans = this.scanner.nextInt();
		switch ( ans ) { //Case for add client 
			case 1 :
				System.out.println("Vous avez choisi d'ajouter un client");
				System.out.println("choississez un nom de client");
				scanner.nextLine();
				String str = this.scanner.nextLine();
				banque.addClient(str);
				break;
			case 2 :
				System.out.println("Vous avez chois d'effectuer une operation sur un client");
				break;
			case 3 :
				System.out.println("Vous avez chsoisi d'afficher un bilan general");
				break;
			default :
				System.out.println("This choice doesn't exist");
		}
	}
		
		private Client chooseClient() {
			System.out.println("quel client?");
			Client clients[] = banque.getClients();
			for (int index =0 ; index<banque.getNbClients();index++) {
				System.out.println(index+") "+ clients[index].getNom());
			}
			int  choixClient = scanner.nextInt();
			return banque.getClients()[choixClient] ;
		}
	
	


}

