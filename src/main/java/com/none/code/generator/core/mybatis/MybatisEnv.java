package com.none.code.generator.core.mybatis;

import com.none.code.generator.core.Env;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author lmly
 * @date 2021/04/19
 */
@Getter
@Setter
public class MybatisEnv extends Env {
    private String jdbcUrl;
    private String username;
    private String password;
    private String table;

    public MybatisEnv() {
        Properties properties = new Properties();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("meta-data.properties");
        try {
            properties.load(is);
        } catch (IOException ex) {
            //ignore
        }
        jdbcUrl = properties.getProperty("jdbcUrl");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        table = properties.getProperty("table");
    }
}
