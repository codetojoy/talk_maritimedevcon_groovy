
import com.acme.flagship.dao.*

import java.util.concurrent.TimeUnit

AccountDao.metaClass.timedFindAccountsByStatus = { status ->
    long before = System.nanoTime()
    
    def accounts = delegate.findAccountsByStatus(status)

    long after = System.nanoTime()

    println "elapsed: " + TimeUnit.MILLISECONDS.convert((after - before), TimeUnit.NANOSECONDS) + " ms"
}

// ----- main

def dao = new AccountDao()

dao.timedFindAccountsByStatus(Account.ACTIVE)
 
