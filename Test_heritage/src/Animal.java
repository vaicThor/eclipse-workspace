
public abstract class Animal {
	protected int nbPattes ;
	protected String name ;
	
	public Animal (String name, int nbPattes) {
		this.name = name ;
		this.nbPattes = nbPattes ;
	}
	public void eat() {
	}
	@Override
	public boolean equals(Object objToCompare) {
		Animal animalToCompare = (Animal) objToCompare ;
		return this.name.equals(animalToCompare.name) &&
			   this.nbPattes == animalToCompare.nbPattes ;
	}
}
