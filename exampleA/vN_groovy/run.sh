
echo "compiling ..."
groovyc LogReporter.groovy

CLASSPATH=.
CLASSPATH=$GROOVY_HOME/embeddable/groovy-all-2.4.5.jar:$CLASSPATH

echo "running ..."
java -cp $CLASSPATH LogReporter ../data
