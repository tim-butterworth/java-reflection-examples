package maybeUseful.proxies.examples.exampleClasses.transactional;

public interface InterfaceWithTransactions {

    @Transactional
    void doImportantWork();
    void notSoImportantWork();

}
