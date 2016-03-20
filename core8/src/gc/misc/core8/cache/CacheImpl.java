package gc.misc.core8.cache;

import gc.misc.api.cache.Cache;
import gc.misc.api.meta.NonNull;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Created by gciatto on 19/03/16.
 */
class CacheImpl<T> implements Cache<T> {

    private Optional<T> value = Optional.empty();
    private Supplier<? extends T> supplier;

    public CacheImpl(@NonNull Supplier<? extends T> supplier) {
        Objects.requireNonNull(supplier);
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

    private synchronized void clearAvailability() {
        value = Optional.empty();
    }


    @Override
    public T get() {
        return makeAvailableAndGet();
    }

    @Override
    public void invalidate() {
        clearAvailability();
    }

    @Override
    public void validate() {
        makeAvailableAndGet();
    }

    @Override
    public boolean isValid() {
        return checkAvailability();
    }
}
