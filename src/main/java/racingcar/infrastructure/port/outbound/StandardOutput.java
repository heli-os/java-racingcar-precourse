package racingcar.infrastructure.port.outbound;

import javax.naming.OperationNotSupportedException;

/**
 * @author Heli
 */
public class StandardOutput {

    private StandardOutput() throws OperationNotSupportedException {
        throw new OperationNotSupportedException("can not supported initiate Instance.");
    }

    public static void print(final Object message) {
        System.out.print(message);
    }

    public static void println(final Object message) {
        System.out.println(message);
    }
}
