package io.github.broot02.simplecqrsjava.core.queries;

import io.github.broot02.simplecqrsjava.core.behaviors.BehaviorPipeline;

import java.util.List;

public class QueryBehaviorPipeline<T extends Query<R>, R> extends BehaviorPipeline<QueryBehavior<T>> {

    public QueryBehaviorPipeline(List<QueryBehavior<T>> behaviors) {
        super(behaviors);
    }
}
