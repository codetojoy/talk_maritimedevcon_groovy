
package net.codetojoy;

public class DefaultOrderTestCase extends GroovyTestCase {
    public void testBasic() {
        def order = new DefaultOrder()
        def data = [1,2,3,4,5,6]

        // test 
        def result = order.order(data) 

        assert data == result
    }
}
