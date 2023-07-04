package io.github.broot02.simplecqrsjava.core.queries.fakes;

import io.github.broot02.simplecqrsjava.core.queries.Query;

public class FakeQuery implements Query<Boolean> {

    private final String data;

    public FakeQuery(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
