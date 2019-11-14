package some.meh.ideas.you.get.what.you.payFor;

import some.great.ideas.GreatIdeaGenerator;

public class MehIdeaGenerator implements GreatIdeaGenerator {
    @Override
    public String giveMeAGreatIdea() {
        System.out.println("Only charging $0.01, but the advice is really not good.");

        return "Try adding some block-chain";
    }
}
