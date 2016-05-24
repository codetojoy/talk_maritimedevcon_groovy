
import com.acme.flagship.dao.*

def dao = new AccountDao()
        
List<Account> accounts = dao.findAccountsByStatus(Account.CANCEL)

System.out.println("cancelled accounts :")

for (Account a : accounts) {
    System.out.println("account id: " + a.getAccountId() + " username: " + a.getUsername())
}


