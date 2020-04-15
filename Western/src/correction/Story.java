package correction;

public class Story {

	public static void main(String[] args) {
	
		Cowboy clintCowboy  = new Sheriff("Clint");
		Sheriff clintSheriff = (Sheriff) clintCowboy ;
		clintSheriff.arrest() ;
		((Sheriff)clintSheriff).arrest(thug);
		

	}

}
