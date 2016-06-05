
import com.acme.flagship.dao.*

import static java.util.stream.Collectors.toList
import static java.util.Comparator.comparing


// This code illustrates that Groovy can use Java code that contains Java 8 features.
// AccountDao has a method called 'getAccountUsernamesByStatus'
// The method may not fit a DAO, per se, but is used as an illustration.

def getAccountUsernamesByStatus = {List<Account> accounts, String status, int numAccounts ->
        return accounts.stream()
                      // Java 8:
                      // .filter(acc -> acc.getStatus().equals(status))
                      // .sorted(comparing(Account::getAccountId).reversed())
                      // .map(Account::getUsername)
                      // .limit(numAccounts)
                      // .collect(toList())

                      // Groovy:
                         .filter( { acc -> acc.getStatus().equals(status) } )
                         .sorted(comparing( { acc -> acc.accountId } ).reversed())
                         .map( { acc -> acc.username } )
                         .limit(numAccounts)
                         .collect(toList())
}

def list = []
list << new Account(accountId: 5150, username: "Jamie Sommers", status: Account.ACTIVE)
list << new Account(accountId: 5151, username: "James Bond", status: Account.ACTIVE)
list << new Account(accountId: 5152, username: "Blanche White", status: Account.ACTIVE)
list << new Account(accountId: 5153, username: "Jason Bourne", status: Account.BLOCK)
list << new Account(accountId: 5154, username: "Maxwell Smart", status: Account.CANCEL)

def results = getAccountUsernamesByStatus(list, Account.ACTIVE, 2)

assert 2 == results.size()
assert "Blanche White" == results.get(0)
assert "James Bond" == results.get(1)

println "Ready."        
