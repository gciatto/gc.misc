package gc.misc.api.lazy;

/**
 * Created by gciatto on 19/03/16.
 */
public interface Lazy<T> {
    T get();
    boolean isPresent();
}
