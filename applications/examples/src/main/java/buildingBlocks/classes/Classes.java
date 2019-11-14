package buildingBlocks.classes;

import java.util.ArrayList;

public class Classes {
    public static void main(String[] args) {
        // Two ways to get access to the class object for a given class

        // 1
        Class<ArrayList> arrayListClass = ArrayList.class;

        // 2
        ArrayList<String> arrayList = new ArrayList<>();
        Class<? extends ArrayList> arrayListInstanceClass = arrayList.getClass();

        System.out.println(arrayListClass == arrayListInstanceClass);
    }
}
