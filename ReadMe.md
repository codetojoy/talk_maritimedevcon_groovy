
### Groovy examples

* Example A Log Files

* Example B REST client

* Example C Acme Dao / persistence
    * sql_client : does not use Acme-Dao jar, uses JDBC
    * dao_client : simple usage of Acme-Dao jar
    * **Post-Talk** dao_client_using_java8 : simple usage of Java 8 method in Acme-Dao jar
    * **Post-Talk** dao_client_with_streams : comparison of Java 8 syntax vs Groovy syntax re: streams
    * dao_client_xml : generate XML with MarkupBuilder
    * dao_client_servlet : use a Groovy script as a servlet 
    * dao_client_meta : use meta-programming to add method to `AccountDao`

* These examples require Groovy:
    * see http://www.groovy-lang.org/
    * Installation is standard:
        * unzip 
        * define GROOVY_HOME env var
        * add GROOVY_HOME/bin to PATH

* Some examples require Gradle:
    * see http://gradle.org 
    * Installation is standard:
        * unzip 
        * define GRADLE_HOME env var
        * add GRADLE_HOME/bin to PATH

