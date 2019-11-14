package nonsense.peopleMightUnderstandMyCode;

import nonsense.peopleMightUnderstandMyCode.examples.CustomClassLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MightUnderstandRunner {
    public static void main(String[] args) {
        try {
            Class aClass = new CustomClassLoader().findClass("where.classes.are.SafeStack");

            Object instance = aClass.getConstructor().newInstance();
            Method method1 = aClass.getMethod("pop");
            Method method2 = aClass.getMethod("push", Object.class);

            System.out.println(instance.getClass().getCanonicalName());

            method2.invoke(instance, "Some Value");

            System.out.println(method1.invoke(instance));
        } catch (ClassNotFoundException | InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
