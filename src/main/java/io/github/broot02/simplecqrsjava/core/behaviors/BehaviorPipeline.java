package io.github.broot02.simplecqrsjava.core.behaviors;

import java.util.*;

@SuppressWarnings("FieldCanBeLocal")
public class BehaviorPipeline<T extends Behavior<?>> {

    private final List<T> behaviors;
    private final Iterator<T> behaviorIterator;

    public BehaviorPipeline(List<T> behaviors) {
        this.behaviors = new ArrayList<>();
        this.behaviors.addAll(behaviors);
        this.behaviors.sort(Comparator.comparingInt(Behavior::getOrder));

        this.behaviorIterator = this.behaviors.listIterator();
    }

    public Optional<T> next() {
        return behaviorIterator.hasNext() ? Optional.of(behaviorIterator.next()) : Optional.empty();
    }

    public boolean hasNext() {
        return behaviorIterator.hasNext();
    }
}
