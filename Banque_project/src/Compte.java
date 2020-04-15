
public class Compte {
	
	// attributes 
	private int   idCompte            ;
	private float solde       = 200f  ;
	private String clientName ;
	
	// Constructor
	public Compte(String clientName, int idCompte) {
		this.idCompte = idCompte ;
		this.clientName = clientName ;
		
		System.out.println("Le compte #"+idCompte+" de " +clientName+"a été créé");
	}
	
//	public Compte (	
//	}
	
	// Methods
		// pour faire un depot
	public void depot(float depositOrWithdrawal) { /* pour faire un depot sur le compte. */
		this.solde = this.solde + depositOrWithdrawal ;
		System.out.println(depositOrWithdrawal + "€ a été déposé sur le compte");		
	}	
		// pour faire un retrait
	public void retrait(float depositOrWithdrawal) { /* pour faire un retrait sur le compte. */
		this.solde = this.solde - depositOrWithdrawal ;
	}
		// Pour afficher solde
	public float getSolde() { /* pour obtenir la valeur du solde */
		return solde;
	}
	
	public void afficherSolde() { /* pour afficher le solde */
		System.out.println("Ton solde de clochard est de :" + this.solde);
	}
	// 
	public void virer(Compte destinataire, float moneyTransfered) {
//		this.moneyTransfered = moneyTransfered ;
		if (moneyTransfered > 0 && moneyTransfered < this.solde ) {
			this.retrait(moneyTransfered);
			destinataire.depot(moneyTransfered) ;
		}else {
			System.out.println("Rends l'AAARRGENT!") ;
		}

	}
}