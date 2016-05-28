
import com.acme.flagship.dao.*

def status = request.getParameter('status')

def dao = new AccountDao()

html.html {
  head {
    title 'Maritime DevCon'
  }
  body {
    h3("accounts for ${status}")
    
    ul {
        dao.findAccountsByStatus(status).each { account ->
            li("Username : ${account.username} , Account Id : ${account.accountId}")
        }
    }
  }
}
