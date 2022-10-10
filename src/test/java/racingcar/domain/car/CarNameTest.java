package racingcar.domain.car;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author Heli
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"123456", "abcdef"})
    void 다섯글자_초과_시_예외가_발생한다(String input) {
        assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("length of car name must be less then or equals 5");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "    "})
    void 빈_값_전달_시_예외가_발생한다(String input) {
        assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("car name must not be empty or null");

    }

    @ParameterizedTest
    @NullSource
    void null_전달_시_예외가_발생한다(String nullInput) {
        assertThatThrownBy(() -> new CarName(nullInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("car name must not be empty or null");
    }

    @ParameterizedTest
    @ValueSource(strings = {" Heli ", "Heli ", "      Heli"})
    void 이름_저장_시_앞_뒤_공백을_제거한다(String input) {
        CarName carName = new CarName(input);
        assertThat(carName.name()).isEqualTo("Heli");
    }
}
