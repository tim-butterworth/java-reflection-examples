package buildingBlocks.constructors.examples;

import buildingBlocks.constructors.examples.constructorClasses.ClassWithMultiArgumentConstructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class ConstructorExample3 {
    public void execute() {
        Constructor<?>[] constructors = ClassWithMultiArgumentConstructor.class.getConstructors();

        System.out.println(constructors.length);

        Constructor<?> constructor = constructors[0];

        Object[] constructorParameters = getConstructorParameters(constructor);

        try {
            Object instance = constructor.newInstance(constructorParameters);

            System.out.println(instance);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private Object[] getConstructorParameters(Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();

        Object[] arguments = new Object[parameterTypes.length];

        IntStream.range(0, arguments.length).forEach((index) -> {
            Class<?> parameterType = parameterTypes[index];

            System.out.println(parameterType.getCanonicalName());

            arguments[index] = getArgumentInstance(parameterType);
        });

        return arguments;
    }

    private Object getArgumentInstance(Class<?> parameterType) {
        Random random = new Random();

        if (parameterType == String.class) {
            return "String " + random.nextLong();
        }
        if (parameterType == Integer.class) {
            return random.nextInt();
        }
        if (parameterType == List.class) {
            return new LinkedList<>();
        }

        throw new RuntimeException("There is no implementation provider for: " + parameterType.getSimpleName());
    }
}
