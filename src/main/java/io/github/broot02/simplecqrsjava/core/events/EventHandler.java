package io.github.broot02.simplecqrsjava.core.events;

/**
 * Responsible for performing some operation with the event, this type of handler is more open-ended and can be utilized to trigger other actions, but there is no result to be returned.
 * A good rule of thumb is that these event handlers are intended for handling a "side effect" of this event occurring.
 *
 * @param <T> - The specific event to be handled by this handler, typically this should contain all the data which the handler needs to execute its action.
 */
public interface EventHandler<T extends Event<?>> {

    /**
     * Handles the specific event provided, will take the requested event, and perform "an" operation,
     * typically a side effect in nature, that could result in some task that you do not want tightly coupled with the command handling.
     *
     * @param event - represents the data needed to perform the operation based on the handler implementation
     */
    void handle(T event);
}
