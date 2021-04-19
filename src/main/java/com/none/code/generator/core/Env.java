package com.none.code.generator.core;

import lombok.Getter;
import org.joor.Reflect;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import static org.joor.Reflect.on;

/**
 * @author lmly
 * @date 2021/04/15
 */
@Getter
public class Env {

    private static final Env ENV = new Env();

    //base 基本参数

    private final String targetProject;
    private final String targetPackage;
    private final String domain;
    private final String domainVariable;
    private final String author;
    private final String resources;
    private final String dir;


    String swap(String value) {
        Map<String, Reflect> fields = on(ENV).fields();
        for (Map.Entry<String, Reflect> field : fields.entrySet()) {
            if (value.contains(field.getKey())) {
                //执行替换
                String swap = field.getValue().get();
                return swap == null ? value : value.replace(field.getKey(), swap);
            }
        }
        return value;
    }

    public Env() {
        Properties properties = new Properties();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("meta-data.properties");
        try {
            properties.load(is);
        } catch (IOException ex) {
            //ignore
        }
        targetProject = properties.getProperty("targetProject");
        targetPackage = properties.getProperty("targetPackage");
        domain = properties.getProperty("domain");
        dir = properties.getProperty("dir");
        domainVariable = Character.toLowerCase(domain.charAt(0)) + domain.substring(1);
        author = properties.getProperty("author");
        resources = Objects.requireNonNull(classloader.getResource("")).getPath();
    }

}
