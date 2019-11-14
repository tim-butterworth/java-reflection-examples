package maybeUseful.haveAnInterfaceMultipleImpl;

import maybeUseful.haveAnInterfaceMultipleImpl.examples.GreatIdeaGeneratorFactory;
import some.great.ideas.GreatIdeaGenerator;

public class InterfaceMultipleImplRunner {
    public static void main(String[] args) {
        GreatIdeaGenerator greatIdeaGenerator = new GreatIdeaGeneratorFactory().getInstance();

        System.out.println(greatIdeaGenerator.giveMeAGreatIdea());
    }
}
