package org.hbrs.se1.ws21.uebung3.persistence;

import org.hbrs.se1.ws21.uebung2.Member;

import java.util.List;

public class PresistenceStrategyImpl implements PersistenceStrategy<Member>{
    private PersistenceStrategyStream<Member> persistenceStrategyStream;

    @Override
    public void openConnection() throws PersistenceException {
        persistenceStrategyStream = new PersistenceStrategyStream<>();
        persistenceStrategyStream.openConnection();
    }

    @Override
    public void closeConnection() throws PersistenceException {
        persistenceStrategyStream.closeConnection();
    }

    @Override
    public void save(List<Member> member) throws PersistenceException {
        persistenceStrategyStream.save(member);

    }

    @Override
    public List<Member> load() throws PersistenceException {
        return persistenceStrategyStream.load();
    }
}
