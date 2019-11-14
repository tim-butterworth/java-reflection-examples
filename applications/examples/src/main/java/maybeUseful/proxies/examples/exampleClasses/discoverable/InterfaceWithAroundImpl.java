package maybeUseful.proxies.examples.exampleClasses.discoverable;

import java.util.Random;

public class InterfaceWithAroundImpl implements InterfaceWithAround {
    @Override
    public void doImportantStuff() {
        System.out.println("Doing Important Stuff!");

        Random random = new Random();

        if (random.nextInt(10) > 5) {
            throw new RuntimeException("Something went wrong with the important stuff :(");
        }
    }

    @Override
    public void doLessImportantStuff() {
        System.out.println("This is much less important");
    }
}
