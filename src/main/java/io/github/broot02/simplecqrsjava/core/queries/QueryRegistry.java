package io.github.broot02.simplecqrsjava.core.queries;

import java.util.List;

/**
 * Responsible for registering Queries/Handlers for future usage. It is the responsibility of the calling library to provide implementations of this class,
 * there may be convenience libraries, but those implementations must be part of a separate library/jar.
 * This registry will allow dynamic of handlers based on the query provided, one handler will be provided for a query provided,
 * as such there is no guarantee that this one-to-one relationship will be maintained by the calling application, and that should be accounted for.
 * It might be a possibility to guarantee this in the future, but in current state this will not be guaranteed.
 */
public interface QueryRegistry {

    /**
     * Retrieves the QueryHandler for the given query.
     *
     * @param query - the query to be used to retrieve the handler
     * @param <R>   - the response to be returned from the {@link QueryHandler}
     * @param <T>   - concrete type of {@link Query}
     * @param <T2>  - concrete type of {@link QueryHandler}
     * @return {@link QueryHandler} which handles the provided query
     */
    <R, T extends Query<R>, T2 extends QueryHandler<R, T>> T2 getQueryHandler(T query);

    /**
     * Retrieves the QueryBehaviors for the given query.
     *
     * @param query - the query to be used to retrieve the behaviors
     * @param <T>   - concrete type of {@link Query}
     * @param <R>   - concrete type response to be returned from {@link Query}
     * @return {@link List} list of {@link QueryBehavior} behaviors that should be performed on the pipeline
     */
    <T extends Query<R>, R> List<QueryBehavior<T>> getQueryBehaviors(T query);

    /**
     * Retrieves the GlobalQueryBehaviors for the registry, these global behaviors will be used with any {@link Query}
     *
     * @param query - the query to be used to retrieve the behaviors
     * @param <T>   - concrete type of {@link Query}
     * @param <R>   - concrete type response to be returned from {@link Query}
     * @return {@link List} list of {@link QueryBehavior} behaviors that should be performed on the pipeline
     */
    <T extends Query<R>, R> List<QueryBehavior<T>> getGlobalBehaviors(T query);

}
