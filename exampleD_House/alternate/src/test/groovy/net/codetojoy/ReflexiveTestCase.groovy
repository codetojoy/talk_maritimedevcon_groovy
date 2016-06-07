
package net.codetojoy;

public class ReflexiveTestCase extends GroovyTestCase {
    public void testBasic() {
        def order = new Reflexive()
        def data = [1,2,3,4,5,6]

        // test 
        def result = order.order(data) 

        assert data == result
    }

    public void testIdempotence() {
        def reflex = new Reflexive()
        def x = 10

        // test 
        def result = reflex.h(reflex.g(reflex.f(x)))

        assert x == result
    }
}
