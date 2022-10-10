package racingcar.domain.car;

import racingcar.domain.game.OngoingNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heli
 */
public class Cars {

    private static final String CAR_NAME_DELIMITER = ",";

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

    public Cars ongoingCars(OngoingNumbers ongoingNumbers) {
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
}
