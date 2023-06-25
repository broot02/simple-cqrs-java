package io.github.broot02.simplecqrsjava.core.commands.fakes;

import io.github.broot02.simplecqrsjava.core.commands.CommandHandler;

public class FakeCommandHandler implements CommandHandler<FakeCommand, Boolean> {
    @Override
    public Boolean handle(FakeCommand command) {
        return true;
    }
}
