
import com.acme.flagship.dao.*

def status = request.getParameter('status').toLowerCase()

def dao = new AccountDao()

html.html {
  head {
    title 'Maritime DevCon'
  }
  body {
    h3("accounts for ${status}")
    
    ul {
        dao.findAccountsByStatus(status).each { account ->
            p("Username : ${account.username} , Account Id : ${account.accountId}")
        }
    }
  }
}
