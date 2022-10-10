package racingcar.domain.scene;

import racingcar.domain.game.RacingCarGameContext;

/**
 * @author Heli
 */
public class Race extends Scene {

    public Race(RacingCarGameContext context) {
        super(context);
    }

    @Override
    public Scene play() {
        context.race();
        return new Race(context);
    }

    @Override
    public boolean playable() {
        return !context.currentLap().equals(context.totalLap());
    }
}
