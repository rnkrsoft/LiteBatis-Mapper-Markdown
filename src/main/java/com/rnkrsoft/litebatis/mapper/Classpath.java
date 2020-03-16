package com.rnkrsoft.litebatis.mapper;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by woate on 2020/3/9.
 */
public class Classpath {
    ClassLoader classLoader;

    String resource;

    /**
     * 根据传入的类加载器和classpath开头的文件路径构建一个Classpath对象
     * @param classLoader 类加载器
     * @param classpathFileName classpath格式描述的文件路径
     */
    public Classpath(ClassLoader classLoader, String classpathFileName) {
        this.classLoader = classLoader;
        if (classpathFileName == null) {
            throw new NullPointerException("classpathFileName is null");
        }
        int beginIndex = classpathFileName.indexOf("classpath:");
        if (beginIndex > -1) {
            this.resource = classpathFileName.substring("classpath:".length() + beginIndex);
        } else {
            throw new IllegalArgumentException("illegal classpath");
        }
    }

    /**
     * classpath:com.rnkrsoft.Demo.md
     *
     * @param classpathFileName
     */
    public Classpath(String classpathFileName) {
        this(null, classpathFileName);
    }

    /**
     * 加载资源，作为字符串形式
     *
     * @return
     */
    public String loadAsString(Charset charset) throws IOException {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(loadAsReader(charset));
            StringBuilder buffer = new StringBuilder(1024);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                buffer.append(line).append("\n");
            }
            return buffer.toString();
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }

    }

    public InputStream loadAsInputStream() throws IOException {
        if (classLoader == null) {
            classLoader = Thread.currentThread().getContextClassLoader();
        }
        URL url = classLoader.getResource(resource);
        return url.openStream();
    }

    public Reader loadAsReader(Charset charset) throws IOException {
        return new InputStreamReader(loadAsInputStream(), charset);
    }
}
