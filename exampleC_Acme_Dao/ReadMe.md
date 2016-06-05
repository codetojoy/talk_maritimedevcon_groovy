
## Example C - DAO / persistence layer examples 

* See [ReadMe](http://bit.ly/20knOM8) in root directory for installation notes for Groovy and Gradle

### Setup

* Install HSQL database
    * see http://hsqldb.org/ 
    * set HSQLDB_HOME env var

### To run the SQL client:

<pre>
$ cd sql_client
$ ./run.sh
</pre>

* This does not use the Acme DAO jar or Hibernate, just simple JDBC access.

### To build the Acme DAO jar:

<pre>
$ cd dao
$ gradle doBuild
</pre>

This will build acme-flagship-dao-1.0.jar in ~/dao/dist and copy all 3rd-party jars
(including transitive dependencies).

### To use Acme DAO jar with the simple client:

<pre>
$ cd dao_client
$ ./run.sh 
</pre>

See `~/exampleC/acme_dao/.../DatabaseUtils.java` to see how the in-memory database is populated.

### To use Acme DAO jar with the XML client:

<pre>
$ cd dao_client_xml
$ ./run.sh 
</pre>

### To use a Java 8 method contained in the Acme DAO jar:

<pre>
$ cd dao_client_with_java8
$ ./run.sh 
</pre>

### To use Java 8 streams in Groovy:

<pre>
$ cd dao_client_using_streams
$ ./run.sh 
</pre>

### To use Acme DAO jar with the web client:

* start the web server with this:

<pre>
$ cd dao_client_servlet
$ ./run.sh 
</pre>

* then browse to `http://0.0.0.0:5150/DAO_Client.groovy?status=active`
* other status values include *block* and *cancel*

### To use Acme DAO jar with the meta-programming client:

<pre>
$ cd dao_client_meta
$ ./run.sh 
</pre>

