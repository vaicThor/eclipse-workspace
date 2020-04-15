
public class CarElementPrintVisitor implements CarElementVisitor{

    public void visit(Wheel wheel) {
        System.out.println("gonflage de la roue "+ wheel.getName());
    }

    public void visit(Engine engine) {
        System.out.println("Chauffe du moteur");
    }

    public void visit(Body body) {
        System.out.println("Réparation du bas d'caisse");
    }

    public void visitCar(Car car) {
        System.out.println("\nVoiture prête?");
        for(CarElement element : car.getElements()) {
            element.accept(this);
        }
        System.out.println("Départ!!");
    }
}
