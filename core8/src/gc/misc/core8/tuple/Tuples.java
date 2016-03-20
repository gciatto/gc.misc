package gc.misc.core8.tuple;

import gc.misc.api.meta.CompanionOf;
import gc.misc.api.meta.Nullable;
import gc.misc.api.meta.Static;
import gc.misc.api.tuple.*;

/**
 * Created by gciatto on 19/03/16.
 */
@CompanionOf(value = Tuple.class)
public @Static class Tuples {

    private Tuples() {
        throw new IllegalArgumentException();
    }

    public static <A> Tuple1<A> of(@Nullable A value) {
        return new Tuple1Impl<>(value);
    }

    public static <A, B> Tuple2<A, B> of(@Nullable A item1, @Nullable B item2) {
        return new Tuple2Impl<>(item1, item2);
    }

    public static <A, B, C> Tuple3 of(@Nullable A item1, @Nullable B item2, @Nullable C item3) {
        return new Tuple3Impl<>(item1, item2, item3);
    }

    public static <A, B, C, D> Tuple4 of(@Nullable A item1, @Nullable B item2, @Nullable C item3, @Nullable D item4) {
        return new Tuple4Impl<>(item1, item2, item3, item4);
    }
}
