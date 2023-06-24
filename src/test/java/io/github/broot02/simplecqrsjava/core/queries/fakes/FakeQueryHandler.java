package io.github.broot02.simplecqrsjava.core.queries.fakes;

import io.github.broot02.simplecqrsjava.core.queries.QueryHandler;

public class FakeQueryHandler implements QueryHandler<Boolean, FakeQuery> {
    @Override
    public Boolean handle(FakeQuery query) {
        return true;
    }
}
