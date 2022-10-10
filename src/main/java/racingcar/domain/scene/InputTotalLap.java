package racingcar.domain.scene;

import racingcar.domain.game.RacingCarGameContext;

/**
 * @author Heli
 */
public class InputTotalLap extends Scene {


    public InputTotalLap(RacingCarGameContext context) {
        super(context);
    }

    @Override
    public Scene play() {
        context.requestInputTotalLap();
        return new Race(context);
    }

    @Override
    public boolean playable() {
        return true;
    }
}
