package maybeUseful.proxies;

import maybeUseful.proxies.examples.DiscoverableExample;
import maybeUseful.proxies.examples.TransactionalExample;
import maybeUseful.proxies.examples.VanillaExample;

public class ProxiesRunner {
    public static void main(String[] args) {
//        new VanillaExample().execute();
//        new TransactionalExample().execute();
        new DiscoverableExample().execute();
    }
}
