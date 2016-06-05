
import com.acme.flagship.dao.*

// This code illustrates that Groovy can use Java code that contains Java 8 features.
// AccountDao has a method called 'getAccountUsernamesByStatus'
// The method may not fit a DAO, per se, but is used as an illustration.

def list = []
list << new Account(accountId: 5150, username: "Jamie Sommers", status: Account.ACTIVE)
list << new Account(accountId: 5151, username: "James Bond", status: Account.ACTIVE)
list << new Account(accountId: 5152, username: "Blanche White", status: Account.ACTIVE)
list << new Account(accountId: 5153, username: "Jason Bourne", status: Account.BLOCK)
list << new Account(accountId: 5154, username: "Maxwell Smart", status: Account.CANCEL)

def dao = new AccountDao()

def results = dao.getAccountUsernamesByStatus(list, Account.ACTIVE, 2);

assert 2 == results.size()
assert "Blanche White" == results.get(0)
assert "James Bond" == results.get(1)

println "Ready."        
