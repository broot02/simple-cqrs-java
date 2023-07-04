package io.github.broot02.simplecqrsjava.core.events;

import io.github.broot02.simplecqrsjava.core.behaviors.BehaviorPipeline;

import java.util.*;

public class EventBehaviorPipeline<T extends Event<R>, R>  extends BehaviorPipeline<EventBehavior<T>> {

    public EventBehaviorPipeline(List<EventBehavior<T>> behaviors, List<EventBehavior<T>> globalBehaviors) {
        super(behaviors, globalBehaviors);
    }
}
