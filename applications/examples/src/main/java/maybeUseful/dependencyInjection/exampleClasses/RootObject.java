package maybeUseful.dependencyInjection.exampleClasses;

public class RootObject {

    private final ChildObjectOne childObjectOne;
    private final ChildObjectTwo childObjectTwo;
    private final ChildObjectThree childObjectThree;

    public RootObject(ChildObjectOne childObjectOne, ChildObjectTwo childObjectTwo, ChildObjectThree childObjectThree) {
        this.childObjectOne = childObjectOne;
        this.childObjectTwo = childObjectTwo;
        this.childObjectThree = childObjectThree;
    }

    public ChildObjectOne getChildObjectOne() {
        return childObjectOne;
    }

    public ChildObjectTwo getChildObjectTwo() {
        return childObjectTwo;
    }

    public ChildObjectThree getChildObjectThree() {
        return childObjectThree;
    }

    @Override
    public String toString() {
        return "RootObject\n{" +
                "\nchildObjectOne=" + childObjectOne +
                "\n, childObjectTwo=" + childObjectTwo +
                "\n, childObjectThree=" + childObjectThree +
                "\n}";
    }
}
