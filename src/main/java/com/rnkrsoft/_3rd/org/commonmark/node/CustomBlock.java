package com.rnkrsoft._3rd.org.commonmark.node;

public abstract class CustomBlock extends Block {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
