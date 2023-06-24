package com.github.simplecqrsjava.core.commands.fakes;

import com.github.simplecqrsjava.core.commands.CommandHandler;

public class FakeCommandHandler implements CommandHandler<FakeCommand, Boolean> {
    @Override
    public Boolean handle(FakeCommand command) {
        return true;
    }
}
