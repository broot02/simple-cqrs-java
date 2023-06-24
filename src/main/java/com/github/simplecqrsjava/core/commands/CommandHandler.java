package com.github.simplecqrsjava.core.commands;

/**
 * The CommandHandler is responsible for performing some operation with the command, your business logic would ideally reside in this class.
 * Allowing ease of testing that logic, while also promoting key factors such as Dependency Injection for testability.
 * A good rule of thumb is that these command handlers are intended for mutation of "some" data, the handler is a good place to load additional data, such as entities that are needed to complete its mutation.
 * The handler will return a value that is representative of the application needs, such that an ID or an entire Entity could be returned.
 *
 * @param <T> The specific command to be handled by this handler, typically this should contain all the data which the handler needs to execute its mutation
 * @param <R> The "type" of response that is returned, this is open-ended and will differ greatly based on the application usage
 */
public interface CommandHandler<T extends Command<R>, R> {
    /**
     * Handles the specific command provided, will take the requested command, and perform "an" operation, typically mutative.
     *
     * @param command - represents the data needed to perform the operation based on the handler implementation
     * @return - the response type that corresponds to the command/handler (such as id, entity), represents successful completion of the command handling
     */
    R handle(T command);
}
