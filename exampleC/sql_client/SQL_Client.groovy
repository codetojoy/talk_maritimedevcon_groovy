
@Grab('org.hsqldb:hsqldb:2.3.4')
@GrabConfig(systemClassLoader=true)

import groovy.sql.*
import org.hsqldb.jdbc.JDBCDataSource

def dataSource = new JDBCDataSource(database: "jdbc:hsqldb:mem:MDC", user: 'sa', password: '')
def sql = new Sql(dataSource)

sql.execute """
DROP TABLE account IF EXISTS
"""

sql.execute """
CREATE TABLE account( account_id bigint NOT NULL,
username VARCHAR(256) NOT NULL,
status VARCHAR(256)
);
"""

def accountInsert = " INSERT INTO account (account_id, username, status) VALUES (?,?,?); "

sql.execute accountInsert, [100, 'James_Bond',     'active']
sql.execute accountInsert, [120, 'Jason_Bourne',   'cancel']
sql.execute accountInsert, [130, 'Emily_Pollifax', 'cancel']
sql.execute accountInsert, [170, 'Maxwell_Smart',  'block']
sql.execute accountInsert, [190, 'Jaime_Sommers',  'active']
sql.execute accountInsert, [200, 'Blanche_White',  'active']

sql.eachRow("SELECT account_id, username, status FROM account") { row ->
    println "account_id: ${row.account_id} username: ${row.username} status: ${row.status}"
}

sql.close()

