package gc.misc.api.tuple;

import java.util.List;

/**
 * Created by gciatto on 19/03/16.
 */
public interface Tuple {
    int size();

    //boolean matches(Class<?>... types);

    boolean itemMatches(int index, Class<?> type);

    Object get(int index);

    <C> C cast(int index);

    List<?> asList();

}
