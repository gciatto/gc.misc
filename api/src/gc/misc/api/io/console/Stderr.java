package gc.misc.api.io.console;

import gc.misc.api.vararg.Vararg;

import java.io.PrintStream;

/**
 * Created by gciatto on 20/03/16.
 */
public final class Stderr {

    private static PrintStream err = System.err;

    private Stderr() {
        throw new IllegalStateException();
    }

    public static boolean print(boolean b) {
        err.print(b);
        return b;
    }

    public static char print(char c) {
        err.print(c);
        return c;
    }

    public static double print(double d) {
        err.print(d);
        return d;
    }

    public static float print(float f) {
        err.print(f);
        return f;
    }

    public static int print(int i) {
        err.print(i);
        return i;
    }

    public static long print(long l) {
        err.print(l);
        return l;
    }

    public static <T> T print(T obj) {
        err.print(obj);
        return obj;
    }

    public static char[] print(char[] s) {
        err.print(s);
        return s;
    }

    public static String print(String s) {
        err.print(s);
        return s;
    }

    public static boolean println(boolean b) {
        err.println(b);
        return b;
    }

    public static char println(char c) {
        err.println(c);
        return c;
    }

    public static double println(double d) {
        err.println(d);
        return d;
    }

    public static float println(float f) {
        err.println(f);
        return f;
    }

    public static int println(int i) {
        err.println(i);
        return i;
    }

    public static long println(long l) {
        err.println(l);
        return l;
    }

    public static <T> T println(T obj) {
        err.println(obj);
        return obj;
    }

    public static char[] println(char[] s) {
        err.println(s);
        return s;
    }

    public static String println(String s) {
        err.println(s);
        return s;
    }

    public static void println() {
        err.println();
    }

    public static void println(String s, Object arg0, Object... args) {
        err.format(s, Vararg.toArray1(arg0, args)).println();
    }

    public static void print(String s, Object arg0, Object... args) {
        err.printf(s, Vararg.toArray1(arg0, args));
    }
}
