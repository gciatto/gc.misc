package gc.misc.api.vararg;

import gc.misc.api.meta.Static;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by gciatto on 19/03/16.
 */
public @Static class Vararg {
    private Vararg() {
        throw new IllegalArgumentException();
    }

    public static  <T> T[] toArray1(T arg0, T... args) {
        final Object[] newArray = new Object[args.length + 1];
        System.arraycopy(args, 0, newArray, 1, args.length);
        newArray[0] = arg0;
        return (T[]) newArray;
    }
}
