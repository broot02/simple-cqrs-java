package com.github.simplecqrsjava.core.commands;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import com.github.simplecqrsjava.core.commands.fakes.FakeCommand;
import com.github.simplecqrsjava.core.commands.fakes.FakeCommandHandler;
import com.github.simplecqrsjava.core.shared.exceptions.UnregisteredHandlerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommandBusTest {

    private CommandBus commandBus;
    private CommandRegistry registry;

    @BeforeEach
    void setUp() {
        registry = mock(CommandRegistry.class);
        commandBus = new CommandBus(registry);
    }

    @Test
    public void should_ReturnTrue_When_MockHandlerIsFoundForFakeCommand() {
        when(registry.getCommandHandler(any(FakeCommand.class))).thenReturn(new FakeCommandHandler());
        var result = commandBus.process(new FakeCommand());

        assertTrue(result);
    }

    @Test
    public void should_ThrowUnregisteredHandler_When_HandlerIsNotFoundForFakeCommand() {
        assertThrows(UnregisteredHandlerException.class, () -> commandBus.process(new FakeCommand()));
    }

}