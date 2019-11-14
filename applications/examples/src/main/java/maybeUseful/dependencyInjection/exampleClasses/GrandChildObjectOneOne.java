package maybeUseful.dependencyInjection.exampleClasses;

public class GrandChildObjectOneOne {
    private final String name;

    public GrandChildObjectOneOne(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "GrandChildObjectOneOne{" +
                "name='" + name + '\'' +
                '}';
    }
}
