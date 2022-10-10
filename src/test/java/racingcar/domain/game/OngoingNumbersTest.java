package racingcar.domain.game;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author Heli
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class OngoingNumbersTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void Ongoing_Numbers_생성_후_값을_가져올_수_있다(int input) {
        OngoingNumbers ongoingNumbers = new OngoingNumbers(input);

        assertThat(ongoingNumbers.get(0)).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3})
    void Ongoing_Number_는_0이상_이어야_한다(int input) {
        assertThatThrownBy(() -> new OngoingNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("ongoing number must be greater then or equals 0");
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 11, 12})
    void Ongoing_Number_는_9이하_이어야_한다(int input) {
        assertThatThrownBy(() -> new OngoingNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("ongoing number must be less then or equals 9");
    }


}
