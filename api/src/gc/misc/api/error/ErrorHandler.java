package gc.misc.api.error;

import java.util.function.Function;

/**
 * Created by gciatto on 20/03/16.
 */
@FunctionalInterface
public interface ErrorHandler<X extends Throwable, R> extends Function<X, R> {

}
