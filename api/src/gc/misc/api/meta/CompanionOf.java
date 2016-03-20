package gc.misc.api.meta;

import java.lang.annotation.*;

/**
 * Created by gciatto on 19/03/16.
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
public @interface CompanionOf {
    Class<?> value();
}
