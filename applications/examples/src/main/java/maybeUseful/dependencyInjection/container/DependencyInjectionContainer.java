package maybeUseful.dependencyInjection.container;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class DependencyInjectionContainer {

    private final Set<Class<?>> supportedPrimitives;
    private final Map<Class<?>, Supplier<?>> primitiveSuppliers;

    public DependencyInjectionContainer() {
        Random random = new Random();

        primitiveSuppliers = new HashMap<>();
        primitiveSuppliers.put(Integer.class, random::nextInt);
        primitiveSuppliers.put(Long.class, random::nextLong);
        primitiveSuppliers.put(String.class, () -> "String-" + random.nextLong());

        supportedPrimitives = primitiveSuppliers.keySet();
    }

    public <T> T getInstance(Class<?> objectClass) {
        if (isPrimitive(objectClass)) {
            return getPrimitiveValue(objectClass);
        }

        Constructor<?> constructor = objectClass.getConstructors()[0];

        try {
            return (T) constructor.newInstance(getParameters(constructor.getParameterTypes()));
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private Object[] getParameters(Class<?>[] parameterTypes) {
        Object[] parameters = new Object[parameterTypes.length];

        IntStream.range(0, parameterTypes.length).forEach((index) -> {
            Class<?> parameterType = parameterTypes[index];

            parameters[index] = getInstance(parameterType);
        });

        return parameters;
    }

    private <T> T getPrimitiveValue(Class<?> objectClass) {
        return (T) primitiveSuppliers.getOrDefault(
                objectClass,
                () -> null
        ).get();
    }

    private boolean isPrimitive(Class<?> objectClass) {
        return supportedPrimitives.contains(objectClass);
    }

}
