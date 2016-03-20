package gc.misc.api.io.console;

import gc.misc.api.vararg.Vararg;

import java.io.PrintStream;

/**
 * Created by gciatto on 20/03/16.
 */
public final class Stdout {

    private static PrintStream out = System.out;

    private Stdout() {
        throw new IllegalStateException();
    }

    public static boolean print(boolean b) {
        out.print(b);
        return b;
    }

    public static char print(char c) {
        out.print(c);
        return c;
    }

    public static double print(double d) {
        out.print(d);
        return d;
    }

    public static float print(float f) {
        out.print(f);
        return f;
    }

    public static int print(int i) {
        out.print(i);
        return i;
    }

    public static long print(long l) {
        out.print(l);
        return l;
    }

    public static <T> T print(T obj) {
        out.print(obj);
        return obj;
    }

    public static char[] print(char[] s) {
        out.print(s);
        return s;
    }

    public static String print(String s) {
        out.print(s);
        return s;
    }

    public static boolean println(boolean b) {
        out.println(b);
        return b;
    }

    public static char println(char c) {
        out.println(c);
        return c;
    }

    public static double println(double d) {
        out.println(d);
        return d;
    }

    public static float println(float f) {
        out.println(f);
        return f;
    }

    public static int println(int i) {
        out.println(i);
        return i;
    }

    public static long println(long l) {
        out.println(l);
        return l;
    }

    public static <T> T println(T obj) {
        out.println(obj);
        return obj;
    }

    public static char[] println(char[] s) {
        out.println(s);
        return s;
    }

    public static String println(String s) {
        out.println(s);
        return s;
    }

    public static void println() {
        out.println();
    }

    public static void println(String s, Object arg0, Object... args) {
        out.format(s, Vararg.toArray1(arg0, args)).println();
    }

    public static void print(String s, Object arg0, Object... args) {
        out.printf(s, Vararg.toArray1(arg0, args));
    }
}
