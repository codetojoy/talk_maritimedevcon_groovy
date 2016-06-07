
// This uses an HTML/Markup builder but an alternative is to write a string
// such as:
// 
// def html = """ 
// [pure html here]
// """
// response.getWriter.println(html)
//
// Groovlets are super-minimal. Stronger alternatives include Gaelyk and Grails.

import com.acme.flagship.dao.*

def status = request.getParameter('status')

if (status == null) {
    def allStatus = [Account.ACTIVE, Account.BLOCK, Account.CANCEL]
    def thisGroovlet = request.requestURL
    final def STATUS_STR = "status"

    html.html { 
        body {
            form(name: "simpleform", method: "get", action: thisGroovlet) {
                h3("Enter status:")
                br()
                allStatus.each { thisStatus ->
                    input(type: "radio", name: STATUS_STR, value: thisStatus) 
                    span("${thisStatus}")
                }
                br()
                input(type: "submit", value: "Go") 
            }
        }
    }
} else {
    def dao = new AccountDao()
    def accounts = dao.findAccountsByStatus(status)

    html.html { 
        body {
            h3("accounts for ${status}")

            ul {
                accounts.each { account ->
                    li("Username : ${account.username} , Account Id : ${account.accountId}")
                }
            }
        }
    }
}
