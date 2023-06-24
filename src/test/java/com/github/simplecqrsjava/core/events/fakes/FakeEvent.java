package com.github.simplecqrsjava.core.events.fakes;

import com.github.simplecqrsjava.core.events.Event;

public class FakeEvent extends Event<Long> {
    public FakeEvent(Long data) {
        super(data);
    }
}
