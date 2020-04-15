
public class Main {

	public static void main (String [] args) {
	
		Animal animal = new Animal("Capucine",3);
		Animal animal2 = new Animal("Capucine",3);
		Animal anima2 = new Dog("paluch",6);
		Animal anima3 = new Wolf("èfdépé",15);
		
		Animal[] animals = new Animal[10]; 
		animals[0] = new Dog ("einc",4);
		animals[1] = new Wolf ("coincoin",2);
		animals[0].eat();
		animals[1].eat();
		anima3.eat();
	
//		for (int index = 0 ; index<animals.length ;index++) {
//			animals[index].eat();
//		}
		if (animal.equals(anima2)) {
			System.out.println("it's the same") ; 
		}else {
		 System.out.println("it's not the same") ;	
		}
	}
}