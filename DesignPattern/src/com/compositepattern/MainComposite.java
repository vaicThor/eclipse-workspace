package com.compositepattern;

public class MainComposite {

	public static void main(String[] args) {
		
		PrimeMinister edouard 	= new PrimeMinister();
		HealthMinister santéMi 	= new HealthMinister();
		MinistreOfHealth oliv	= new MinistreOfHealth();
		HealthSecretary coin 	= new HealthSecretary();
		HospitalPublicDirector coco = new HospitalPublicDirector();
		ChefHospital lolo = new ChefHospital();
				
		System.out.println(santéMi.getBudgetTotal()); 

	}

}
