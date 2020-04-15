
public class Dog extends Animal {

	public Dog (String name,int nbPattes) {
		super(name, nbPattes);		
	}
	@Override
	public void eat() {
		System.out.println("Je suis un "+this.name+" et je graille!");
	}
}
