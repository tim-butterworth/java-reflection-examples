package maybeUseful.proxies.examples.exampleClasses.vanilla;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

public class InterfaceToProxyInvocationHandler implements InvocationHandler {

    private final HashMap<String, Object> stringObjectHashMap;

    public InterfaceToProxyInvocationHandler() {
        stringObjectHashMap = new HashMap<>();

        stringObjectHashMap.put("getString", "string from the proxy");
        stringObjectHashMap.put("getInteger", 101);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return stringObjectHashMap.get(method.getName());
    }
}
