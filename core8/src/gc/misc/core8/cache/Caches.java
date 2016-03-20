package gc.misc.core8.cache;

import gc.misc.api.cache.Cache;
import gc.misc.api.meta.NonNull;

import java.util.function.Supplier;

/**
 * Created by gciatto on 19/03/16.
 */
public class Caches {
    public <T> Cache<T> of(@NonNull Supplier<T> supplier) {
        return new CacheImpl<>(supplier);
    }
}
