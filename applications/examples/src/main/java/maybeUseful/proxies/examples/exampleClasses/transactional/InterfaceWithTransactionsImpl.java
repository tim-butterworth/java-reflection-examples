package maybeUseful.proxies.examples.exampleClasses.transactional;

import java.util.Random;

public class InterfaceWithTransactionsImpl implements InterfaceWithTransactions {
    @Override
    public void doImportantWork() {
        Random random = new Random();

        if (random.nextInt(10) > 5) {
            throw new RuntimeException("The database is down");
        }
    }

    @Override
    public void notSoImportantWork() {
        System.out.println("This work is not so important");
    }
}
