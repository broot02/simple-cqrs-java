package com.github.simplecqrsjava.core.events;

/**
 * Responsible for registering Events/Handlers for future usage. It is the responsibility of the calling library to provide implementations of this class,
 * there may be convenience libraries, but those implementations must be part of a separate library/jar.
 * This registry will allow dynamic of handlers based on the event provided, one handler will be provided for an event provided,
 * as such there is no guarantee that this one-to-one relationship will be maintained by the calling application, and that should be accounted for.
 * It might be a possibility to guarantee this in the future, but in current state this will not be guaranteed.
 */
public interface EventRegistry {

    /**
     * Retrieves the EventHandler for the given event.
     *
     * @param event - the event to be used to retrieve the handler
     * @param <T>     - concrete type of {@link Event}
     * @param <T2>    - concrete type of {@link EventHandler}
     * @return {@link EventHandler} which handles the provided event
     */
    <T extends Event<?>, T2 extends EventHandler<T>> T2 getEventHandler(T event);
}
