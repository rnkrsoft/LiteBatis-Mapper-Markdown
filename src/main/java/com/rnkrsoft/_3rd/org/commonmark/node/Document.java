package com.rnkrsoft._3rd.org.commonmark.node;

public class Document extends Block {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
