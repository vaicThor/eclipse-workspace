package com.amap;

public class Basket {
	
	
	// Attributes
	public String name ;
	public float price ;
	public char size ; 
	public String[] vegetables ;
	public String[] fruits ;
	public int nbProducts ;
	public int nbVegetables ;
	public int nbFruits ;
	
	// Constructor!
	public Basket(String name, char size) {
		this.name = name ;
		this.size = size ;
		//If size == S then 10
		if (size =='S') {
			this.nbProducts = 10 ;
		//If size == M then 20
		}else if (size == 'M') {
			this.nbProducts = 20 ;
		//If size == L then 30
		}else if (size == 'L') {
			this.nbProducts = 30 ;
		} else {
			System.out.println("Wrong charactere for the size") ;
		}
		this.nbVegetables = 0;	
		this.nbFruits = 0 ;	
		this.vegetables = new String[nbProducts/2] ;
		this.fruits = new String[nbProducts/2] ;
	}


	// Methods
	public void addVegetables(String vegetableName) {
		this.vegetables[this.nbVegetables] = vegetableName ;
		this.nbVegetables++ ;
	}
	
	public void addFruit(String fruitName) {
		this.fruits[this.nbFruits] = fruitName ;
		this.nbFruits++ ;
		
	}
	
	public void displayInformations() {
		System.out.println("##############");		
		System.out.println("Name : "+ this.name);
		System.out.println("Price : "+ this.price + "$");
		System.out.println("Size : "+ this.size);
		System.out.println("############## \n");	
		this.displayVegetables();
		this.displayFruits();
		
	}
		// TODO : 2020-01-20 (display all product)
		
	public void displayVegetables() {
	  if (this.nbVegetables>0) {
		  System.out.println("There are "+ nbVegetables + "vegetrables") ;
	  
		for (int i=0 ; i<= nbVegetables-1;i++) {
		System.out.println("The vegetables is : " + this.vegetables[i]) ;
	    }
	  }else {
		  System.out.println("There is No vegetables boloss!") ;
	  }
	}
	public void displayFruits() {
		  if (this.nbFruits>0) {
			  System.out.println("There are "+ nbFruits + "fruits ") ;
		  
				for (int i=0 ; i<= nbFruits-1;i++) {
					System.out.println("The fruits is : " + this.fruits[i]) ;
				}
		  }else {
			  System.out.println("There is No fruits boloss!") ;
		  }
	}
			
}
	
