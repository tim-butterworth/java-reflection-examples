package buildingBlocks.constructors.examples;

import buildingBlocks.constructors.examples.constructorClasses.ClassWithMultiArgumentConstructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ConstructorExample2 {
    public void execute() {
        try {
            Constructor<?> constructor = ClassWithMultiArgumentConstructor.class.getConstructor(
                    String.class,
                    Integer.class,
                    List.class
            );

            ClassWithMultiArgumentConstructor instance = (ClassWithMultiArgumentConstructor) constructor.newInstance("SomeString", 12, new ArrayList());

            System.out.println(instance);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
