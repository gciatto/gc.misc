package gc.misc.api.lazy;

/**
 * Created by gciatto on 19/03/16.
 */
public interface LazyBoolean extends Lazy<Boolean> {
    boolean getAsBoolean();
}
