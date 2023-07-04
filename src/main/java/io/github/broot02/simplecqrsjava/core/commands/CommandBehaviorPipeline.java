package io.github.broot02.simplecqrsjava.core.commands;

import io.github.broot02.simplecqrsjava.core.behaviors.BehaviorPipeline;

import java.util.*;

public class CommandBehaviorPipeline<T extends Command<R>, R>  extends BehaviorPipeline<CommandBehavior<T>> {

    public CommandBehaviorPipeline(List<CommandBehavior<T>> behaviors, List<CommandBehavior<T>> globalBehaviors) {
        super(behaviors, globalBehaviors);
    }
}
