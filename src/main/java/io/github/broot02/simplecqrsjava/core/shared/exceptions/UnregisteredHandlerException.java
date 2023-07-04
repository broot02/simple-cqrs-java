package io.github.broot02.simplecqrsjava.core.shared.exceptions;

public class UnregisteredHandlerException extends RuntimeException {

    public UnregisteredHandlerException(Class<?> classType) {
        super(String.format("Handler for %s has not been registered", classType.getSimpleName()));
    }
}
