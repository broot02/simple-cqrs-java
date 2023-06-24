package io.github.broot02.simplecqrsjava.core.commands;

/**
 * Commands represent data that is needed to perform some operation, typically a mutative operation.
 * The Command is tied to a specific Response type, this must align with the handler.
 * @param <R> Type that is expected to be returned based on the completion of the command
 */
@SuppressWarnings("unused")
public interface Command<R> {
}
