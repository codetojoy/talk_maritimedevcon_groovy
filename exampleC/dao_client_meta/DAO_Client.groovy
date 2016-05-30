
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

def timedOperationInMillis = timedOperation.curry(TimeUnit.MILLISECONDS)

AccountDao.metaClass.timedFindAccountsByStatus = { status ->
    return timedOperationInMillis(delegate.&findAccountsByStatus, status)
}






// ----- main

AccountDao dao = new AccountDao()

Map pair = dao.timedFindAccountsByStatus(Account.ACTIVE)

long elapsed = pair['elapsed']
List accounts = pair['results']

System.out.println("elapsed    : ${elapsed} ms")

accounts.each { acc ->
    System.out.println "account id: " + acc.getAccountId() + " username: " + acc.getUsername()
}
 
