package racingcar.infrastructure;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author Heli
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AppLoggerTest {

    @Test
    void 런타임_예외_클래스를_넘겨_예외를_만들_수_있다() {
        AppLogger logger = AppLogger.getLogger("test");
        assertThatThrownBy(() -> logger.error("메시지", IllegalArgumentException.class))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]메시지 (logger: test)");
    }

    @Test
    void Class_이름으로_로거를_만들_수_있다() {
        AppLogger logger = AppLogger.getLogger(this.getClass());
        assertThatThrownBy(() -> logger.error("메시지", IllegalArgumentException.class))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format("[ERROR]메시지 (logger: %s)", this.getClass().getName()));
    }
}
