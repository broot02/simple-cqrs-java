package com.github.simplecqrsjava.core.queries.fakes;

import com.github.simplecqrsjava.core.queries.QueryHandler;

public class FakeQueryHandler implements QueryHandler<Boolean, FakeQuery> {
    @Override
    public Boolean handle(FakeQuery query) {
        return true;
    }
}
