package io.github.broot02.simplecqrsjava.core.events.fakes;

import io.github.broot02.simplecqrsjava.core.events.EventBehavior;

public class FakeBehavior implements EventBehavior<FakeEvent> {
    @Override
    public void handle(FakeEvent object) {
    }

    @Override
    public boolean shouldExecute(FakeEvent object) {
        return object.getData() != null;
    }
}
