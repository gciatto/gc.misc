package gc.misc.api.optional;

import gc.misc.api.function.BooleanConsumer;

import java.util.NoSuchElementException;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

/**
 * Created by gciatto on 19/03/16.
 */
public final class OptionalBoolean {
    private static final OptionalBoolean EMPTY = new OptionalBoolean();
    private static final OptionalBoolean TRUE = new OptionalBoolean(true);
    private static final OptionalBoolean FALSE = new OptionalBoolean(false);

    private final boolean isPresent;
    private final boolean value;

    private OptionalBoolean() {
        this.isPresent = false;
        this.value = false;
    }

    public static OptionalBoolean empty() {
        return EMPTY;
    }

    private OptionalBoolean(boolean value) {
        this.isPresent = true;
        this.value = value;
    }

    public static OptionalBoolean of(boolean value) {
        return value ? TRUE : FALSE;
    }

    public boolean getAsBoolean() {
        if (!isPresent) {
            throw new NoSuchElementException("No value present");
        }
        return value;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void ifPresent(BooleanConsumer consumer) {
        if (isPresent)
            consumer.accept(value);
    }

    public boolean orElse(boolean other) {
        return isPresent ? value : other;
    }

    public boolean orElseGet(BooleanSupplier other) {
        return isPresent ? value : other.getAsBoolean();
    }

    public<X extends Throwable> boolean orElseThrow(Supplier<X> exceptionSupplier) throws X {
        if (isPresent) {
            return value;
        } else {
            throw exceptionSupplier.get();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (!(obj instanceof OptionalBoolean)) {
            return false;
        }
        
        OptionalBoolean other = (OptionalBoolean) obj;
        return (isPresent && other.isPresent)
                       ? value == other.value
                       : isPresent == other.isPresent;
    }

    @Override
    public int hashCode() {
        return isPresent ? Boolean.hashCode(value) : 0;
    }

    @Override
    public String toString() {
        return isPresent
                       ? String.format("OptionalBoolean[%s]", value)
                       : "OptionalBoolean.empty";
    }
}
