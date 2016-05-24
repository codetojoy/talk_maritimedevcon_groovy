
import com.acme.flagship.dao.*

import groovy.xml.*

def dao = new AccountDao()
        
def writer = new StringWriter()
def builder = new MarkupBuilder(writer)

builder.accounts() {
    active() {
        dao.findAccountsByStatus(Account.ACTIVE).each { acc ->
            account(id: "${acc.accountId}", username: "${acc.username}")
        }
    }
} 

println writer
