package com.rnkrsoft.litebatis.mapper;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.util.List;

/**
 * Created by woate on 2020/3/8.
 * Mapper文件加载器，其子类是用于指定文件格式的加载器，
 * 加载后都统一构建为Mapper对象存放在池中，与DataAccessObject进行绑定，
 * 也支持动态代理绑定到接口
 */
public interface MapperLoader {
    /**
     * 加载带有classpath:路径描述包路径下的Mapper文件
     * @param classpathMapperFileName classpath:路径描述的文件名
     * @return Mapper对象
     */
    List<Mapper> load(String classpathMapperFileName) throws IOException;

    /**
     * 通过本地的Mapper资源
     * @param mapperFile mapper文件对象
     * @return Mapper
     */
    List<Mapper> load(File mapperFile);

    /**
     * 通过URL加载远程或本地的Mapper资源
     * @param mapperUrl mapper统一资源符
     * @return Mapper
     */
    List<Mapper> load(URL mapperUrl);

    /**
     *
     * @param reader
     * @return
     */
    List<Mapper> load(Reader reader)throws IOException;
}
