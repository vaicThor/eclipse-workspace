package com.constructordi;

public class Main {
	public static void main (String[] args) {
//		Ordinateur ordiPro = new Ordinateur() ;
//		ordiPro.brand= "Lenovo" ;
//		System.out.println("La marque de l'ordinateur est "+ ordiPro.brand) ;
//		ordiPro.ramMemorie = 8.0f ;
//		ordiPro.develop();
//		ordiPro.Ordinateur();
//		
//		
//		Ordinateur ordiPerso = new Ordinateur() ;
//		ordiPerso.brand = "Asus" ;
//		System.out.println("La marque de l'ordinateur est "+ ordiPerso.brand) ;		 ; 
//		ordiPerso.Ordinateur();
//		ordiPerso.playGame() ;
		
		B bi = new B() ;
		B b2 = new B(2018) ;
		B b3 = new B("Bonjour") ;
		System.out.println(bi.x+"et"+b2.x+"et encore" + b3.x);
	}

}
