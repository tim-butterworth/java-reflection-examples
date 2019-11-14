package maybeUseful.proxies.examples.exampleClasses.discoverable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;
import java.util.function.Supplier;

public class AroundHandler implements InvocationHandler {

    private final InterfaceWithAroundImpl instance;

    public AroundHandler(InterfaceWithAroundImpl instance) {
        this.instance = instance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Optional<Around> maybeAnnotation = Optional.ofNullable(method.getAnnotation(Around.class));

        Supplier<Object> executeMethod = () -> {
            try {
                return method.invoke(instance, args);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        };

        Response<Object> response = maybeAnnotation
                .map(Around::handler)
                .flatMap(this::newInstance)
                .map(handler -> handler.handle(executeMethod))
                .orElseGet(() -> {
                    try {
                        return Response.success(executeMethod.get());
                    } catch (Exception e) {
                        return Response.error(e);
                    }
                });

        return response.successOrThrow();
    }

    private <T> Optional<T> newInstance(Class<T> tClass) {
        try {
            return Optional.of(tClass.getConstructor().newInstance());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
