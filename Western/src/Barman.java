
public class Barman extends Humans{
	
	private String barName ;  
	
	public Barman(String name) {
		super(name);
		super.favDrink = "vinasse";
	
	}
	public void service(Humans h) {
			System.out.println("Hey" + h.getName() + "Welcome Chez " + super.getName()+
					" \nTiens prends ça! un bon pti verre de "+ h.favDrink+ " mon coco!" );
	}	


}

	
	
	

