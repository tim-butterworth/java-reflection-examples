package maybeUseful.haveAnInterfaceMultipleImpl.examples;

import some.great.ideas.GreatIdeaGenerator;

import java.lang.reflect.InvocationTargetException;

public class GreatIdeaGeneratorFactory {
    public GreatIdeaGenerator getInstance() {
        try {
            Class<?> aClass = Class.forName("some.expensive.ideas.ExpensiveIdeaGenerator");

            return (GreatIdeaGenerator) aClass.getConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            System.out.println("Looks like no top quality ideas for you :(");
        }

        try {
            Class<?> aClass = Class.forName("some.meh.ideas.you.get.what.you.payFor.MehIdeaGenerator");

            return (GreatIdeaGenerator) aClass.getConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.out.println("Looks like no cheap ideas either");
        }

        throw new RuntimeException("No implementations of GreatIdeaGenerator on the classpath");
    }
}
