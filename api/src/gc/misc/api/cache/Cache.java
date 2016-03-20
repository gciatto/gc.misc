package gc.misc.api.cache;

/**
 * Created by gciatto on 19/03/16.
 */
public interface Cache<T> {
    T get();
    void invalidate();
    void validate();
    boolean isValid();
}
