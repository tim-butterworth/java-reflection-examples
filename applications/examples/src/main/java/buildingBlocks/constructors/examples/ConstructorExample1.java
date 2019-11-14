package buildingBlocks.constructors.examples;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class ConstructorExample1 {

    public void execute() {
        Constructor<ArrayList>[] constructors = getConstructorsForClass(ArrayList.class);

        Optional<ArrayList> maybeDefaultConstructor = Stream.of(constructors)
                .filter((constructor) -> constructor.getParameterCount() == 0)
                .findFirst()
                .flatMap(this::getNewInstance);

        maybeDefaultConstructor.ifPresentOrElse(
                (instance) -> {
                    instance.add("value");
                    System.out.println(instance);
                },
                () -> System.out.println("Failed to create a List")
        );
    }

    private <T> Constructor<T>[] getConstructorsForClass(Class<T> clazz) {
        return (Constructor<T>[]) clazz.getConstructors();
    }

    private <T> Optional<T> getNewInstance(Constructor<T> constructor) {
        try {
            return Optional.of(constructor.newInstance());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            return Optional.empty();
        }
    }
}
