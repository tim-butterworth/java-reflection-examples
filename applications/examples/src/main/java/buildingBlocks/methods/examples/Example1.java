package buildingBlocks.methods.examples;

import buildingBlocks.methods.exampleClasses.ClassWithMethods;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Example1 {
    public void execute() {
        ClassWithMethods classWithMethods = new ClassWithMethods();

        Method[] declaredMethods = classWithMethods.getClass().getDeclaredMethods();

        List<Method> getters = getGetters(declaredMethods);
        List<Method> setters = getSetters(declaredMethods);

        setters.forEach((setter) -> {
            try {
                setter.invoke(classWithMethods, getParameters(setter));
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException("Error with: " + setter.getName());
            }
        });

        getters.forEach((getter) -> {
            try {
                Object value = getter.invoke(classWithMethods);

                System.out.println(getter.getName() + " -> " + value);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException("Error with: " + getter.getName());
            }
        });
    }

    private Object[] getParameters(Method setter) {
        Parameter[] parameters = setter.getParameters();
        Object[] arguments = new Object[parameters.length];

        IntStream.range(0, parameters.length)
                .forEach((index) -> {
                    Parameter parameter = parameters[index];
                    arguments[index] = getInstance(parameter.getType());
                });

        return arguments;
    }

    private Object getInstance(Class<?> type) {
        Random random = new Random();
        if (type == String.class) {
            return "A String " + random.nextLong();
        }
        if (type == Integer.class) {
            return random.nextInt();
        }

        throw new RuntimeException("Can not handle " + type);
    }

    private List<Method> getGetters(Method[] declaredMethods) {
        return getMethodExtractor("get").apply(declaredMethods);
    }

    private List<Method> getSetters(Method[] declaredMethods) {
        return getMethodExtractor("set").apply(declaredMethods);
    }

    private Function<Method[], List<Method>> getMethodExtractor(String prefix) {
        return (methods) -> Stream.of(methods)
                .filter((method) -> method.getName().startsWith(prefix))
                .collect(Collectors.toList());
    }
}
