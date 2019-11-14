package maybeUseful.proxies.examples;

import maybeUseful.proxies.examples.exampleClasses.transactional.InterfaceWithTransactions;
import maybeUseful.proxies.examples.exampleClasses.transactional.InterfaceWithTransactionsImpl;
import maybeUseful.proxies.examples.exampleClasses.transactional.TransactionInvocationHandler;

import java.lang.reflect.Proxy;

public class TransactionalExample {
    public void execute() {
        Class<InterfaceWithTransactions> interfaceWithTransactionsClass = InterfaceWithTransactions.class;

        InterfaceWithTransactions instance = (InterfaceWithTransactions) Proxy.newProxyInstance(
                interfaceWithTransactionsClass.getClassLoader(),
                new Class<?>[]{interfaceWithTransactionsClass},
                new TransactionInvocationHandler(new InterfaceWithTransactionsImpl())
        );

        instance.doImportantWork();

        instance.notSoImportantWork();
    }
}
