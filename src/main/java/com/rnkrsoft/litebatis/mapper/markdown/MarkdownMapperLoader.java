package com.rnkrsoft.litebatis.mapper.markdown;

import com.rnkrsoft._3rd.org.commonmark.node.*;
import com.rnkrsoft._3rd.org.commonmark.parser.Parser;
import com.rnkrsoft.litebatis.mapper.Classpath;
import com.rnkrsoft.litebatis.mapper.Mapper;
import com.rnkrsoft.litebatis.mapper.MapperLoader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by test on 2020/3/8.
 */
public class MarkdownMapperLoader implements MapperLoader {

    @Override
    public List<Mapper> load(String classpathMapperFileName) throws IOException {
        Classpath classpath = new Classpath(classpathMapperFileName);
        Reader reader = null;
       try {
           reader = classpath.loadAsReader(Charset.forName("UTF-8"));
           return load(reader);
       }finally {
           if (reader != null){
               reader.close();
           }
       }
    }

    @Override
    public List<Mapper> load(File mapperFile) {
        return null;
    }

    @Override
    public List<Mapper> load(URL mapperUrl) {
        return null;
    }

    @Override
    public List<Mapper> load(Reader reader)throws IOException{
        List<Mapper> mappers = new ArrayList<Mapper>();
        BufferedReader bufferReade = new BufferedReader(reader);
        Parser parser = Parser.builder().build();
        Node node = parser.parseReader(bufferReade);
        Document document = node.as(Document.class);
        parse(document, mappers);
        return mappers;
    }

    void parse(Document document, List<Mapper> mappers){
        final StringBuilder namespace = new StringBuilder();
        Visitor visitor = new AbstractVisitor() {
            @Override
            public void visit(FencedCodeBlock fencedCodeBlock) {
                if (namespace.length() == 0){
                    if (fencedCodeBlock.getFenceIndent() == 0) {
                        String str = fencedCodeBlock.getLiteral();
                        int eqIndex = -1;
                        if (str.startsWith("-- ") && (eqIndex = str.indexOf("$namespace=")) > -1) {
                            namespace.append(str.substring(eqIndex + "$namespace=".length()));
                        }
                    }
                }else{
                    System.out.println(fencedCodeBlock.getLiteral());
                }
            }

            @Override
            public void visit(Heading heading) {
                super.visit(heading);
//                System.out.println(heading.getLevel());
            }
        };
        visitor.visit(document);
        System.out.println(namespace.toString());
        System.out.println(document);
        System.out.println(mappers);
    }
}
