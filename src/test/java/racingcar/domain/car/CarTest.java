package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Heli
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"heli", "four", "five_", "hello"})
    public void 자동차_생성_시_위치는_0이다(String input) {
        Car car = Car.car(input);

        assertThat(car.name()).isEqualTo(input);
        assertThat(car.position()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"heli:4", "hello:5"}, delimiter = ':')
    public void 자동차_이동_가능(String name, int ongoingCount) {
        Car car = Car.car(name)
                .ongoing(ongoingCount);
        assertThat(car.position()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"heli:3", "hello:2"}, delimiter = ':')
    public void 자동차_이동_불가(String name, int ongoingCount) {
        Car car = Car.car(name)
                .ongoing(ongoingCount);
        assertThat(car.position()).isEqualTo(0);
    }

    @Test
    void toString_시_차_이름과_현재_위치를_표시한다() {
        Car car = Car.car("heli")
                .ongoing(9)
                .ongoing(9)
                .ongoing(9);
        Assertions.assertThat(car.toString()).isEqualTo("heli : ---");
    }
}
