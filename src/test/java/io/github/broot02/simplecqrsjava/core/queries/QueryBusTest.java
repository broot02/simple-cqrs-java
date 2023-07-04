package io.github.broot02.simplecqrsjava.core.queries;

import io.github.broot02.simplecqrsjava.core.queries.fakes.FakeBehavior;
import io.github.broot02.simplecqrsjava.core.queries.fakes.FakeQuery;
import io.github.broot02.simplecqrsjava.core.queries.fakes.FakeQueryHandler;
import io.github.broot02.simplecqrsjava.core.shared.exceptions.UnregisteredHandlerException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

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
        var result = queryBus.process(new FakeQuery("Test"));

        Assertions.assertTrue(result);
    }

    @Test
    public void should_ThrowUnregisteredHandler_When_HandlerIsNotFoundForFakeCommand() {
        assertThrows(UnregisteredHandlerException.class, () -> queryBus.process(new FakeQuery("Test")));
    }

    @Test
    public void should_CallBehavior_When_QueryAsRegisteredBehavior() {
        var behavior = Mockito.spy(new FakeBehavior());
        var behaviors = List.of(behavior);
        when(registry.getQueryHandler(any(FakeQuery.class))).thenReturn(new FakeQueryHandler());
        when(registry.getQueryBehaviors(any(FakeQuery.class))).thenReturn(new ArrayList<>(behaviors));

        queryBus.process(new FakeQuery("Test"));
        verify(behavior, Mockito.times(1)).shouldExecute(any(FakeQuery.class));
        verify(behavior, Mockito.times(1)).handle(any(FakeQuery.class));

    }

    @Test
    public void should_NotCallBehavior_When_QueryHasRegisteredBehaviorButShouldNotBeExecuted() {
        var behavior = Mockito.spy(new FakeBehavior());
        var behaviors = List.of(behavior);
        when(registry.getQueryHandler(any(FakeQuery.class))).thenReturn(new FakeQueryHandler());
        when(registry.getQueryBehaviors(any(FakeQuery.class))).thenReturn(new ArrayList<>(behaviors));

        queryBus.process(new FakeQuery(null));
        verify(behavior, Mockito.times(1)).shouldExecute(any(FakeQuery.class));
        verify(behavior, Mockito.times(0)).handle(any(FakeQuery.class));
    }

}
