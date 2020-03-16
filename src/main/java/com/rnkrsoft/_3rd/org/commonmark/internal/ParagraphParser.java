package com.rnkrsoft._3rd.org.commonmark.internal;

import com.rnkrsoft._3rd.org.commonmark.node.Block;
import com.rnkrsoft._3rd.org.commonmark.node.LinkReferenceDefinition;
import com.rnkrsoft._3rd.org.commonmark.node.Paragraph;
import com.rnkrsoft._3rd.org.commonmark.parser.InlineParser;
import com.rnkrsoft._3rd.org.commonmark.parser.block.AbstractBlockParser;
import com.rnkrsoft._3rd.org.commonmark.parser.block.BlockContinue;
import com.rnkrsoft._3rd.org.commonmark.parser.block.ParserState;

import java.util.List;

public class ParagraphParser extends AbstractBlockParser {

    private final Paragraph block = new Paragraph();
    private LinkReferenceDefinitionParser linkReferenceDefinitionParser = new LinkReferenceDefinitionParser();

    @Override
    public boolean canHaveLazyContinuationLines() {
        return true;
    }

    @Override
    public Block getBlock() {
        return block;
    }

    @Override
    public BlockContinue tryContinue(ParserState state) {
        if (!state.isBlank()) {
            return BlockContinue.atIndex(state.getIndex());
        } else {
            return BlockContinue.none();
        }
    }

    @Override
    public void addLine(CharSequence line) {
        linkReferenceDefinitionParser.parse(line);
    }

    @Override
    public void closeBlock() {
        if (linkReferenceDefinitionParser.getParagraphContent().length() == 0) {
            block.unlink();
        }
    }

    @Override
    public void parseInlines(InlineParser inlineParser) {
        CharSequence content = linkReferenceDefinitionParser.getParagraphContent();
        if (content.length() > 0) {
            inlineParser.parse(content.toString(), block);
        }
    }

    public CharSequence getContentString() {
        return linkReferenceDefinitionParser.getParagraphContent();
    }

    public List<LinkReferenceDefinition> getDefinitions() {
        return linkReferenceDefinitionParser.getDefinitions();
    }
}
