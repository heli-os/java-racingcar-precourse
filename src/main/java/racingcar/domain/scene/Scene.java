package racingcar.domain.scene;

import racingcar.domain.game.RacingCarGameContext;

/**
 * @author Heli
 */
public abstract class Scene implements SceneInterface {

    protected final RacingCarGameContext context;

    public Scene(RacingCarGameContext context) {
        this.context = context;
    }
}
