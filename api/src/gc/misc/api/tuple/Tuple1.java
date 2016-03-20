package gc.misc.api.tuple;

/**
 * Created by gciatto on 19/03/16.
 */
public interface Tuple1<A> extends Tuple {
    boolean matches(Class<? extends A> type1);

    A item1();
    boolean item1Matches(Class<? extends A> type);
}
