package com.rnkrsoft._3rd.org.commonmark.parser.block;

import com.rnkrsoft._3rd.org.commonmark.node.Block;
import com.rnkrsoft._3rd.org.commonmark.parser.InlineParser;

public abstract class AbstractBlockParser implements BlockParser {

    @Override
    public boolean isContainer() {
        return false;
    }

    @Override
    public boolean canHaveLazyContinuationLines() {
        return false;
    }

    @Override
    public boolean canContain(Block childBlock) {
        return false;
    }

    @Override
    public void addLine(CharSequence line) {
    }

    @Override
    public void closeBlock() {
    }

    @Override
    public void parseInlines(InlineParser inlineParser) {
    }

}
