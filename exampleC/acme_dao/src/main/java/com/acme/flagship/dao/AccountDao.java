
package com.acme.flagship.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.*;

// see src/main/resources/META-INF/persistence.xml for config

public class AccountDao {
    private final String DB = Constants.DB;

    public void initialize() {
        new DatabaseUtils().createDatabase();
    }

    @SuppressWarnings("unchecked")
    public List<Account> findAccountsByStatus(String status) {
        EntityManager entityManager = Persistence.createEntityManagerFactory(DB).createEntityManager();
        
        List<Account> accounts = entityManager.createNamedQuery("Account.findByStatus", Account.class)
                                              .setParameter("status", status)
                                              .getResultList();

        entityManager.close();

        return accounts;
    }
    
    public Account findAccountByUsername(String username) {
        EntityManager entityManager = Persistence.createEntityManagerFactory(DB).createEntityManager();
        
        Account account = entityManager.createNamedQuery("Account.findByUsername", Account.class)
                                       .setParameter("username", username)
                                       .getSingleResult();

        entityManager.close();

        return account;
    }
}
