package com.constructordi;

public class Ordinateur {

	public String brand ;
	public short screen_size ;
	public boolean pad_num ;
	public float ramMemorie ;
	public boolean isPlaying ;
	
	// A voir pour ça!!
	public Ordinateur() { // Ceci est le constructeur est permet d'attribuer les valeurs par defaut
		this.isPlaying = true ;
		this.ramMemorie = 0.0f ;
	}
	// Bloc du dessus à revoir, un constructeur pas de void!!! 
	
	public void playGame () {
		if (this.isPlaying == true) {
			ramMemorie = ramMemorie - 3.0f ;
			System.out.println("La mémoire vive est de  "+ ramMemorie);
		}
		else {
			System.out.println("La mémoire vive est de  "+ ramMemorie);
		}
	
	}
	public void develop() {
		this.pad_num = true ;
		System.out.println("Le pad numérique est présent") ;
	}


		
	}
}
