package nonsense.noMoreDataClasses;

import nonsense.noMoreDataClasses.exampleClasses.DataClass;
import nonsense.noMoreDataClasses.exampleClasses.DataClassInvocationHandler;

import java.lang.reflect.Proxy;

public class NoMoreDataClassesRunner {
    public static void main(String[] args) {
        Class<DataClass> dataClass = DataClass.class;
        DataClass instance = (DataClass) Proxy.newProxyInstance(
                dataClass.getClassLoader(),
                new Class<?>[]{dataClass},
                new DataClassInvocationHandler()
        );

        instance.setName("a great name");

        System.out.println(instance.toString());

        String name = instance.getName();

        System.out.println(name);

        System.out.println(instance.equals(null));
    }
}
