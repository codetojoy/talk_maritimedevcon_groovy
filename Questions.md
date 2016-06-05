
### Questions from *Covert Ops: Transform Your Java Team (From The Inside!) With Groovy* (slides [here](http://codetojoy.github.io/talk_maritimedevcon_groovy/assets/player/KeynoteDHTMLPlayer.html#0)) at [Maritime Dev Con 2016](http://maritimedevcon.ca/) 

* **Q:** If the Acme-Dao jar uses Java 8 features, can we still use it with Groovy?
    * A: Yes, with Groovy 2.3 or higher. In [Example_C_Acme_Dao](http://bit.ly/25FKJoO), there is a new method, `getAccountUsernamesByStatus()` in [AccountDao](http://bit.ly/1ZphhzN). It uses Java 8 extensively and is illustrated [here](http://bit.ly/1PxmGV4).

* **Q:** Can we use Java 8 streams in Groovy?
    * A: Yes, with some changes in syntax. Check out [this implementation](http://bit.ly/1O9nsr1) of `AccountDao.getAccountUsernamesByStatus()` 

* **Q:** Aside from Java 8 lambdas and method references, are there other syntax differences between Groovy and Java?
    * A: Yes [here is a list](http://groovy-lang.org/differences.html). e.g. Groovy redefines `==`

* **Q:** Can we use [Grapes] with a repository that is not Maven Central?
    * A: Yes, see [Section 1.2](http://docs.groovy-lang.org/latest/html/documentation/grape.html)
    * I hope to illustrate this with an example using the Acme-Dao jar, but that will take some time.

