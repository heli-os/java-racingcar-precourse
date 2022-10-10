package racingcar.domain.game;

import racingcar.domain.car.Cars;
import racingcar.infrastructure.port.inbound.StandardInput;
import racingcar.infrastructure.port.outbound.StandardOutput;

/**
 * @author Heli
 */
public class RacingCarGameContext {

    private Cars cars = Cars.empty();
    private RacingLap totalLap = RacingLap.zero();
    private RacingLap currentLap = RacingLap.zero();

    public void requestInputCarNames() {
        StandardOutput.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = StandardInput.readLine();
        this.cars = Cars.cars(inputCarNames);
    }

    public void requestInputTotalLap() {
        StandardOutput.println("시도할 횟수는 몇회인가요?");
        String inputTotalLap = StandardInput.readLine();
        this.totalLap = new RacingLap(inputTotalLap);
    }

    public void race() {
        OngoingNumbers ongoingNumbers = new OngoingNumbers()
                .addRandomNumbers(this.cars.size());

        this.cars = cars.ongoing(ongoingNumbers);
        this.currentLap = this.currentLap.incrementOne();
        this.cars.printState();
    }

    public void printWinners() {
        Cars winners = this.cars.winner();
        winners.printNames();
    }

    public RacingLap totalLap() {
        return this.totalLap;
    }

    public RacingLap currentLap() {
        return this.currentLap;
    }
}
