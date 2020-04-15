
public class MainVisitor {

	public static void main(String[] args) {
        Car car = new Car();

        CarElementVisitor printVisitor = new CarElementPrintVisitor();
        CarElementVisitor doVisitor = new CarElementDoVisitor();

        doVisitor.visitCar(car);
        printVisitor.visitCar(car);
        

	}

}
