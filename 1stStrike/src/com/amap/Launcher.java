package com.amap;

public class Launcher {
	public static void main (String[] args) {
	System.out.println("Welcome to AMAP") ;
	
	Basket basket1 = new Basket("Détox",'S') ;
	basket1.addVegetables("Topinambourg");
	basket1.addVegetables("Carotte");
	basket1.displayInformations();
	
	Basket basket2 = new Basket("Energétique",'L') ;
	basket2.addFruit("coin");
	basket2.addFruit("Pomme");
	basket2.displayInformations();
	}






}
