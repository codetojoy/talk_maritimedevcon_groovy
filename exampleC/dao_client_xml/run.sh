
COMPILE_CLASSPATH=../acme_dao/dist/acme-flagship-dao-1.0.jar

echo "compiling ..."
groovyc -cp $COMPILE_CLASSPATH DAO_Client_XML.groovy

RUNTIME_CLASSPATH=.
RUNTIME_CLASSPATH=../acme_dao/dist/*:$RUNTIME_CLASSPATH
RUNTIME_CLASSPATH=$HSQLDB_HOME/lib/hsqldb.jar:$RUNTIME_CLASSPATH
RUNTIME_CLASSPATH=$GROOVY_HOME/embeddable/groovy-all-2.4.5.jar:$RUNTIME_CLASSPATH

echo "running ..."
java -cp $RUNTIME_CLASSPATH DAO_Client_XML

