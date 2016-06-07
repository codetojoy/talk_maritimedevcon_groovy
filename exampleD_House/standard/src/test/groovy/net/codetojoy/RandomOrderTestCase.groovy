
package net.codetojoy;

public class RandomOrderTestCase extends GroovyTestCase {
    public void testBasic() {
        def order = new RandomOrder()
        def data = [1,2,3,4,5,6]

        // test 
        def result = order.order(data) 

        assert data.sort() == result.sort()
    }
}
