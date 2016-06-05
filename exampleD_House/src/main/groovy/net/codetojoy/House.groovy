
package net.codetojoy

class House {
    def formatter
    def data 

    House(orderer = new DefaultOrder(), formatter = new DefaultFormatter()) {
        data = orderer.order(DATA)
        this.formatter = formatter
    }

    def parts(number) {
        formatter.format(data.drop(data.size() - number))
    }

    static final def DATA = [
        'the horse and the hound and the horn that belonged to',
        'the farmer sowing his corn that kept',
        'the rooster that crowed in the morn that woke',
        'the priest all shaven and shorn that married',
        'the man all tattered and torn that kissed',
        'the maiden all forlorn that milked',
        'the cow with the crumped horn that tossed',
        'the dog that worried',
        'the cat that killed',
        'the rat that ate',
        'the malt that lay in',
        'the house that Jack built'
    ]
}
