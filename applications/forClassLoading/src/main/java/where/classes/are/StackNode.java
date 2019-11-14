package where.classes.are;

import java.util.Optional;

public interface StackNode {
    Optional<Object> getValue();
    StackNode nextNode();
    Boolean isEmpty();
}
