
package net.codetojoy;

public class EchoFormatterTestCase extends GroovyTestCase {
    public void testBasic() {
        def formatter = new EchoFormatter()
        def data = [1,2,3]

        // test 
        def result = formatter.format(data) 

        assert [[1,1], [2,2], [3,3]] == result
    }
}
