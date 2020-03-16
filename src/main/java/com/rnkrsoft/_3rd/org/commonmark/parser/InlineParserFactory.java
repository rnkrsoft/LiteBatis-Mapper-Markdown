package com.rnkrsoft._3rd.org.commonmark.parser;

/**
 * Factory for custom inline parser.
 */
public interface InlineParserFactory {
    InlineParser create(InlineParserContext inlineParserContext);
}
