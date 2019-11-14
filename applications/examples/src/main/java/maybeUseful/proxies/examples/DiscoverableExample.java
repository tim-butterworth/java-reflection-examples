package maybeUseful.proxies.examples;

import maybeUseful.proxies.examples.exampleClasses.discoverable.AroundHandler;
import maybeUseful.proxies.examples.exampleClasses.discoverable.InterfaceWithAround;
import maybeUseful.proxies.examples.exampleClasses.discoverable.InterfaceWithAroundImpl;

import java.lang.reflect.Proxy;

public class DiscoverableExample {
    public void execute() {
        Class<InterfaceWithAround> interfaceToProxyClass = InterfaceWithAround.class;

        InterfaceWithAround instance = (InterfaceWithAround) Proxy.newProxyInstance(
                interfaceToProxyClass.getClassLoader(),
                new Class<?>[]{interfaceToProxyClass},
                new AroundHandler(new InterfaceWithAroundImpl())
        );

        instance.doImportantStuff();
        instance.doLessImportantStuff();
    }
}
