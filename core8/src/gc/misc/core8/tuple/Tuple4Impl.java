package gc.misc.core8.tuple;

import gc.misc.api.tuple.Tuple4;

/**
 * Created by gciatto on 19/03/16.
 */
class Tuple4Impl<A, B, C, D> extends Tuple3Impl<A, B, C> implements Tuple4<A, B, C, D> {

    public Tuple4Impl(A item1, B item2, C item3) {
        super(item1, item2, item3);
    }

    protected Tuple4Impl(Object... items) {
        super(items);
    }

    @Override
    public D item4() {
        return cast(3);
    }

    @Override
    public boolean item4Matches(Class<? extends D> type) {
        return itemMatches(3, type);
    }

    @Override
    public boolean matches(Class<? extends A> type1, Class<? extends B> type2, Class<? extends C> type3, Class<? extends D> type4) {
        return matchesTypes(type1, type2, type3, type4);
    }
}
