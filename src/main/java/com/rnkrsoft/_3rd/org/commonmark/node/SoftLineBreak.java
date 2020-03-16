package com.rnkrsoft._3rd.org.commonmark.node;

public class SoftLineBreak extends Node {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
