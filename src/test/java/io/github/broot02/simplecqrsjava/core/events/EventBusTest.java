package io.github.broot02.simplecqrsjava.core.events;

import io.github.broot02.simplecqrsjava.core.events.fakes.FakeBehavior;
import io.github.broot02.simplecqrsjava.core.events.fakes.FakeEventHandler;
import io.github.broot02.simplecqrsjava.core.shared.exceptions.UnregisteredHandlerException;
import io.github.broot02.simplecqrsjava.core.events.fakes.FakeEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class EventBusTest {

    private EventBus eventBus;
    private EventRegistry registry;

    @BeforeEach()
    void setUp() {
        registry = mock(EventRegistry.class);
        eventBus = new EventBus(registry);
    }

    @Test
    public void should_ReturnTrue_When_MockHandlerIsFoundForFakeCommand() {
        var handler = Mockito.spy(new FakeEventHandler());
        when(registry.getEventHandler(any(FakeEvent.class))).thenReturn(handler);
        eventBus.process(new FakeEvent(1L));

        verify(handler, times(1)).handle(any());
    }

    @Test
    public void should_ThrowUnregisteredHandler_When_HandlerIsNotFoundForFakeCommand() {
        assertThrows(UnregisteredHandlerException.class, () -> eventBus.process(new FakeEvent(1L)));
    }

    @Test
    public void should_CallBehavior_When_EventHasRegisteredBehavior() {
        var behavior = Mockito.spy(new FakeBehavior());
        var behaviors = List.of(behavior);
        when(registry.getEventHandler(any(FakeEvent.class))).thenReturn(new FakeEventHandler());
        when(registry.getEventBehaviors(any(FakeEvent.class))).thenReturn(new ArrayList<>(behaviors));

        eventBus.process(new FakeEvent(1L));
        verify(behavior, Mockito.times(1)).shouldExecute(any(FakeEvent.class));
        verify(behavior, Mockito.times(1)).handle(any(FakeEvent.class));
    }

    @Test
    public void should_NotCallBehavior_When_EventHasRegisteredBehaviorButShouldNotBeExecuted() {
        var behavior = Mockito.spy(new FakeBehavior());
        var behaviors = List.of(behavior);
        when(registry.getEventHandler(any(FakeEvent.class))).thenReturn(new FakeEventHandler());
        when(registry.getEventBehaviors(any(FakeEvent.class))).thenReturn(new ArrayList<>(behaviors));

        eventBus.process(new FakeEvent(null));
        verify(behavior, Mockito.times(1)).shouldExecute(any(FakeEvent.class));
        verify(behavior, Mockito.times(0)).handle(any(FakeEvent.class));
    }

}
