package io.github.broot02.simplecqrsjava.core.commands;

import java.util.Optional;

/**
 * VoidCommands represent data that is needed to perform some operation, typically a mutative operation.
 * The VoidCommand is a specialized type of Command where an Optional value is returned with a Void type,
 * this must align with the handler.
 */
@SuppressWarnings("unused")
public interface VoidCommand extends Command<Optional<Void>>{
}
