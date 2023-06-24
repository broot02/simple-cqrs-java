package com.github.simplecqrsjava.core.events;

import com.github.simplecqrsjava.core.events.fakes.FakeEvent;
import com.github.simplecqrsjava.core.events.fakes.FakeEventHandler;
import com.github.simplecqrsjava.core.shared.exceptions.UnregisteredHandlerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        var handler = spy(new FakeEventHandler());
        when(registry.getEventHandler(any(FakeEvent.class))).thenReturn(handler);
        eventBus.process(new FakeEvent(1L));

        verify(handler, times(1)).handle(any());
    }

    @Test
    public void should_ThrowUnregisteredHandler_When_HandlerIsNotFoundForFakeCommand() {
        assertThrows(UnregisteredHandlerException.class, () -> eventBus.process(new FakeEvent(1L)));
    }

}
