package buildingBlocks.fields.examples;

import buildingBlocks.fields.exampleClasses.ClassWithFields;

import java.lang.reflect.Field;

public class PrivateFieldExample {
    public void execute() {
        ClassWithFields classWithFields = new ClassWithFields();

        Class<ClassWithFields> classWithFieldsClass = ClassWithFields.class;

        try {
            Field privateString = classWithFieldsClass.getDeclaredField("privateString");

            privateString.setAccessible(true);

            Object privateValue = privateString.get(classWithFields);

            System.out.println("[" + privateValue + "]");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
