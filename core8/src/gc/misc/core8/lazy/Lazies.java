package gc.misc.core8.lazy;

import gc.misc.api.lazy.Lazy;
import gc.misc.api.lazy.LazyBoolean;
import gc.misc.api.lazy.LazyInt;
import gc.misc.api.meta.CompanionOf;
import gc.misc.api.meta.NonNull;
import gc.misc.api.meta.Static;

import java.util.OptionalInt;
import java.util.function.BooleanSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/**
 * Created by gciatto on 19/03/16.
 */
@CompanionOf(value = Lazies.class)
public @Static class Lazies {
    private Lazies() {
        throw new IllegalStateException();
    }

    public static <T> Lazy of(@NonNull Supplier<? extends T> supplier) {
        return new LazyImpl<>(supplier);
    }

    public static LazyInt of(@NonNull IntSupplier supplier) {
        return new LazyIntImpl(supplier);
    }

    public static LazyBoolean of(@NonNull BooleanSupplier supplier) {
        return new LazyBooleanImpl(supplier);
    }
}
