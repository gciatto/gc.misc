package gc.misc.core8.tuple;

import gc.misc.api.tuple.Tuple1;
/**
 * Created by gciatto on 19/03/16.
 */
class Tuple1Impl<A> extends TupleImpl implements Tuple1<A> {

    public Tuple1Impl(A item1) {
        super(item1);
    }

    protected Tuple1Impl(Object... items) {
        super(items);
    }

    @Override
    public A item1() {
        return cast(0);
    }

    @Override
    public boolean item1Matches(Class<? extends A> type) {
        return itemMatches(0, type);
    }

    @Override
    public boolean matches(Class<? extends A> type1) {
        return matchesTypes(type1);
    }
}
