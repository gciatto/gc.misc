package gc.misc.api.io.console;

import gc.misc.api.error.ErrorHandler;

import java.io.*;
import java.util.stream.Stream;

/**
 * Created by gciatto on 20/03/16.
 */
public final class Stdin {
    private static InputStream in = System.in;
    private static BufferedReader inr = new BufferedReader(new InputStreamReader(in));

    private Stdin() {
        throw new IllegalStateException();
    }

    public static int readChar() {
        return readChar(e -> {
            throw new UncheckedIOException(e);
        });
    }

    public static int readChar(ErrorHandler<? super IOException, Integer> errorHandler) {
        try {
            return inr.read();
        } catch (IOException e) {
            return errorHandler.apply(e);
        }
    }

    public static int readByte() {
        return readByte(e -> {
            throw new UncheckedIOException(e);
        });
    }

    public static int readByte(ErrorHandler<? super IOException, Integer> errorHandler) {
        try {
            return in.read();
        } catch (IOException e) {
            return errorHandler.apply(e);
        }
    }

    public static String readLine() {
        return readLine(e -> {
            throw new UncheckedIOException(e);
        });
    }

    public static String readLine(ErrorHandler<? super IOException, String> errorHandler) {
        try {
            return inr.readLine();
        } catch (IOException e) {
            return errorHandler.apply(e);
        }
    }

    public static Stream<String> lines() {
        return inr.lines();
    }
}
