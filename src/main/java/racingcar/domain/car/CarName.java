package racingcar.domain.car;

import racingcar.infrastructure.AppLogger;

/**
 * @author Heli
 */
public class CarName {

    private static final AppLogger log = AppLogger.getLogger(CarName.class);

    private static final int MAX_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        validateName(name);
        this.name = name.trim();
    }

    private void validateName(String name) {
        if (isEmpty(name)) {
            log.error("car name must not be empty or null", IllegalArgumentException.class);
        }

        if (greaterThenMaxLength(name)) {
            log.error("length of car name must be less then or equals " + MAX_LENGTH, IllegalArgumentException.class);
        }
    }

    private boolean isEmpty(String name) {
        return name == null || name.trim().length() == 0;
    }

    private boolean greaterThenMaxLength(String name) {
        return name.trim().length() > MAX_LENGTH;
    }


    public String name() {
        return name;
    }
}
