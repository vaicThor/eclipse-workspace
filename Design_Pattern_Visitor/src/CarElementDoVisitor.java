
public class CarElementDoVisitor implements CarElementVisitor {

	  public void visit(Wheel wheel) {
	        System.out.println("verification de la roue "+ wheel.getName());
	    }

	    public void visit(Engine engine) {
	        System.out.println("Moteur récuré");
	    }

	    public void visit(Body body) {
	        System.out.println("Nettoyage de la carrosserie!");
	    }

	    public void visitCar(Car car) {
	        System.out.println("\n test du moteur");
	        for(CarElement carElement : car.getElements()) {
	            carElement.accept(this);
	        }
	        System.out.println("Premier test");
	    }
}
