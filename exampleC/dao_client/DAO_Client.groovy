
import com.acme.flagship.dao.*

def dao = new AccountDao()
        
List<Account> accounts = dao.findAccountsByStatus(Account.CANCEL)

for (Account a : accounts) {
    System.out.println("TRACER  : " + a.getUsername())
}


