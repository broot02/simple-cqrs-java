package io.github.broot02.simplecqrsjava.core.commands.fakes;

import io.github.broot02.simplecqrsjava.core.commands.Command;
import io.github.broot02.simplecqrsjava.core.commands.CommandBehavior;

public class FakeLoggingBehavior implements CommandBehavior<Command<?>> {

    @Override
    public int getOrder() {
        return 15;
    }

    @Override
    public void handle(Command<?> object) {
    }
}
