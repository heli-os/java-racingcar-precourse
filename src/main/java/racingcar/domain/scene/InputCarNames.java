package racingcar.domain.scene;

import racingcar.domain.game.RacingCarGameContext;

/**
 * @author Heli
 */
public class InputCarNames extends Scene {

    public InputCarNames(RacingCarGameContext context) {
        super(context);
    }

    @Override
    public Scene play() {
        context.requestInputCarNames();
        return new InputTotalLap(context);
    }

    @Override
    public boolean playable() {
        return true;
    }
}
