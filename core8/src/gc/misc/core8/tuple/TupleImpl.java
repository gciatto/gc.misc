package gc.misc.core8.tuple;

import gc.misc.api.lazy.Lazy;
import gc.misc.api.meta.NonNull;
import gc.misc.api.meta.Nullable;
import gc.misc.api.tuple.Tuple;
import gc.misc.core8.lazy.Lazies;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Created by gciatto on 19/03/16.
 */
class TupleImpl implements Tuple {

    private final Object[] data;
    private final Lazy<List<?>> view; // = Lazies.of(() -> Collections.unmodifiableList(data));

    public TupleImpl(@NonNull Object... data) {
        Objects.requireNonNull(data);
        this.data = data;
        this.view = Lazies.of(
                () -> Collections.unmodifiableList(
                        Arrays.asList(data)
                    )
            );
    }

    @Override
    public int size() {
        return data.length;
    }

    protected boolean matchesTypes(@NonNull Class<?>... types) {
        Objects.requireNonNull(types);
        if (types.length != data.length) {
            return false;
        } else {
            for (int i = 0; i < types.length; i++) {
                if (objectMatchesType(data[i], types[i]))
                    continue;
                else
                    return false;
            }

            return true;
        }
    }

    private boolean objectMatchesType(@Nullable Object object, @Nullable Class<?> type) {
        if (object == null || type == null) {
            return true;
        } else {
            return type.isAssignableFrom(object.getClass());
        }
    }

    @Override
    public boolean itemMatches(int index, Class<?> type) {
        return objectMatchesType(data[index], type);
    }

    @Override
    public Object get(int index) {
        return data[index];
    }

    @Override
    public <C> C cast(int index) {
        return (C) data[index];
    }

    @Override
    public List<?> asList() {
        return view.get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tuple)) return false;
        Tuple tuple = (Tuple) o;
        return asList().equals(tuple.asList());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("(");
        sb.append(data[0]);
        for (int i = 1; i < data.length; i++) {
            sb.append(", ").append(data[i]);
        }
        sb.append(")");
        return sb.toString();
    }
}
