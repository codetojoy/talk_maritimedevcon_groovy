    
package com.acme.flagship.dao;

import java.sql.*;

public class DatabaseUtils {

    public void createDatabase() {
        Connection conn = null;
        Statement statement = null;

        try {
            Class.forName(Constants.JDBC_DRIVER);

            System.out.println("Connecting ...");
            conn = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASSWORD);
            System.out.println("Connected database successfully...");

            System.out.println("Creating table ...");
            statement = conn.createStatement();

            String sql = "CREATE TABLE ACCOUNT( account_id bigint NOT NULL, " + 
                                     " username VARCHAR(256) NOT NULL, " +
                                     " status VARCHAR(256) );";

            statement.executeUpdate(sql);
            System.out.println("Created table.");

            // This example uses HSQLDB as an in-memory database, 
            // and so we populate some rows here as a convenience.
            // (Normally, this would be absurd.)

            statement.execute( "INSERT INTO account (account_id, username, status) VALUES (100,'James_Bond','active');" );
            statement.execute( "INSERT INTO account (account_id, username, status) VALUES (120,'Jason_Bourne','cancel');" );
            statement.execute( "INSERT INTO account (account_id, username, status) VALUES (130,'Emily_Pollifax','cancel');" );
            statement.execute( "INSERT INTO account (account_id, username, status) VALUES (170,'Maxwell_Smart','block');" );
            statement.execute( "INSERT INTO account (account_id, username, status) VALUES (190,'Jaime_Sommers','active');" );
            statement.execute( "INSERT INTO account (account_id, username, status) VALUES (200,'Blanche_White','active');" );

            System.out.println("Populated seed rows.");

        } catch (Exception ex) {
            System.err.println("caught exception : " + ex);
        } finally {
            try { if (statement != null) statement.close(); } catch(Exception ex) {} 
            try { if (conn != null) conn.close(); } catch(Exception ex) {} 
        }
    } 
} 
