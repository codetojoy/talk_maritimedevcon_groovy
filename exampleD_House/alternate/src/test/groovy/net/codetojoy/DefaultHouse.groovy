
package net.codetojoy;

public class DefaultHouseTestCase extends GroovyTestCase {
    public void testDefaultOrder() {
        def house = new House()

        // test 
        def result = house.parts(3)

        assert 'the rat that ate' == result[0]
        assert 'the malt that lay in' == result[1]
        assert 'the house that Jack built' == result[2]
    }
}
