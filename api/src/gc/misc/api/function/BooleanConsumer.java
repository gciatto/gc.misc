package gc.misc.api.function;

import java.util.Objects;

/**
 * Created by gciatto on 19/03/16.
 */
@FunctionalInterface
public interface BooleanConsumer {
    void accept(boolean value);

    default BooleanConsumer andThen(BooleanConsumer after) {
        Objects.requireNonNull(after);
        return (boolean t) -> { accept(t); after.accept(t); };
    }
}
