package racingcar.domain.car;

/**
 * @author Heli
 */
public class Car implements Comparable<Car> {

    private final CarName name;
    private final CurrentPosition position;

    private Car(CarName name, CurrentPosition position) {
        this.name = name;
        this.position = position;
    }

    public static Car car(String name) {
        CarName carName = new CarName(name);
        CurrentPosition position = new CurrentPosition();
        return new Car(carName, position);
    }

    public Car ongoing(int ongoingInput) {
        CarName carName = new CarName(this.name.name());
        CurrentPosition position = this.position.ongoing(ongoingInput);
        return new Car(carName, position);
    }

    public String name() {
        return this.name.name();
    }

    public int position() {
        return this.position.position();
    }

    @Override
    public String toString() {
        return name.name() + " : " + position.toString();
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.position.position(), o.position.position());
    }
}
