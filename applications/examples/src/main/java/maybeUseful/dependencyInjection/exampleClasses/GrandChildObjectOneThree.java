package maybeUseful.dependencyInjection.exampleClasses;

public class GrandChildObjectOneThree {
    private final Integer integer;

    public GrandChildObjectOneThree(Integer integer) {
        this.integer = integer;
    }

    public Integer getInteger() {
        return integer;
    }

    @Override
    public String toString() {
        return "GrandChildObjectOneThree{" +
                "integer=" + integer +
                '}';
    }
}
