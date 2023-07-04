package io.github.broot02.simplecqrsjava.core.behaviors;

public interface Behavior<T> {

    default int getOrder() {
        return 0;
    }

    default boolean shouldExecute(T object) {
        return true;
    }

    void handle(T object);
}
