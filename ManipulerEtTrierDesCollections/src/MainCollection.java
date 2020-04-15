import java.util.*;

public class MainCollection  {

	public static void main(String[] args) throws ListEmptyException {
		
		
		
		List<Country> allCountries = new ArrayList<Country>();

		
		Country france = new Country("France");
		Country espagne = new Country("Espagne");
		Country mongolie = new Country("Mongolie");
		Country kurdistan = new Country("Kurdistan");
		Country liban = new Country("Liban");
		allCountries.add(france);
		allCountries.add(espagne);
		allCountries.add(mongolie);
		allCountries.add(kurdistan);
		allCountries.add(liban);
///// Option
//  allCountries = Arrays.asList(france, belgique,...) 		
//////////////////////////////////////////////////////////////////	
		displayCountries(allCountries);
// allCountries.clear() ;

		
		// Question d
		Country finlande = new Country("Finlande");
		allCountries.add(0,finlande);
		displayCountries(allCountries);
		
	// 	Methode static donc fonction de Collections, permet de trier par ordre alphabétique
		Collections.sort(allCountries, Country.countryAlphabeticComparator) ;
		displayCountries(allCountries);
	// 	Methode static donc fonction de Collections, permet de trier par ordre de taille de mot
		Collections.sort(allCountries, Country.countrySizeComparator);
		displayCountries(allCountries);
	
		allCountries.clear();

		try {
			displayCountries(allCountries);
		}catch (ListEmptyException e) {
			
		}
		
	
	
	
	}
		
	
	
	
public static void displayCountries(List<Country> countryList) throws ListEmptyException {
	if (countryList.isEmpty()) {
		throw new ListEmptyException();
	}
	
		System.out.println("There are "+ countryList.size()+" Countries in the collection ");
		
		for (Iterator<Country> iterator = countryList.iterator();
		iterator.hasNext();) {
			Country country = iterator.next();
			System.out.println(country.getName());
		}
}
}