
public class Story {
	public static void main (String [] args) {
		Humans benjam = new Humans ("Benjam") ;
		benjam.setFavDrink("skaï") ;
		benjam.introduceYrslf();
	
		Brigands rob = new Brigands("Rob") ;
		 rob.setFavDrink("champ");
		
		Lady prissou = new Lady("Priscila") ;
		Cowboy james = new Cowboy("james");
		james.hitBrigand(rob);
		james.introduceYrslf();
		prissou.introduceYrslf();
		Barman jojo = new Barman("jojo") ;
		jojo.service(prissou);
		Sheriff woody = new Sheriff("Woody");
		woody.introduceYrslf();
		Cowboy bill = new Sheriff("Bill");
		bill.introduceYrslf();
	}
}
