package maybeUseful.proxies.examples.exampleClasses.discoverable;

import java.util.function.Supplier;

public class Transaction implements AroundExecutionHandler {
    public <T> Response<T> handle(Supplier<T> executeMethod) {
        System.out.println("Begin Transaction");

        try {
            return Response.success(executeMethod.get());
        } catch (RuntimeException e) {
            Response<T> response = Response.error(e);

            System.out.println("Transaction successful");

            return response;
        } finally {
            System.out.println("Rolling back transaction");
        }
    }
}
