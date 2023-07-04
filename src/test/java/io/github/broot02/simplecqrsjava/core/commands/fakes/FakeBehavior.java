package io.github.broot02.simplecqrsjava.core.commands.fakes;

import io.github.broot02.simplecqrsjava.core.commands.CommandBehavior;

public class FakeBehavior implements CommandBehavior<FakeCommand> {

    @Override
    public int getOrder() {
        return 25;
    }

    @Override
    public void handle(FakeCommand object) {
    }

    @Override
    public boolean shouldExecute(FakeCommand object) {
        return object.getData() != null;
    }
}
