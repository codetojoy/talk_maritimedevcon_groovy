
package com.acme.flagship.dao;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNT")
@NamedQueries({
    @NamedQuery(name = "Account.findByUsername", query = "select a from Account a where a.username = :username") ,
    @NamedQuery(name = "Account.findByStatus", query = "select a from Account a where a.status = :status")
})
public class Account {
    public static final String ACTIVE = "active";
    public static final String BLOCK = "block";
    public static final String CANCEL = "cancel";

    @Id @GeneratedValue
    @Column(name = "account_id")
    private int accountId;

    @Column(name = "username")
    private String username;

    @Column(name = "status")
    private String status;

    public int getAccountId() { return accountId; }
    public void setAccountId(int accountId) { this.accountId = accountId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
