
public class Wolf extends Animal {

	public Wolf (String name,int nbPattes) {
		super(name, nbPattes);
	}
	@Override
	public void eat() {
		System.out.println("Je suis un "+this.name+" et je graille!");
	}


}
