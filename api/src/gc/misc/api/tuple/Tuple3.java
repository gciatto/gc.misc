package gc.misc.api.tuple;

/**
 * Created by gciatto on 19/03/16.
 */
public interface Tuple3<A, B, C>  extends Tuple {
    boolean matches(Class<? extends A> type1, Class<? extends B> type2, Class<? extends C> type3);

    A item1();
    boolean item1Matches(Class<? extends A> type);

    B item2();
    boolean item2Matches(Class<? extends B> type);

    C item3();
    boolean item3Matches(Class<? extends C> type);
}
