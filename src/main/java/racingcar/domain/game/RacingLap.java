package racingcar.domain.game;

import racingcar.infrastructure.AppLogger;

import java.util.Objects;

/**
 * @author Heli
 */
public class RacingLap {

    private static final AppLogger logger = AppLogger.getLogger(RacingLap.class);
    private static final RacingLap ZERO_LAP = new RacingLap(0);
    private static final String POSITIVE_NUMBER_REGEX = "^\\d+$";
    private static final String NUMBER_ZERO_AS_STRING = "0";
    private final int lap;

    private RacingLap(int lap) {
        this.lap = lap;
    }

    public RacingLap(String lap) {
        validate(lap);
        this.lap = Integer.parseInt(lap);
    }

    public static RacingLap zero() {
        return ZERO_LAP;
    }

    public RacingLap incrementOne() {
        return new RacingLap(this.lap + 1);
    }

    private void validate(String lap) {
        if (isEmpty(lap)) {
            logger.error("Racing Lap must not be empty or null");
        }
        if (!isPositiveNumber(lap)) {
            logger.error("Racing Lap must be greater then or equals 1");
        }
    }

    private boolean isEmpty(String lap) {
        return lap == null || lap.trim().length() == 0;
    }

    private boolean isPositiveNumber(String lap) {
        return lap.matches(POSITIVE_NUMBER_REGEX) && !NUMBER_ZERO_AS_STRING.equals(lap);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingLap racingLap = (RacingLap) o;
        return lap == racingLap.lap;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lap);
    }
}
