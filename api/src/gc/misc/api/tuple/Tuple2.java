package gc.misc.api.tuple;

/**
 * Created by gciatto on 19/03/16.
 */
public interface Tuple2<A, B>  extends Tuple {
    boolean matches(Class<? extends A> type1, Class<? extends B> type2);

    A item1();
    boolean item1Matches(Class<? extends A> type);

    B item2();
    boolean item2Matches(Class<? extends B> type);
}
