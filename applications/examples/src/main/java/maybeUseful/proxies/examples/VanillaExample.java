package maybeUseful.proxies.examples;

import maybeUseful.proxies.examples.exampleClasses.vanilla.InterfaceToProxy;
import maybeUseful.proxies.examples.exampleClasses.vanilla.InterfaceToProxyImpl;
import maybeUseful.proxies.examples.exampleClasses.vanilla.InterfaceToProxyInvocationHandler;

import java.lang.reflect.Proxy;

public class VanillaExample {
    public void execute() {
        Class<InterfaceToProxy> interfaceToProxyClass = InterfaceToProxy.class;

        InterfaceToProxy instance = (InterfaceToProxy) Proxy.newProxyInstance(
                interfaceToProxyClass.getClassLoader(),
                new Class<?>[]{InterfaceToProxy.class},
                new InterfaceToProxyInvocationHandler()
        );

        System.out.println(instance.getString());
        System.out.println(instance.getInteger());
    }
}
