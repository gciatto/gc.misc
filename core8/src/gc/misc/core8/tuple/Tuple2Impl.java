package gc.misc.core8.tuple;

import gc.misc.api.tuple.Tuple2;

/**
 * Created by gciatto on 19/03/16.
 */
class Tuple2Impl<A, B> extends Tuple1Impl<A> implements Tuple2<A, B> {

    public Tuple2Impl(A item1, B item2) {
        super(item1, item2);
    }

    protected Tuple2Impl(Object... items) {
        super(items);
    }

    @Override
    public B item2() {
        return cast(1);
    }

    @Override
    public boolean item2Matches(Class<? extends B> type) {
        return itemMatches(1, type);
    }

    @Override
    public boolean matches(Class<? extends A> type1, Class<? extends B> type2) {
        return matchesTypes(type1, type2);
    }
}
