package buildingBlocks.constructors.examples.constructorClasses;

import java.util.List;

public class ClassWithMultiArgumentConstructor {

    private final String string;
    private final Integer integer;
    private final List<String> list;

    public ClassWithMultiArgumentConstructor(
            String string,
            Integer integer,
            List<String> list
    ) {
        this.string = string;
        this.integer = integer;
        this.list = list;
    }

    public String getString() {
        return string;
    }

    public Integer getInteger() {
        return integer;
    }

    public List<String> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "ClassWithMultiArgumentConstructor{" +
                "string='" + string + '\'' +
                ", integer=" + integer +
                ", list=" + list +
                '}';
    }
}
