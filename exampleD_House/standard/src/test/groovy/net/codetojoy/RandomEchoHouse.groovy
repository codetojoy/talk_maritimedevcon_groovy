
package net.codetojoy;

public class RandomEchoHouseTestCase extends GroovyTestCase {
    public void testDefaultOrder() {
        def house = new House(new RandomOrder(), new EchoFormatter())

        // test 
        def results = house.parts(3)

        // we expect pairs like this:
        // 
        // [the horse and the hound and the horn that belonged to, the horse and the hound and the horn that belonged to]
        // [the priest all shaven and shorn that married, the priest all shaven and shorn that married]
        // [the house that Jack built, the house that Jack built]

        assert 3 == results.size()

        results.each { pair ->
            assert 2 == pair.size()
            assert pair[0] == pair[1]
        }
    }
}
