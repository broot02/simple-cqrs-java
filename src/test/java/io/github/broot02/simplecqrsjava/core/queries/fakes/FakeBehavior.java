package io.github.broot02.simplecqrsjava.core.queries.fakes;

import io.github.broot02.simplecqrsjava.core.queries.QueryBehavior;

public class FakeBehavior implements QueryBehavior<FakeQuery> {
    @Override
    public void handle(FakeQuery object) {
    }

    @Override
    public boolean shouldExecute(FakeQuery object) {
        return object.getData() != null;
    }
}
