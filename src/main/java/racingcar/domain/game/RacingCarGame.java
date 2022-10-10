package racingcar.domain.game;

import racingcar.domain.scene.InputCarNames;
import racingcar.domain.scene.Scene;

/**
 * @author Heli
 */
public class RacingCarGame {

    private final RacingCarGameContext context = new RacingCarGameContext();
    private Scene scene = new InputCarNames(context);

    public void start() {
        while (scene.playable()) {
            this.scene = scene.play();
        }
        context.printWinners();
    }
}
