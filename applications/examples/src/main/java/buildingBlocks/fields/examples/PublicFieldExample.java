package buildingBlocks.fields.examples;

import buildingBlocks.fields.exampleClasses.ClassWithFields;

import java.lang.reflect.Field;

public class PublicFieldExample {
    public void execute() {
        ClassWithFields classWithFields = new ClassWithFields();

        try {
            Field publicField = ClassWithFields.class.getField("publicString");

            try {
                Object value = publicField.get(classWithFields);

                System.out.println("[" + value + "]");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }



    }
}
