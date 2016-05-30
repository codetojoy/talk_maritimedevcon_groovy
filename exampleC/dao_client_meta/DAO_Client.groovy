
import com.acme.flagship.dao.*

import java.util.concurrent.TimeUnit

def timedOperation = { timeUnit, f, x -> 
    def pair = [:]

    long before = System.nanoTime()
    
    def results = f(x)

    long after = System.nanoTime()

    pair['results'] = results
    pair['elapsed'] = timeUnit.convert((after - before), TimeUnit.NANOSECONDS)

    return pair
}

AccountDao.metaClass.timedFindAccountsByStatus = { status ->
    return timedOperation(TimeUnit.MILLISECONDS, delegate.&findAccountsByStatus, status)
}

// ----- main

AccountDao dao = new AccountDao()

Map pair = dao.timedFindAccountsByStatus(Account.ACTIVE)

System.out.println "elapsed    : " + pair['elapsed'] + " ms" 

pair['results'].each { acc ->
    System.out.println "account id: " + acc.getAccountId() + " username: " + acc.getUsername()
}
 
