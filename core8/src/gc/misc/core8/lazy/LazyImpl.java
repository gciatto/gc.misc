package gc.misc.core8.lazy;

import gc.misc.api.lazy.Lazy;
import gc.misc.api.meta.NonNull;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

import static java.util.Objects.requireNonNull;

/**
 * Created by gciatto on 19/03/16.
 */
class LazyImpl<T> implements Lazy<T> {

    private Optional<T> value = Optional.empty();
    private final Supplier<? extends T> supplier;

    LazyImpl(@NonNull Supplier<? extends T> supplier) {
        requireNonNull(supplier);
        this.supplier = supplier;
    }

    private synchronized T makeAvailableAndGet() {
        if (value.isPresent()) {

        } else {
            value = Optional.of(supplier.get());
        }
        return value.get();
    }

    private synchronized boolean checkAvailability() {
        return value.isPresent();
    }

    @Override
    public T get() {
        return makeAvailableAndGet();
    }

    @Override
    public boolean isPresent() {
        return checkAvailability();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lazy)) return false;
        Lazy<?> lazy = (Lazy<?>) o;
        return Objects.equals(get(), lazy.get());
    }

    @Override
    public int hashCode() {
        return Objects.hash(get());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Lazy[");
        sb.append(get());
        sb.append(']');
        return sb.toString();
    }
}
