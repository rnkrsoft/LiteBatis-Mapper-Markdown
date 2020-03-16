package com.rnkrsoft._3rd.org.commonmark.node;

public class HardLineBreak extends Node {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
