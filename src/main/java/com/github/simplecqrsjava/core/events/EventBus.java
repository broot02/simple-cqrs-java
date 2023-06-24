package com.github.simplecqrsjava.core.events;

import com.github.simplecqrsjava.core.shared.exceptions.UnregisteredHandlerException;

/**
 * EventBus is responsible for handling the {@link Event}, and passing it to the appropriate {@link EventHandler}.
 * This is the central class to handling events. If additional "behaviors" are desired this class should be extended.
 */
public class EventBus {
    private final EventRegistry registry;

    public EventBus(EventRegistry registry) {
        this.registry = registry;
    }

    /**
     * Process {@link Event} based on the availability of the {@link EventHandler}.
     * If a handler is found the handler will process this event, otherwise an {@link UnregisteredHandlerException} will be thrown.
     *
     * @param event - the event to be handled
     * @param <T>   - the concrete type of event to be handled
     * @param <R>   - the data that is contained within the event
     * @throws UnregisteredHandlerException - Thrown ff a handler is not found in the registry for this event.
     */
    public <T extends Event<R>, R> void process(T event) {
        var handler = registry.getEventHandler(event);

        if (handler == null) {
            throw new UnregisteredHandlerException(event.getClass());
        }

        handler.handle(event);
    }
}
