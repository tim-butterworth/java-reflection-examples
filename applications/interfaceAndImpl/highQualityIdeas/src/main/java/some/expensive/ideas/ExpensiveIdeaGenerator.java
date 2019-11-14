package some.expensive.ideas;

import some.great.ideas.GreatIdeaGenerator;

public class ExpensiveIdeaGenerator implements GreatIdeaGenerator {
    @Override
    public String giveMeAGreatIdea() {
        System.out.println("Charging $1,000,000 good advice is not cheap!");

        return "Try mixing in a little block-chain";
    }
}
