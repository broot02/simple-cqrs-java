package io.github.broot02.simplecqrsjava.core.queries;

import io.github.broot02.simplecqrsjava.core.shared.exceptions.UnregisteredHandlerException;

/**
 * QueryBus is responsible for handling the {@link Query}, and passing it to the appropriate {@link QueryHandler}.
 * This is the central class to handling events. If additional "behaviors" are desired this class should be extended.
 */
public class QueryBus {

    private final QueryRegistry registry;

    public QueryBus(QueryRegistry registry) {
        this.registry = registry;
    }

    /**
     * Passes the {@link Query} to the {@link QueryHandler} for processing, if registered.
     *
     * @param query represents data that is to be passed to the handler
     * @param <R>   represents response that is expected to be returned
     * @param <T>   represents query that is to be passed to handler
     * @return Query determines the response that is expected to be returned
     * @throws UnregisteredHandlerException - if query has not been registered
     */
    public <T extends Query<R>, R> R process(T query) {
        var handler = registry.getQueryHandler(query);

        if (handler == null) {
            throw new UnregisteredHandlerException(query.getClass());
        }

        var behaviors = registry.getQueryBehaviors(query);
        var globalBehaviors = registry.getGlobalBehaviors(query);
        var pipeline = new QueryBehaviorPipeline<>(behaviors, globalBehaviors);

        while (pipeline.hasNext()) {
            var behavior = pipeline.next();

            behavior.ifPresent(queryBehavior -> {
                if (queryBehavior.shouldExecute(query)) {
                    queryBehavior.handle(query);
                }
            });
        }

        return handler.handle(query);
    }
}
