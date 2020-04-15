
public class Car {

    CarElement[] elements;

    public CarElement[] getElements() {
        return elements; // Retourne une copie du tableau de références
    }

    public Car() {
        this.elements = new CarElement[] {
                new Wheel("avant gauche"),
                new Wheel("avant droit"),
                new Wheel("arrière gauche"),
                new Wheel("arrière droit"),
                new Body(),
                new Engine()
            };
    }
}
