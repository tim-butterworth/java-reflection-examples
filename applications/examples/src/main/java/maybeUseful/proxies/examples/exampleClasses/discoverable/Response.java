package maybeUseful.proxies.examples.exampleClasses.discoverable;

import java.util.Optional;

public class Response<T> {

    private final Optional<T> success;
    private final Optional<Exception> e;

    private Response(T success) {
        this.success = Optional.ofNullable(success);
        this.e = Optional.empty();
    }

    private Response(Exception e) {
        this.e = Optional.of(e);
        this.success = Optional.empty();
    }

    static <T> Response<T> success(T success) {
        return new Response<>(success);
    }

    static <T> Response<T> error(Exception e) {
        return new Response<>(e);
    }

    public T successOrThrow() throws Throwable {
        if (e.isPresent()) {
            throw e.map(Exception::getCause).orElse(new RuntimeException("that is weird"));
        }

        return success.orElse(null);
    }
}
