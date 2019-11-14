package maybeUseful.proxies.examples.exampleClasses.discoverable;

public interface InterfaceWithAround {

    @Around(handler = Transaction.class)
    void doImportantStuff();
    void doLessImportantStuff();
}
