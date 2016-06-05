
package com.acme.flagship.dao;

import java.util.*;

import org.junit.*;
import static org.junit.Assert.*;

public class AccountDaoTestCase {

    protected Account buildAccount(int accountId, String status, String username) {
        Account account = new Account();
        account.setAccountId(accountId);
        account.setStatus(status);
        account.setUsername(username);
        return account;
    }

    @Test 
    public void testGetAccountUsernamesByStatus_Basic() {
        List<Account> list = new ArrayList<Account>();
        list.add( buildAccount(5150, Account.ACTIVE, "Jaime Sommers") );
        list.add( buildAccount(5151, Account.ACTIVE, "James Bond") );
        list.add( buildAccount(5152, Account.ACTIVE, "Blanche White") );
        list.add( buildAccount(5153, Account.BLOCK,  "Jason Bourne") );
        list.add( buildAccount(5154, Account.CANCEL, "Maxwell Smart") );

        AccountDao accountDao = new AccountDao();

        // test 
        List<String> results = accountDao.getAccountUsernamesByStatus(list, Account.ACTIVE, 2);

        assertEquals(2, results.size());
        assertEquals("Blanche White", results.get(0));
        assertEquals("James Bond", results.get(1));
    }
}
