package where.classes.are;

import java.util.Optional;

public class DataNode implements StackNode {

    private final Object value;
    private final StackNode nextNode;

    public DataNode(Object value, StackNode nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }

    @Override
    public Optional<Object> getValue() {
        return Optional.of(value);
    }

    @Override
    public StackNode nextNode() {
        return nextNode;
    }

    @Override
    public Boolean isEmpty() {
        return false;
    }
}
