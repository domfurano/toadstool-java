package toadstool;

import java.util.function.Function;

@FunctionalInterface
interface ThrowingFunction<T, R> extends Function<T, R> {

    @Override
    default R apply(final T elem) {
        try {
            return applyThrows(elem);
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    R applyThrows(T elem) throws Exception;
}