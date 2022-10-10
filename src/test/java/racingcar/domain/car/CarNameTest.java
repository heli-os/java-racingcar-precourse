package racingcar.domain.car;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Heli
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {" Heli ", "Heli ", "      Heli"})
    void 이름_저장_시_앞_뒤_공백을_제거한다(String input) {
        CarName carName = new CarName(input);
        assertThat(carName.name()).isEqualTo("Heli");
    }
}
