package com.rnkrsoft.litebatis.mapper.markdown;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by test on 2020/3/16.
 */
public class MarkdownMapperLoaderTest {

    @Test
    public void testLoad() throws Exception {
        MarkdownMapperLoader loader = new MarkdownMapperLoader();
        loader.load("classpath:demo.md");
    }
}