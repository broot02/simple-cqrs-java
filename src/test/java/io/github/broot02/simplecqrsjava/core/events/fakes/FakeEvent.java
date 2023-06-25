package io.github.broot02.simplecqrsjava.core.events.fakes;

import io.github.broot02.simplecqrsjava.core.events.Event;

public class FakeEvent extends Event<Long> {
    public FakeEvent(Long data) {
        super(data);
    }
}
