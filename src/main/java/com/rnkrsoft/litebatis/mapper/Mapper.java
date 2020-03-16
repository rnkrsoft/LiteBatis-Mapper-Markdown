package com.rnkrsoft.litebatis.mapper;

import com.rnkrsoft.litebatis.variable.VarTemplateParser;

/**
 * Created by woate on 2020/3/8.
 */
public class Mapper<T> {
    private String varTemplate;
    private MapperLoader mapperLoader;
    private Class<? extends MapperLoader> mapperLoaderClass;
    private Class<T> objectClass;
    private String placeholderSql;

    public Mapper(String varTemplate, MapperLoader mapperLoader, Class objectClass) {
        this.varTemplate = varTemplate;
        this.mapperLoader = mapperLoader;
        this.objectClass = objectClass;
    }

    /**
     * 解析Mapper为变量模板结果
     * @param object 对象
     * @return 变量模板结果
     */
    public VarTemplateParser.VarTemplateResult eval(T object){
        VarTemplateParser.VarTemplateResult result = VarTemplateParser.parseQuestionPlaceholder(varTemplate, object);
        return result;
    }
}
