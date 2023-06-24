package io.github.broot02.simplecqrsjava.core.events;

/**
 * An event represents some action that has occurred, this could represent a state change, an action that occurred.
 *
 * @param <R> - data that is expected to be provided as part of the event, for the event handling
 */
@SuppressWarnings("unused")
public class Event<R> {

    private final R data;

    public Event(R data) {
        this.data = data;
    }

    public R getData() {
        return data;
    }
}
