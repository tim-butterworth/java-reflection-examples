package maybeUseful.dependencyInjection.exampleClasses;

public class GrandChildObjectOneTwo {

    private final Long l;

    public GrandChildObjectOneTwo(Long l) {
        this.l = l;
    }

    public Long getL() {
        return l;
    }

    @Override
    public String toString() {
        return "GrandChildObjectOneTwo{" +
                "l=" + l +
                '}';
    }
}
