
### Example C - DAO / persistence layer client 

* See ReadMe.txt in root directory for installation notes for Groovy and Gradle

* Setup for SQL client. this example uses HSQL database
    * see http://hsqldb.org/ and install
    * set HSQLDB_HOME env var

* Step 1. run the SQL client:

<pre>
$ cd sql_client
$ ./run.sh
</pre>

This does not use the Acme DAO jar or Hibernate, just simple JDBC access.

* Step 2.1. build Acme DAO jar:

<pre>
$ cd dao
$ gradle doBuild
</pre>

This will build acme-flagship-dao-1.0.jar in ~/dao/dist and copy all 3rd-party jars
(including transitive dependencies).

* Step 2.2. use Acme DAO jar with a client:

<pre>
$ cd dao_client
$ ./run.sh 
</pre>

