package io.github.broot02.simplecqrsjava.core.commands;

import io.github.broot02.simplecqrsjava.core.shared.exceptions.UnregisteredHandlerException;

/**
 * CommandBus is responsible for handling the {@link Command}, and passing it to the appropriate {@link CommandHandler}.
 * This is the central class to handling commands. If additional "behaviors" are desired this class should be extended.
 */
public class CommandBus {
    private final CommandRegistry registry;

    public CommandBus(CommandRegistry registry) {
        this.registry = registry;
    }

    /**
     * Passes the {@link Command} to the {@link CommandHandler} if registered.
     *
     * @param command represents data that is to be passed to the handler
     * @param <R>     represents response that is expected to be returned
     * @param <T>     represents command that is to be passed to handler
     * @return Command determines the response that is expected to be returned
     * @throws UnregisteredHandlerException - if command has not been registered
     */
    public <R, T extends Command<R>> R process(T command) {
        var handler = registry.getCommandHandler(command);

        if (handler == null) {
            throw new UnregisteredHandlerException(command.getClass());
        }

        var behaviors = registry.getCommandBehaviors(command);
        var pipeline = new CommandBehaviorPipeline<>(behaviors);

        while (pipeline.hasNext()) {
            var behavior = pipeline.next();

            behavior.ifPresent(commandBehavior -> {
                if (commandBehavior.shouldExecute(command)) {
                    commandBehavior.handle(command);
                }
            });
        }

        return handler.handle(command);
    }
}
