package io.github.broot02.simplecqrsjava.core.commands;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import io.github.broot02.simplecqrsjava.core.commands.fakes.FakeBehavior;
import io.github.broot02.simplecqrsjava.core.commands.fakes.FakeCommand;
import io.github.broot02.simplecqrsjava.core.commands.fakes.FakeCommandHandler;
import io.github.broot02.simplecqrsjava.core.commands.fakes.FakeLoggingBehavior;
import io.github.broot02.simplecqrsjava.core.shared.exceptions.UnregisteredHandlerException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"rawtypes", "unchecked"})
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
        var result = commandBus.process(new FakeCommand("Test"));

        Assertions.assertTrue(result);
    }

    @Test
    public void should_ThrowUnregisteredHandler_When_HandlerIsNotFoundForFakeCommand() {
        assertThrows(UnregisteredHandlerException.class, () -> commandBus.process(new FakeCommand("Test")));
    }

    @Test
    public void should_CallBehavior_When_CommandHasRegisteredBehavior() {
        var behavior = Mockito.spy(new FakeBehavior());
        var behaviors = List.of(behavior, new FakeLoggingBehavior());
        when(registry.getCommandHandler(any(FakeCommand.class))).thenReturn(new FakeCommandHandler());
        when(registry.getCommandBehaviors(any(FakeCommand.class))).thenReturn(new ArrayList(behaviors));

        commandBus.process(new FakeCommand("Test"));
        verify(behavior, Mockito.times(1)).shouldExecute(any(FakeCommand.class));
        verify(behavior, Mockito.times(1)).handle(any(FakeCommand.class));
    }

    @Test
    public void should_NotCallBehavior_When_CommandHasRegisteredBehaviorButShouldNotBeExecuted() {
        var behavior = Mockito.spy(new FakeBehavior());
        var behaviors = List.of(behavior, new FakeLoggingBehavior());
        when(registry.getCommandHandler(any(FakeCommand.class))).thenReturn(new FakeCommandHandler());
        when(registry.getCommandBehaviors(any(FakeCommand.class))).thenReturn(new ArrayList(behaviors));

        commandBus.process(new FakeCommand(null));
        verify(behavior, Mockito.times(1)).shouldExecute(any(FakeCommand.class));
        verify(behavior, Mockito.times(0)).handle(any(FakeCommand.class));
    }

}