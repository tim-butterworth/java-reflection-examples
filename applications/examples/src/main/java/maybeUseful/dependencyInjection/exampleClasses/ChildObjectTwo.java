package maybeUseful.dependencyInjection.exampleClasses;

public class ChildObjectTwo {

    private final String childTwoName;
    private final Long childTwoLong;


    public ChildObjectTwo(String childTwoName, Long childTwoLong) {
        this.childTwoName = childTwoName;
        this.childTwoLong = childTwoLong;
    }

    public String getChildTwoName() {
        return childTwoName;
    }

    public Long getChildTwoLong() {
        return childTwoLong;
    }

    @Override
    public String toString() {
        return "ChildObjectTwo{" +
                "childTwoName='" + childTwoName + '\'' +
                ", childTwoLong=" + childTwoLong +
                '}';
    }
}
