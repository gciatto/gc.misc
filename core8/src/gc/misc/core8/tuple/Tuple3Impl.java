package gc.misc.core8.tuple;

import gc.misc.api.tuple.Tuple2;
import gc.misc.api.tuple.Tuple3;

/**
 * Created by gciatto on 19/03/16.
 */
class Tuple3Impl<A, B, C> extends Tuple2Impl<A, B> implements Tuple3<A, B, C> {

    public Tuple3Impl(A item1, B item2, C item3) {
        super(item1, item2, item3);
    }

    protected Tuple3Impl(Object... items) {
        super(items);
    }

    @Override
    public C item3() {
        return cast(2);
    }

    @Override
    public boolean item3Matches(Class<? extends C> type) {
        return itemMatches(2, type);
    }

    @Override
    public boolean matches(Class<? extends A> type1, Class<? extends B> type2, Class<? extends C> type3) {
        return matchesTypes(type1, type2, type3);
    }
}
