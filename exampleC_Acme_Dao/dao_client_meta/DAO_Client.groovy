
import com.acme.flagship.dao.*

import groovy.transform.Immutable
import java.util.concurrent.TimeUnit

@Immutable
class Pair {
    List results
    long elapsed
}

def timedOperation = { timeUnit, f, x -> 
    long before = System.nanoTime()
    
    def y = f(x)

    long duration = timeUnit.convert(System.nanoTime() - before, TimeUnit.NANOSECONDS)

    return new Pair(results: y, elapsed: duration)
}

def timedOperationInMillis = timedOperation.curry(TimeUnit.MILLISECONDS)



AccountDao.metaClass.timedFindAccountsByStatus = { status ->
    return timedOperationInMillis(delegate.&findAccountsByStatus, status)
}






// ----- main

AccountDao dao = new AccountDao()

Pair pair = dao.timedFindAccountsByStatus(Account.ACTIVE)

System.out.println("elapsed    : ${pair.elapsed} ms")

pair.results.each { acc ->
    System.out.println "account id: " + acc.getAccountId() + " username: " + acc.getUsername()
}
 
