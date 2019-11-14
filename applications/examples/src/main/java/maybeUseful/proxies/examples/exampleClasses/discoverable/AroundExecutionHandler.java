package maybeUseful.proxies.examples.exampleClasses.discoverable;

import java.util.function.Supplier;

public interface AroundExecutionHandler {
    <T> Response<T> handle(Supplier<T> executeMethod);
}
