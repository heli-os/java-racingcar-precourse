package racingcar.domain.game;

import racingcar.infrastructure.AppLogger;

import java.util.Arrays;

/**
 * @author Heli
 */
public class OngoingNumbers {

    private static final AppLogger logger = AppLogger.getLogger(OngoingNumbers.class);
    private static final int ONGOING_NUMBER_MIN = 0;
    private static final int ONGOING_NUMBER_MAX = 9;

    private final int[] ongoingNumbers;

    public OngoingNumbers(int... ongoingNumbers) {
        for (int ongoingNumber : ongoingNumbers) {
            validate(ongoingNumber);
        }
        this.ongoingNumbers = Arrays.copyOf(ongoingNumbers, ongoingNumbers.length);
    }

    public int get(int index) {
        if (this.ongoingNumbers.length == 0) {
            logger.error("ongoing number must be initialize", IllegalStateException.class);
        }

        return this.ongoingNumbers[index];
    }

    private void validate(int ongoingNumber) {
        if (ongoingNumber < ONGOING_NUMBER_MIN) {
            logger.error("ongoing number must be greater then or equals " + ONGOING_NUMBER_MIN, IllegalArgumentException.class);
        }
        if (ongoingNumber > ONGOING_NUMBER_MAX) {
            logger.error("ongoing number must be less then or equals " + ONGOING_NUMBER_MAX, IllegalArgumentException.class);
        }
    }
}
