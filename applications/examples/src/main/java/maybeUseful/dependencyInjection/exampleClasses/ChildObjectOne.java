package maybeUseful.dependencyInjection.exampleClasses;

public class ChildObjectOne {

    private final GrandChildObjectOneOne grandChildObjectOneOne;
    private final GrandChildObjectOneTwo grandChildObjectOneTwo;
    private final GrandChildObjectOneThree grandChildObjectOneThree;

    public ChildObjectOne(
            GrandChildObjectOneOne grandChildObjectOneOne,
            GrandChildObjectOneTwo grandChildObjectOneTwo,
            GrandChildObjectOneThree grandChildObjectOneThree
    ) {
        this.grandChildObjectOneOne = grandChildObjectOneOne;
        this.grandChildObjectOneTwo = grandChildObjectOneTwo;
        this.grandChildObjectOneThree = grandChildObjectOneThree;
    }

    public GrandChildObjectOneOne getGrandChildObjectOneOne() {
        return grandChildObjectOneOne;
    }

    public GrandChildObjectOneTwo getGrandChildObjectOneTwo() {
        return grandChildObjectOneTwo;
    }

    public GrandChildObjectOneThree getGrandChildObjectOneThree() {
        return grandChildObjectOneThree;
    }

    @Override
    public String toString() {
        return "ChildObjectOne\n{" +
                "\ngrandChildObjectOneOne=" + grandChildObjectOneOne +
                "\n, grandChildObjectOneTwo=" + grandChildObjectOneTwo +
                "\n, grandChildObjectOneThree=" + grandChildObjectOneThree +
                "\n}";
    }
}
