package maybeUseful.dependencyInjection.exampleClasses;

public class ChildObjectThree {

    private final String childThreeName;
    private final Integer childThreeAge;

    public ChildObjectThree(String childThreeName, Integer childThreeAge) {
        this.childThreeName = childThreeName;
        this.childThreeAge = childThreeAge;
    }

    public String getChildThreeName() {
        return childThreeName;
    }

    public Integer getChildThreeAge() {
        return childThreeAge;
    }

    @Override
    public String toString() {
        return "ChildObjectThree{" +
                "childThreeName='" + childThreeName + '\'' +
                ", childThreeAge=" + childThreeAge +
                '}';
    }
}
