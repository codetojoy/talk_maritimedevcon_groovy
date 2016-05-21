
import com.acme.flagship.dao.*

def dao = new AccountDao()
dao.initialize()
        
def account = dao.findAccountByUsername("Mozart")

if (account != null) { 
    System.out.println("TRACER account : " + account.getAccountId())
}

List<Account> accounts = dao.findAccountsByStatus(Account.CANCEL)

for (Account a : accounts) {
    System.out.println("TRACER  : " + a.getUsername())
}


