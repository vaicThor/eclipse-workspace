
public class Car {

    CarElement[] elements;

    public CarElement[] getElements() {
        return elements; // Retourne une copie du tableau de r�f�rences
    }

    public Car() {
        this.elements = new CarElement[] {
                new Wheel("avant gauche"),
                new Wheel("avant droit"),
                new Wheel("arri�re gauche"),
                new Wheel("arri�re droit"),
                new Body(),
                new Engine()
            };
    }
}
