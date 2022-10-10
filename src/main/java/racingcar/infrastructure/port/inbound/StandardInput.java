package racingcar.infrastructure.port.inbound;

import camp.nextstep.edu.missionutils.Console;

import javax.naming.OperationNotSupportedException;

/**
 * @author Heli
 */
public class StandardInput {

    private StandardInput() throws OperationNotSupportedException {
        throw new OperationNotSupportedException("can not supported initiate Instance.");
    }

    public static String readLine() {
        return Console.readLine();
    }
}
