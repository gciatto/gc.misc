package gc.misc.test.tuple;

import gc.misc.api.io.console.Stderr;
import gc.misc.api.io.console.Stdin;
import gc.misc.api.io.console.Stdout;
import gc.misc.api.tuple.Tuple;
import gc.misc.api.tuple.Tuple1;
import gc.misc.api.tuple.Tuple2;
import gc.misc.api.tuple.Tuple3;
import gc.misc.core8.tuple.Tuples;

/**
 * Created by gciatto on 19/03/16.
 */
public class TestTuples {

    static class A {
        @Override
        public String toString() {
            return "a";
        }
    }

    static class B extends A {
        @Override
        public String toString() {
            return "b";
        }
    }

    public static void main(String... args) {

        Tuple2<String, String> twoL = Tuples.of(Stdin.readLine(), Stdin.readLine());

        Stdout.println("lines: %s | %s", twoL.item1(), twoL.item2());
    }
}
