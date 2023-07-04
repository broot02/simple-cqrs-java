package io.github.broot02.simplecqrsjava.core.events;

import java.util.List;

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
     * @param <T>   - concrete type of {@link Event}
     * @param <T2>  - concrete type of {@link EventHandler}
     * @return {@link EventHandler} which handles the provided event
     */
    <T extends Event<?>, T2 extends EventHandler<T>> T2 getEventHandler(T event);

    /**
     * Retrieves the EventBehaviors for the given event.
     *
     * @param event - the event to be used to retrieve the behaviors
     * @param <T>   - concrete type of {@link Event}
     * @param <R>   - concrete type of data associated with the {@link Event}
     * @return {@link List} list of {@link EventBehavior} behaviors that should be performed on the pipeline
     */
    <T extends Event<R>, R> List<EventBehavior<T>> getEventBehaviors(T event);

    /**
     * Retrieves the GlobalEventBehaviors for the registry, these global behaviors will be used with any {@link Event}.
     *
     * @param event - the event to be used to retrieve the behaviors
     * @param <T>   - concrete type of {@link Event}
     * @param <R>   - concrete type of data associated with the {@link Event}
     * @return {@link List} list of {@link EventBehavior} behaviors that should be performed on the pipeline
     */
    <T extends Event<R>, R> List<EventBehavior<T>> getGlobalBehaviors(T event);
}
