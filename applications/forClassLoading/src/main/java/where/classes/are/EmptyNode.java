package where.classes.are;

import java.util.Optional;

public class EmptyNode implements StackNode {
    @Override
    public Optional<Object> getValue() {
        return Optional.empty();
    }

    @Override
    public StackNode nextNode() {
        return this;
    }

    @Override
    public Boolean isEmpty() {
        return true;
    }
}
