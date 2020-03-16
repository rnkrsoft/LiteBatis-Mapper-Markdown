package com.rnkrsoft._3rd.org.commonmark.node;

public class ListItem extends Block {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
