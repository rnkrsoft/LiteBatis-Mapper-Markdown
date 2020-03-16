package com.rnkrsoft._3rd.org.commonmark.internal;

import com.rnkrsoft._3rd.org.commonmark.node.Block;
import com.rnkrsoft._3rd.org.commonmark.node.Document;
import com.rnkrsoft._3rd.org.commonmark.parser.block.AbstractBlockParser;
import com.rnkrsoft._3rd.org.commonmark.parser.block.BlockContinue;
import com.rnkrsoft._3rd.org.commonmark.parser.block.ParserState;

public class DocumentBlockParser extends AbstractBlockParser {

    private final Document document = new Document();

    @Override
    public boolean isContainer() {
        return true;
    }

    @Override
    public boolean canContain(Block block) {
        return true;
    }

    @Override
    public Document getBlock() {
        return document;
    }

    @Override
    public BlockContinue tryContinue(ParserState state) {
        return BlockContinue.atIndex(state.getIndex());
    }

    @Override
    public void addLine(CharSequence line) {
    }

}
