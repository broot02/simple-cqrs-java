package io.github.broot02.simplecqrsjava.core.queries;

import io.github.broot02.simplecqrsjava.core.queries.fakes.FakeQuery;
import io.github.broot02.simplecqrsjava.core.queries.fakes.FakeQueryHandler;
import io.github.broot02.simplecqrsjava.core.shared.exceptions.UnregisteredHandlerException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class QueryBusTest {

    private QueryBus queryBus;
    private QueryRegistry registry;

    @BeforeEach()
    public void setup() {
        registry =  mock(QueryRegistry.class);
        queryBus = new QueryBus(registry);
    }

    @Test
    public void should_ReturnTrue_When_MockHandlerIsFoundForFakeCommand() {
        when(registry.getQueryHandler(any(FakeQuery.class))).thenReturn(new FakeQueryHandler());
        var result = queryBus.process(new FakeQuery());

        Assertions.assertTrue(result);
    }

    @Test
    public void should_ThrowUnregisteredHandler_When_HandlerIsNotFoundForFakeCommand() {
        assertThrows(UnregisteredHandlerException.class, () -> queryBus.process(new FakeQuery()));
    }

}
