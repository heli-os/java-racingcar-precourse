package racingcar.domain.car;

import racingcar.domain.game.OngoingNumbers;
import racingcar.infrastructure.port.outbound.StandardOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Heli
 */
public class Cars {

    private static final String CAR_NAME_DELIMITER = ",";
    private static final Cars EMPTY_CARS = new Cars(Collections.emptyList());

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars cars(String carNames) {
        String[] carNameArr = carNames.split(CAR_NAME_DELIMITER);

        List<Car> cars = new ArrayList<>(carNameArr.length);
        for (String carName : carNameArr) {
            cars.add(Car.car(carName));
        }
        return new Cars(cars);
    }

    public static Cars empty() {
        return EMPTY_CARS;
    }

    public Cars ongoing(OngoingNumbers ongoingNumbers) {
        int carsSize = this.cars.size();
        List<Car> accumulateCars = new ArrayList<>(carsSize);
        for (int i = 0; i < carsSize; i++) {
            Car car = this.cars.get(i);
            int ongoingNumber = ongoingNumbers.get(i);
            accumulateCars.add(car.ongoing(ongoingNumber));
        }
        return new Cars(accumulateCars);
    }

    public List<Car> cars() {
        return this.cars;
    }

    public void printState() {
        for (Car car : cars()) {
            StandardOutput.println(car);
        }
        StandardOutput.println("\n");
    }

    public void printNames() {
        List<String> carNames = new ArrayList<>();
        for (Car car : cars()) {
            carNames.add(car.name());
        }
        StandardOutput.println(String.format("최종 우승자 : %s", String.join(CAR_NAME_DELIMITER, carNames)));
    }

    public int size() {
        if (this.cars == null || this.cars.isEmpty()) {
            return 0;
        }
        return this.cars.size();
    }

    public Cars winner() {
        Cars sortedCars = sortedCars();
        Car previousWinner = sortedCars.cars.get(0);

        List<Car> winners = new ArrayList<>();
        for (Car car : sortedCars.cars()) {
            addToWinnersWhenSamePosition(car, previousWinner, winners);
        }
        return new Cars(winners);
    }

    private void addToWinnersWhenSamePosition(Car current, Car previous, List<Car> winners) {
        if (current.position() == previous.position()) {
            winners.add(current);
        }
    }

    private Cars sortedCars() {
        List<Car> copiedList = new ArrayList<>(this.cars);
        copiedList.sort(Collections.reverseOrder());
        return new Cars(copiedList);
    }
}
