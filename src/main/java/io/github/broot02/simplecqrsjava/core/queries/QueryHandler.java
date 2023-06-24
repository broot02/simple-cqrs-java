package io.github.broot02.simplecqrsjava.core.queries;


/**
 * The QueryHandler is responsible for performing some operation with the query, which should be for retrieval of data.
 * A good rule of thumb is that these query handlers are intended for retrieval of "some" data, the handler is a good place to load additional data, such as entities that are needed to complete its mutation.
 * The handler will return a value that is representative of the application needs, such that an ID or an entire Entity could be returned.
 *
 * @param <T> The specific query to be handled by this handler, typically this should contain all the data which the handler needs to execute its mutation
 * @param <R> The "type" of response that is returned, this is open-ended and will differ greatly based on the application usage
 */
public interface QueryHandler<R, T extends Query<R>> {

    /**
     * Handles the specific query provided, will take the requested query, and perform "an" operation, typically retrieval in nature.
     *
     * @param query - represents the data needed to perform the operation based on the handler implementation
     * @return - the response type that corresponds to the query/handler (such as id, entity), represents successful completion of the query handling
     */
    R handle(T query);
}
