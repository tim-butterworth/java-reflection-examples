package nonsense.noMoreDataClasses.exampleClasses;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class DataClassInvocationHandler implements InvocationHandler {

    private final Map<String, Object> dataContainer;

    public DataClassInvocationHandler() {
        dataContainer = new HashMap<>();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();

        if (name.startsWith("set")) {
            return dataContainer.put(getCanonicalName(name), args[0]);
        }

        if (name.startsWith("get")) {
            return dataContainer.get(getCanonicalName(name));
        }

        if (name.equals("toString")) {
            return dataContainer.toString();
        }

        return null;
    }

    private String getCanonicalName(String name) {
        return name.substring(2);
    }
}
