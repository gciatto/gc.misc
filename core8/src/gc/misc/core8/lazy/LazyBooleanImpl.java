package gc.misc.core8.lazy;

import gc.misc.api.lazy.LazyBoolean;
import gc.misc.api.meta.NonNull;
import gc.misc.api.optional.OptionalBoolean;

import java.util.Objects;
import java.util.function.BooleanSupplier;

import static java.util.Objects.requireNonNull;

/**
 * Created by gciatto on 19/03/16.
 */
public class LazyBooleanImpl implements LazyBoolean {

    private OptionalBoolean value;
    private BooleanSupplier supplier;

    LazyBooleanImpl(@NonNull BooleanSupplier supplier) {
        requireNonNull(supplier);
        this.supplier = supplier;
    }

    private synchronized boolean makeAvailableAndGet() {
        if (value.isPresent()) {

        } else {
            value = OptionalBoolean.of(supplier.getAsBoolean());
        }
        return value.getAsBoolean();
    }
    private synchronized boolean checkAvailability() {
        return value.isPresent();
    }

    @Override
    public boolean getAsBoolean() {
        return makeAvailableAndGet();
    }

    @Override
    public Boolean get() {
        return makeAvailableAndGet();
    }

    @Override
    public boolean isPresent() {
        return checkAvailability();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LazyBoolean)) return false;
        LazyBoolean lazy = (LazyBoolean) o;
        return Objects.equals(get(), lazy.get());
    }

    @Override
    public int hashCode() {
        return Objects.hash(get());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LazyBoolean[");
        sb.append(get());
        sb.append(']');
        return sb.toString();
    }
}
