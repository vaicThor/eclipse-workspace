import java.util.*;
public class Country{
	// Attributes
	private String theCountry ;
	
	
	// constructor
	
	public Country(String theCountry) {
		this.theCountry = theCountry ;
	}

	// Methods

	public String getName() {
		return theCountry;
	}
	public static Comparator<Country> countrySizeComparator = new Comparator <Country>() {
		public int compare(Country o1, Country o2) {
			return o1.getName().length() - o2.getName().length();
		}	
	};
	

	public static Comparator<Country> countryAlphabeticComparator = new Comparator<Country>() {
		@Override
		public int compare(Country o1, Country o2) { 
		o1.getName();
		o2.getName();
		return o1.getName().compareTo(o2.getName());
	}
	};
}
