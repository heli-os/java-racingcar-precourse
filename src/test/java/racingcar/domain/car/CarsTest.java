package racingcar.domain.car;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.domain.game.OngoingNumbers;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Heli
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarsTest {

    @Test
    void 차_이름_묶음을_입력_받아_Cars_를_생성할_수_있다() {
        Cars cars = Cars.cars("Heli,  test,  abc");

        assertThat(cars.cars().get(0).name()).isEqualTo("Heli");
        assertThat(cars.cars().get(1).name()).isEqualTo("test");
        assertThat(cars.cars().get(2).name()).isEqualTo("abc");
    }

    @Test
    void OngoingNumbers_를_받아_차를_전진_할_수_있다() {
        OngoingNumbers ongoingNumbers = new OngoingNumbers(0, 4, 5);
        Cars cars = Cars.cars("Heli,  test,  abc")
                .ongoing(ongoingNumbers);

        assertThat(cars.cars().get(0).position()).isEqualTo(0);
        assertThat(cars.cars().get(1).position()).isEqualTo(1);
        assertThat(cars.cars().get(2).position()).isEqualTo(1);
    }

    @Test
    void car_의_수를_확인할_수_있다() {
        OngoingNumbers ongoingNumbers = new OngoingNumbers(0, 4, 5);
        Cars cars = Cars.cars("Heli,  test,  abc")
                .ongoing(ongoingNumbers);

        assertThat(cars.size()).isEqualTo(3);
    }
}
