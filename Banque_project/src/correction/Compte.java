package correction;

public class Compte {
 private int idCompte ;
 private float solde = 200f;
 
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
	public int getIdCompte() {
		return idCompte;
	}
	public void virer(Compte destinataire, float moneyTransfered) {
		if (moneyTransfered > 0 && moneyTransfered < this.solde ) {
			this.retrait(moneyTransfered);
			destinataire.depot(moneyTransfered) ;
		}else {
			System.out.println("Rends l'AAARRGENT!") ;
		}
	}
	@Override
	public String toString() {
		return "le solde est de:"+solde+ " et l'IDcompte est: "+idCompte ;
	}
	// constructor
	public Compte (int nbCompte) {		
	}
}
