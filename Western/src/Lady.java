import java.util.*;
public class Lady extends Humans {
	
	// Attributes
	private String dressColor = "rouge" ;
	private boolean isFree ;
	/// Constructor
	public Lady(String name) {
		super(name) ;
		super.favDrink = "lait";
		this.introduceYrslf();
	}
	
	// Methods
	public String getDressColor() {
		return dressColor;
	}
	public boolean getIsFree() {
		return isFree;
	}
	public void setIsFree(boolean free) {
		this.isFree = free;
	}
	public void dispIsFree() {
		if (this.isFree == true) {
		System.out.println(super.getName() +"est libre");
		}
	}

	public void changeDress(String newColor) {
		this.dressColor = newColor ;
		System.out.println("Hey mon mignon, check moi cette nouvelle robe "+ newColor);
	}
				// Tir aléatoire pour savoir si la lady se fait capturer
	public boolean freeOrNot() {
	    Random randomFree = new Random();
		this.isFree = randomFree.nextBoolean();
		return this.isFree ;
	}
	@Override
	public void speak(String sentenceSpeakin) {
		System.out.println("Miss "+ super.getName() + ":"+ sentenceSpeakin) ;
	}
	public void introduceYrslf() {
		System.out.println("Salut, moi c'est Milady "+ super.getName()+  " et le" +
				super.getFavDrink()+" va super bien avec ma robe "+this.dressColor);	
	}

}	
