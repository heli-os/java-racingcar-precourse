package racingcar.domain.car;

/**
 * @author Heli
 */
public class CurrentPosition {

    private static final int ONGOING_CONDITION = 4;

    private final int position;

    public CurrentPosition() {
        this.position = 0;
    }

    private CurrentPosition(int position) {
        this.position = position;
    }

    public CurrentPosition ongoing(int ongoingInput) {
        if (ongoingInput >= ONGOING_CONDITION) {
            return new CurrentPosition(this.position + 1);
        }
        return this;
    }

    public int position() {
        return this.position;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append("-");
        }
        return builder.toString();
    }
}
