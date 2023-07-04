package io.github.broot02.simplecqrsjava.core.commands.fakes;

import io.github.broot02.simplecqrsjava.core.commands.Command;

public class FakeCommand implements Command<Boolean> {

    private final String data;

    public FakeCommand(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
