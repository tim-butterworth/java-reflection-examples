package maybeUseful.proxies.examples.exampleClasses.transactional;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Optional;

public class TransactionInvocationHandler implements InvocationHandler {

    private final InterfaceWithTransactionsImpl instance;

    public TransactionInvocationHandler(InterfaceWithTransactionsImpl instance) {
        this.instance = instance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Optional<Transactional> annotation = Optional.ofNullable(method.getAnnotation(Transactional.class));

        if (annotation.isPresent()) {
            try {
                System.out.println("Starting the transaction");

                Object result = method.invoke(instance, args);

                System.out.println("Completed transaction successfully");

                return result;
            } catch (Exception e) {
                System.out.println("Rolling back the transaction");
            }
        } else {
            return method.invoke(instance, args);
        }

        return null;
    }
}
