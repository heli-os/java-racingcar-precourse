package racingcar.infrastructure.port.inbound;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Constructor;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author Heli
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StandardInputTest {
    @Test
    void StandardInput_인스턴스는_만들_수_없다() {
        Class<StandardInput> standardInputClass = StandardInput.class;
        Constructor<?>[] declaredConstructors = standardInputClass.getDeclaredConstructors();

        Assertions.assertThat(declaredConstructors).hasSize(1);

        Constructor<?> declaredConstructor = declaredConstructors[0];
        declaredConstructor.setAccessible(true);
        Assertions.assertThat(declaredConstructor.getParameterCount()).isEqualTo(0);

        assertThatThrownBy(declaredConstructor::newInstance)
                .hasCauseInstanceOf(OperationNotSupportedException.class)
                .hasStackTraceContaining("can not supported initiate Instance.");
    }
}
