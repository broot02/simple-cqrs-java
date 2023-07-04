package io.github.broot02.simplecqrsjava.core.commands;

import io.github.broot02.simplecqrsjava.core.behaviors.Behavior;

/**
 * Behavior that will be executed as part of the CommandBus pipeline.
 */
public interface CommandBehavior<T extends Command<?>> extends Behavior<T> {
}
