package com.github.simplecqrsjava.core.commands;

/**
 * Responsible for registering Commands/Handlers for future usage. It is the responsibility of the calling library to provide implementations of this class,
 * there may be convenience libraries, but those implementations must be part of a separate library/jar.
 * This registry will allow dynamic of handlers based on the command provided, one handler will be provided for a command provided,
 * as such there is no guarantee that this one-to-one relationship will be maintained by the calling application, and that should be accounted for.
 * It might be a possibility to guarantee this in the future, but in current state this will not be guaranteed.
 */
public interface CommandRegistry {

    /**
     * Retrieves the CommandHandler for the given command.
     *
     * @param command - the command to be used to retrieve the handler
     * @param <R>     - the response to be returned from the {@link CommandHandler}
     * @param <T>     - concrete type of {@link Command}
     * @param <T2>    - concrete type of {@link CommandHandler}
     * @return {@link CommandHandler} which handles the provided command
     */
    <R, T extends Command<R>, T2 extends CommandHandler<T, R>> T2 getCommandHandler(T command);

}
