
package com.acme.flagship.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.*;

import static java.util.stream.Collectors.toList;
import static java.util.Comparator.comparing;

import java.util.function.*;

// see src/main/resources/META-INF/persistence.xml for config

public class AccountDao {
    private final String DB = Constants.DB;
    
    private static boolean isDatabaseCreated = false;

    public AccountDao() {
        // This example uses in-memory HSQL so we need to create DB and populate data.
        if (! isDatabaseCreated) {
            new DatabaseUtils().createDatabase();
            isDatabaseCreated = true;
        }
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

    /*
     * This method is intended to illustrate Java 8 features. It accepts a list of Accounts and
     * returns N account usernames, where accounts have the specified status. The results are
     * sorted by account id (descending order).
     *
     * This probably doesn't belong in a DAO object, but it is just an illustration.
     */
    public List<String> getAccountUsernamesByStatus(List<Account> accounts, String status, int numAccounts) {
        return accounts.stream()
                      .filter(acc -> acc.getStatus().equals(status))
                      .sorted(comparing(Account::getAccountId).reversed())
                      .map(Account::getUsername)
                      .limit(numAccounts)
                      .collect(toList());
    }
}
