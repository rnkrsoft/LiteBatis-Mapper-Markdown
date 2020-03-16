package com.rnkrsoft._3rd.org.commonmark.node;

public abstract class CustomNode extends Node {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
