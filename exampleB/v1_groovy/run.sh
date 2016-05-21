

COMPILE_CLASSPATH=.
COMPILE_CLASSPATH=./lib/httpcore-4.4.4.jar:$COMPILE_CLASSPATH
COMPILE_CLASSPATH=./lib/httpclient-4.5.2.jar:$COMPILE_CLASSPATH
COMPILE_CLASSPATH=./lib/commons-logging-1.2.jar:$COMPILE_CLASSPATH
COMPILE_CLASSPATH=./lib/commons-codec-1.9.jar:$COMPILE_CLASSPATH

echo "compiling ..."
groovyc -cp $COMPILE_CLASSPATH RESTClient.groovy

RUNTIME_CLASSPATH=$GROOVY_HOME/embeddable/groovy-all-2.4.5.jar:$COMPILE_CLASSPATH

echo "running ..."
java -cp $RUNTIME_CLASSPATH RESTClient

