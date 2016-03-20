package gc.misc.core8.lazy;

import gc.misc.api.lazy.Lazy;
import gc.misc.api.lazy.LazyInt;
import gc.misc.api.meta.NonNull;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.function.IntSupplier;

import static java.util.Objects.requireNonNull;

/**
 * Created by gciatto on 19/03/16.
 */
public class LazyIntImpl implements LazyInt {

    private OptionalInt value = OptionalInt.empty();
    private IntSupplier supplier;

    LazyIntImpl(@NonNull IntSupplier supplier) {
        requireNonNull(supplier);
        this.supplier = supplier;
    }

    private synchronized int makeAvailableAndGet() {
        if (value.isPresent()) {

        } else {
            value = OptionalInt.of(supplier.getAsInt());
        }
        return value.getAsInt();
    }

    private synchronized boolean checkAvailability() {
        return value.isPresent();
    }

    @Override
    public int getAsInt() {
        return makeAvailableAndGet();
    }

    @Override
    public Integer get() {
        return makeAvailableAndGet();
    }

    @Override
    public boolean isPresent() {
        return checkAvailability();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LazyInt)) return false;
        LazyInt lazy = (LazyInt) o;
        return Objects.equals(get(), lazy.get());
    }

    @Override
    public int hashCode() {
        return Objects.hash(get());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LazyInt[");
        sb.append(get());
        sb.append(']');
        return sb.toString();
    }
}
