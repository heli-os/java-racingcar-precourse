package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author Heli
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CurrentPositionTest {

    @Test
    void 최초_생성_시_위치는_0_이다() {
        CurrentPosition currentPosition = new CurrentPosition();
        Assertions.assertThat(currentPosition.position()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7})
    void 인풋이_4_이상인_경우_경우_1칸_전진한다(int input) {
        CurrentPosition currentPosition = new CurrentPosition();
        CurrentPosition ongoing = currentPosition.ongoing(input);
        Assertions.assertThat(ongoing.position()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 인풋이_3_이하인_경우_경우_멈춘다(int input) {
        CurrentPosition currentPosition = new CurrentPosition();
        CurrentPosition ongoing = currentPosition.ongoing(input);
        Assertions.assertThat(ongoing.position()).isEqualTo(0);
    }

}
