package where.classes.are;

import java.util.Optional;

public class SafeStack {
    private StackNode rootNode;

    public SafeStack() {
        this.rootNode = new EmptyNode();
    }

    public void push(Object value) {
        rootNode = new DataNode(value, rootNode);
    }

    public Optional<Object> pop() {
        Optional<Object> value = rootNode.getValue();

        rootNode = rootNode.nextNode();

        return value;
    }

    public Boolean isEmpty() {
        return rootNode.isEmpty();
    }
}
