package maybeUseful.dependencyInjection;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import maybeUseful.dependencyInjection.container.DependencyInjectionContainer;
import maybeUseful.dependencyInjection.exampleClasses.RootObject;

public class DependencyInjectionRunner {
    public static void main(String[] args) {
        DependencyInjectionContainer dependencyInjectionContainer = new DependencyInjectionContainer();

        RootObject instance = dependencyInjectionContainer.getInstance(RootObject.class);

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();

        try {
            System.out.println(objectWriter.writeValueAsString(instance));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
