
package net.codetojoy;

// This class is not featured in the "Nothing is Something" video, but
// IMHO it is a natural extension.
//
// When f(x) is called, this returns 'x' for any x *and* any f.

class Reflexive {
    def methodMissing(String name, def args) {
        // TODO: consider behaviour for f(x,y,z) etc
        args[0]
    }
}

