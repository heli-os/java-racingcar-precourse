package racingcar.infrastructure;

import racingcar.infrastructure.port.outbound.StandardOutput;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Heli
 */
public class AppLogger {

    private static final String ERROR_PREFIX = "[ERROR]";
    private final String loggerName;

    private AppLogger(String loggerName) {
        this.loggerName = loggerName;
    }

    public static AppLogger getLogger(String loggerName) {
        return new AppLogger(loggerName);
    }

    public static AppLogger getLogger(Class<?> loggerName) {
        return new AppLogger(loggerName.getName());
    }

    public void error(String message, Class<? extends RuntimeException> exceptionClass) {
        try {
            Constructor<? extends RuntimeException> declaredConstructor = exceptionClass.getDeclaredConstructor(String.class);
            String log = String.format("%s%s (logger: %s)", ERROR_PREFIX, message, loggerName);
            error(log);
            throw declaredConstructor.newInstance(log);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException ignored) {
            // ignored
        }
    }

    public void error(String message) {
        String log = String.format("%s%s", ERROR_PREFIX, message);
        StandardOutput.println(log);
    }
}

