
package net.codetojoy;

public class DefaultFormatterTestCase extends GroovyTestCase {
    public void testBasic() {
        def formatter = new DefaultFormatter()
        def data = [1,2,3,4,5,6]

        // test 
        def result = formatter.format(data) 

        assert data == result
    }
}
